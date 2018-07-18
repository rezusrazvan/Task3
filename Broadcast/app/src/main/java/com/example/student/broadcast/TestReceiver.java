package com.example.student.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class TestReceiver extends BroadcastReceiver {

    public TestReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("API123", "" + intent.getAction());

        if (intent.getAction().equals("com.example.student.broadcast.START_NOTIFICARI")){
            Toast.makeText(context,"Notificarea START a fost apasata", Toast.LENGTH_LONG).show();

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
            Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journaldev.com/"));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentView, 0);
            builder.setContentIntent(pendingIntent);
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
            builder.setContentTitle("Titlul Notificarilor.");
            builder.setContentText("Notificarile tale sunt aici.");
            builder.setSubText("Apasa pentru a vedea site-ul.");
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1,builder.build());
        }
        else if (intent.getAction().equals("com.example.student.broadcast.STOP_NOTIFICARI")){
            Toast.makeText(context,"Notificarea STOP a fost apasata", Toast.LENGTH_LONG).show();
            String notificari = Context.NOTIFICATION_SERVICE;
            NotificationManager nMgr = (NotificationManager) context.getApplicationContext().getSystemService(notificari);

            nMgr.cancel(1);
        }


    }
}
