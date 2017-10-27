package com.example.administrator.lab3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;


public class StaticReciever extends BroadcastReceiver {
    private static String STATICACTION = "static_broadcast_name";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(STATICACTION)) {
            int [] picture_n = {R.mipmap.arla,R.mipmap.borggreve, R.mipmap.devondale,R.mipmap.enchatedforest
                , R.mipmap.ferrero,R.mipmap.kindle,R.mipmap.lindt,R.mipmap.maltesers,R.mipmap.mcvitie,R.mipmap.waitrose};
            String s = intent.getStringExtra("name1");
            String p = intent.getStringExtra("price1");
            int position = intent.getIntExtra("position1",0);
            Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),picture_n[position]);
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle("新品"+ s + "已上线")
                    .setContentText("仅售"+ p+"赶紧买买买！！！")
                    .setTicker("你有一条消息")
                    .setLargeIcon(bmp)
                    .setSmallIcon(picture_n[position])
                    .setAutoCancel(true);

            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            Intent finalintent = new Intent(context,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,finalintent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            Notification notification = builder.build();
            manager.notify(0,notification);
        }
    }
}
