package com.mashup.fourten.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.mashup.fourten.R
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.databinding.ActivityLoginBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.ui.nickname.NicknameActivity
import com.mashup.fourten.util.Event
import com.mashup.fourten.util.EventObserver
import com.mashup.fourten.util.GoogleSignInClient
import com.mashup.fourten.util.ext.start
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel by viewModel()

    companion object {
        const val RC_SIGN_IN = 9001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                JadoPreferences.googleToken = account.idToken!!.take(50)
                viewModel.idCheck()
            } catch (e: ApiException) {
                Log.w("!", "Google sign in failed", e)
            }
        }
    }

    fun signIn() {
        val signInIntent = GoogleSignInClient.mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun init() {
        binding.activity = this
        val googleSiginInButton: SignInButton = findViewById<SignInButton>(R.id.gb_sign_in_button)
        googleSiginInButton.setOnClickListener { this.signIn() }
        GoogleSignInClient.init(this)
        viewModel.idCheckedField.observe(this, EventObserver<Boolean> {
            when (it) {
                true -> {
                    start(MainActivity::class)
                    finish()
                }
                false -> start(NicknameActivity::class)
            }
        })
    }
}
