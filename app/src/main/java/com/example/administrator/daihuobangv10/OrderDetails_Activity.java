package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by wsj on 16/6/27.
 *
 */
public class OrderDetails_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);

        //获取页面上的各种控件
        Button btn = (Button) findViewById(R.id.btn_order);
        Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        final CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout1);

        //从array数组中读取到各个下拉列表项内容
        String[] kinds = getResources().getStringArray(R.array.kinds);
        String[] pays = getResources().getStringArray(R.array.pay);
        String[] time = getResources().getStringArray(R.array.time);

        //设置标题栏样式：title，返回按钮，以及返回的监听响应
        android.support.v7.widget.Toolbar tb = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar1);
        tb.setTitle("带货帮");
        tb.setTitleTextColor(Color.parseColor("#ffffff"));
        tb.setNavigationIcon(R.drawable.ic_return);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layout,"return",Snackbar.LENGTH_LONG).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
        });


        //确认订单按钮的点击监听响应
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layout,"已确认订单",Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
        });


        //为每个下拉列表spinner设置adapter以及列表项的选择监听

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,kinds);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] kinds = getResources().getStringArray(R.array.kinds);
                Snackbar.make(layout,kinds[position
                        ],Snackbar.LENGTH_SHORT).setAction("right",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,pays);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] pays = getResources().getStringArray(R.array.pay);
                Snackbar.make(layout,pays[position
                        ],Snackbar.LENGTH_SHORT).setAction("right",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,time);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] time = getResources().getStringArray(R.array.time);
                Snackbar.make(layout,time[position
                        ],Snackbar.LENGTH_SHORT).setAction("right",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}
