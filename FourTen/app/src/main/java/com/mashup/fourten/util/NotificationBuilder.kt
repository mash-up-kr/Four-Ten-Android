package com.mashup.fourten.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.mashup.fourten.R

/**
 * Created by Namget on 2020.07.25.
 */
class NotificationBuilder {
    companion object {
        fun createNotificationChannel(
            context: Context,
            channelId: String = context.getString(R.string.notification_default_channel_id),
            importance: Int = NotificationManager.IMPORTANCE_HIGH,
            showBadge: Boolean = false,
            name: String = context.getString(R.string.notification_default_channel_name),
            description: String = context.getString(R.string.notification_default_channel_description)
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager = context.getSystemService(NotificationManager::class.java)
                if (notificationManager?.getNotificationChannel(channelId) == null) {
                    val channel = NotificationChannel(channelId, name, importance)
                    channel.description = description
                    channel.setShowBadge(showBadge)
                    notificationManager?.createNotificationChannel(channel)
                }
            }
        }

        fun showNotification(
            context: Context,
            title : String,
            content : String,
            CHANNEL_ID: String = context.getString(R.string.notification_default_channel_id)
        ) {
            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.app_icon)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(
                    NotificationCompat.BigTextStyle().bigText(content)
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            NotificationManagerCompat.from(context).notify(11, notification)
        }
    }
}