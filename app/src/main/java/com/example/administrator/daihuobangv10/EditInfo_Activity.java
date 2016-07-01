package com.example.administrator.daihuobangv10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by wsj on 16/7/1.
 */
public class EditInfo_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_info);

        final CoordinatorLayout layout = (CoordinatorLayout)findViewById(R.id.layout_coor);
        Button btn = (Button) findViewById(R.id.btn_edit_yes);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar_edit_info);
        setSupportActionBar(tb);

        //设置标题栏的返回按钮图标
        tb.setNavigationIcon(R.drawable.ic_return);

        //设置标题栏按钮的点击响应事件——结束该页面并返回上一页面
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //为确认修改按钮设置监听响应
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layout,"Edit Confirm!",Snackbar.LENGTH_LONG).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });
    }
}
