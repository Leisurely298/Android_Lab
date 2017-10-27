package com.example.administrator.lab3;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    int number = 0;
    String message;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = getIntent().getStringExtra("name2");
        final String namearray []= getResources().getStringArray(R.array.name_array);
        String pricearray [] = getResources().getStringArray(R.array.price_array);
        String messagearray [] = getResources().getStringArray(R.array.message_array);
        String choice [] = getResources().getStringArray(R.array.list);

        TypedArray picture_array = getResources().obtainTypedArray(R.array.picture);

        ImageButton back = (ImageButton) findViewById(R.id.back);

        final ImageButton star = (ImageButton) findViewById(R.id.img);

        TextView price = (TextView)findViewById(R.id.price);
        TextView details = (TextView)findViewById(R.id.details);
        TextView secondname = (TextView)findViewById(R.id.secondname);
        final ImageView picture = (ImageView)findViewById(R.id.picture);
        final ImageView shoplist = (ImageView)findViewById(R.id.shoplist);

        int namearraylen = namearray.length;

        for (int i = 0; i < namearraylen;i ++)
        {
            if (message.equals(namearray[i]))
            {
                position = i;
                break;
            }
        }
        price.setText(pricearray[position]);
        details.setText(messagearray[position]);
        picture.setImageResource(picture_array.getResourceId(position, 0));
        secondname.setText(message);
        star.setBackgroundResource(R.mipmap.empty_star);

        List<Map<String,Object>> data = new ArrayList<>();

        int choicelen = choice.length;

        for (int i = 0; i < choicelen; i ++)
        {
            Map<String,Object> temp = new LinkedHashMap<>();
            temp.put("choice",choice[i]);
            data.add(temp);
        }
        ListView listView = (ListView)findViewById(R.id.second_listview);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,R.layout.seconditem,new String[]{"choice"},new int[]{R.id.edit});
        listView.setAdapter(simpleAdapter);


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number ++;
                if (number % 2 == 0)
                    star.setBackgroundResource(R.mipmap.empty_star);
                else
                    star.setBackgroundResource(R.mipmap.full_star);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.this.finish();
            }
        });

        shoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent(position));
                Snackbar.make(shoplist, "已加入购物车",Snackbar.LENGTH_INDEFINITE)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .setDuration(5000)
                        .show();
            }
        });
    }
}
