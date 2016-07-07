package com.example.administrator.daihuobangv10;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by wsj on 16/6/29.
 */
public class PersonalInfo_Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        //获取页面相关控件
        final CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        Button btn_modifyinfo = (Button) findViewById(R.id.btn_modifyinfo);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);

        collapsingToolbarLayout.setTitle("个人信息");

        setSupportActionBar(tb);
        //设置标题栏内容：title，返回按钮，右上菜单
        tb.setTitle("个人信息");
        tb.setTitleTextColor(Color.parseColor("#ffffff"));
        tb.setNavigationIcon(R.drawable.ic_return);
        tb.inflateMenu(R.menu.personal_info);

        //设置标题栏左边返回按钮的响应事件
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

        //设置标题栏上菜单的监听响应——跳转到下一页面对个人信息进行修改
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo_Activity.this,EditInfo_Activity.class);
                startActivityForResult(intent,1);
                return true;
            }
        });

        //设置页面内信息修改按钮的监听响应——跳转到对个人信息的修改
        btn_modifyinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo_Activity.this,EditInfo_Activity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_info,menu);
        return true;
    }
}
