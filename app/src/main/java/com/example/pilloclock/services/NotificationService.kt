package com.example.pilloclock.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class NotificationService {
    @RequiresApi(Build.VERSION_CODES.M)
    fun scheduleNotification(applicationContext: Context,
                             notificationTitleStr: String,
                             notificationMessageStr: String,
                             appCompatActivity: AppCompatActivity,
                             calendar: Calendar) {
        val intent = Intent(applicationContext, MyAlarmReceiver::class.java)
        intent.putExtra(notificationTitle,notificationTitleStr)
        intent.putExtra(notificationMessage,notificationMessageStr)

        val pIntent = PendingIntent.getBroadcast(
            applicationContext, notificatioID,
            intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarm = appCompatActivity.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager

        alarm.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,pIntent
        )
    }
}