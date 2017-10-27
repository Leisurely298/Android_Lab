package com.example.administrator.lab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.jar.Attributes;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;

public class MainActivity extends AppCompatActivity {
    private static String STATICACTION = "static_broadcast_name";
    private Random random = new Random();
    private  CommonAdapter.OnItemClickListener mOnitemClickListener;
    int count = 0, position1 = 0;

    @Subscribe(threadMode = ThreadMode.MAIN)

    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, (CharSequence) event, Toast.LENGTH_LONG).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        final List<Map<String, Object>> data = new ArrayList<>();
        final List<NameMenu> data1 = new ArrayList<>();
        final String[] Name = getResources().getStringArray(R.array.name_array);
        final String[] Price = getResources().getStringArray(R.array.price_array);
        final String[] First_Letter = getResources().getStringArray(R.array.firstletter_array);

        position1 = random.nextInt(10);
        Intent intent = new Intent(STATICACTION);
        intent.putExtra("name1", Name[position1]);
        intent.putExtra("price1", Price[position1]);
        intent.putExtra("position1",position1);

        sendBroadcast(intent);

        final FloatingActionButton floatingActionButton  = (FloatingActionButton)findViewById(R.id.flb);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);

        final ListView listView1 = (ListView)findViewById(R.id.list_view1);

        final MyAdapter simpleAdapter1 = new MyAdapter(this, data1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i=0; i< 10 ; i++){
            Map<String, Object> temp  = new LinkedHashMap<>();
            temp.put("name", Name[i]);
            temp.put("first", First_Letter[i]);
            data.add(temp);
        }
        final CommonAdapter commonAdapter = new CommonAdapter<Map<String, Object>>(this, R.layout.listview_item, data) {
            @Override
            public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
                convert((ViewHolder) holder, data.get(position));
                if(mOnitemClickListener != null){
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnitemClickListener.onClick(holder.getAdapterPosition());
                        }
                    });
                    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            mOnitemClickListener.onLongClick(holder.getAdapterPosition());
                            return false;
                        }
                    });
                }
            }
            @Override
            public void convert(ViewHolder holder, Map<String, Object> s) {
                TextView name = holder.getView(R.id.name);
                name.setText(s.get("name").toString());
                TextView first = holder.getView(R.id.first_letter);
                first.setText(s.get("first").toString());
            }
        };
        commonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onClick( int position) {
                Toast.makeText(getApplicationContext(), "移除第"+position+"个商品",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick( int position) {
                Toast.makeText(getApplicationContext(), "长打",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final CommonAdapter.ViewHolder viewHolder =CommonAdapter.ViewHolder.get(this, null, R.layout.listview_item);


        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(commonAdapter);
        animationAdapter.setDuration(1000);
        recyclerView.setAdapter(animationAdapter);
        recyclerView.setItemAnimator(new OvershootInLeftAnimator());
        listView1.setAdapter(simpleAdapter1);
        listView1.setVisibility(View.INVISIBLE);


        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                NameMenu name_pair = (NameMenu)simpleAdapter1.getItem(position);
                String name_name = name_pair.getName();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("移除商品")
                        .setMessage("从购物车中移除" + name_name + "?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        data.remove(position);
                                        simpleAdapter1.notifyDataSetChanged();
                                    }
                                }
                        )
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
                return true;
            }
        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                if(count % 2 == 1){
                    recyclerView.setVisibility(View.INVISIBLE);
                    floatingActionButton.setImageResource(R.drawable.mainpage);
                    listView1.setVisibility(View.VISIBLE);
                }

                else{
                    recyclerView.setVisibility(View.VISIBLE);
                    listView1.setVisibility(View.INVISIBLE);
                    floatingActionButton.setImageResource(R.drawable.shoplist);
                }
            }
        });


    }
}
