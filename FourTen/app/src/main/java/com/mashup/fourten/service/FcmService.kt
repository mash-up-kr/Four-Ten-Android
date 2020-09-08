package com.mashup.fourten.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.mashup.fourten.util.NotificationBuilder
import com.mashup.fourten.util.ext.e
import com.mashup.fourten.util.ext.getOrDefaultNougat

/**
 * Created by Namget on 2020.07.25.
 */
class FcmService : FirebaseMessagingService() {

    override fun onMessageReceived(remote: RemoteMessage) {
        val title = remote.data.getOrDefaultNougat("title", "")
        val content = remote.data.getOrDefaultNougat("message", "")
        e("FcmService", "title : $title")
        e("FcmService", "content : $content")
        if (!title.isNullOrEmpty() && !content.isNullOrEmpty())
            NotificationBuilder.showNotification(this, title, content)
    }

    override fun onNewToken(token: String) {
        e("FcmService", "newToken : $token")
    }

    private fun showNotification() {

    }
}