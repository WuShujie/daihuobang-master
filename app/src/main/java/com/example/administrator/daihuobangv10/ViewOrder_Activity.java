package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by wsj on 16/7/4.
 */
public class ViewOrder_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order);

        //获取页面上的相关控件
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar_vieworder);
//        Button btn = (Button) findViewById(R.id.btn_receiveorder);

        //设置菜单栏的title及左上返回按钮并监听
        tb.setTitle("查看订单");
        tb.setTitleTextColor(Color.parseColor("#ffffff"));
        tb.setNavigationIcon(R.drawable.ic_return);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        //设置开始接单按钮的点击监听响应事件
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"跳转到接单导航页面",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
