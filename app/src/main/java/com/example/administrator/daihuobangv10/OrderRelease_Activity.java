package com.example.administrator.daihuobangv10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by wsj on 16/7/1.
 */
public class OrderRelease_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_release);


//        获取页面里各个控件
        final CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout_order_release);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar_order_release);
        Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        Spinner sp3 = (Spinner) findViewById(R.id.spinner3);
        Button btn = (Button) findViewById(R.id.btn_order_release);


//        为标题栏设置添加title及左上的返回按钮
        setSupportActionBar(tb);
        tb.setTitle("带货帮");
        tb.setNavigationIcon(R.drawable.ic_return);


//        从array中获取下拉列表内容
        String[] release = getResources().getStringArray(R.array.release);
        String[] distance = getResources().getStringArray(R.array.distance);
        String[] time_extra = getResources().getStringArray(R.array.time_extra);


//        给每个下拉列表设置adapter以及列表项的选择进行监听且响应
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,release);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] release = getResources().getStringArray(R.array.release);
                Snackbar.make(layout,release[position
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

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,distance);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] distance = getResources().getStringArray(R.array.distance);
                Snackbar.make(layout,distance[position
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

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,time_extra);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] time_extra = getResources().getStringArray(R.array.time_extra);
                Snackbar.make(layout,time_extra[position
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


//        发布运力按钮的点击监听响应事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
