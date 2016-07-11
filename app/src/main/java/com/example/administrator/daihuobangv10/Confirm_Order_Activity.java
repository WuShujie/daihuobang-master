package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wsj on 16/7/6.
 */
public class Confirm_Order_Activity extends Activity {

    private ListView lv;
    private Button btn;
    private Toolbar tb;
    static ArrayList<HashMap<String,Object>> listitem;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        listitem = new ArrayList<>();

        //获取页面上的控件
        tb = (Toolbar) findViewById(R.id.toolbar_confirm_order);
        lv = (ListView) findViewById(R.id.lv_confirm_order);
        btn = (Button)findViewById(R.id.btn_confirm_order);

        // 为标题栏设置添加title及左上的返回按钮
        tb.setTitle("带货帮");
        tb.setTitleTextColor(Color.parseColor("#ffffff"));
        tb.setNavigationIcon(R.drawable.ic_return);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置list view的adapter适配器
        adapter = new SimpleAdapter(this,getData(),R.layout.item_confirm_order,
                new String[]{"tv_start","tv_end","tv_price"},
                new int[]{R.id.tv_start,R.id.tv_end,R.id.tv_price});
        //为list view绑定适配器
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm_Order_Activity.this,ViewOrder_Activity.class);
                startActivityForResult(intent,1);
            }
        });

        //设置list view的item项的点击监听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Confirm_Order_Activity.this,ViewOrder_Activity.class);
                startActivityForResult(intent,1);
            }
        });

        //设置list view的item项的长按事件
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int p = position;
                listitem.remove(p);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"删除第"+(p+1)+"项货物",Toast.LENGTH_LONG).show();
                return true;

            }
        });
    }


    private ArrayList<HashMap<String,Object>> getData() {
        for (int i=0;i<5;i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("tv_start","起点:华南理工大学大学城校区B7-233");
            map.put("tv_end", "终点:中山大学大学城校区正门");
            map.put("tv_price","RMB 10");
            listitem.add(map);
        }
        return listitem;
    }
}
