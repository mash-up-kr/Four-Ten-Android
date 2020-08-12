package com.mashup.fourten.util

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.mashup.fourten.R

object GoogleSignInClient {

    lateinit var mGoogleSignInClient: GoogleSignInClient

    fun init(context: Context) {
        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.server_client_id))
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(context, gso)
    }
}