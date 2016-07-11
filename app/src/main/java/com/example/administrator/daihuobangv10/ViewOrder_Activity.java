package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wsj on 16/7/4.
 */
public class ViewOrder_Activity extends Activity {

    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    private Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_order);

        //获取页面上的相关控件
        tb = (Toolbar) findViewById(R.id.toolbar_vieworder);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);
        tv8 = (TextView)findViewById(R.id.tv8);
        tv9 = (TextView)findViewById(R.id.tv9);
        tv10 = (TextView)findViewById(R.id.tv10);

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

        Bundle bundle = getIntent().getExtras();


    }
}
