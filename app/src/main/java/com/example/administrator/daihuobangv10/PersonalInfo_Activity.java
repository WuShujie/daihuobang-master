package com.example.administrator.daihuobangv10;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by wsj on 16/6/29.
 */
public class PersonalInfo_Activity extends Activity{

    private ImageButton imgbtn;
    private Bitmap head;
    private static String path = "/sdcard/";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        //获取页面相关控件
        final CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.layout);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);

        //设置标题栏内容：title，返回按钮，右上菜单
        tb.setTitle("个人信息");
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
        tb.inflateMenu(R.menu.personal_info);
        tb.setOnMenuItemClickListener(MenuItemClickListener);

        imgbtn = (ImageButton) findViewById(R.id.imgbtn);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivity(intent);
            }
        });


        Bitmap bt = BitmapFactory.decodeFile(path+"head.png");
        Drawable drawable = new BitmapDrawable(bt);
        imgbtn.setBackground(drawable);
    }

    //菜单点击监听响应
    private Toolbar.OnMenuItemClickListener MenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "";
            switch (item.getItemId()){
                case R.id.action:
                    msg += "click edit";
                    break;
            }
            if(!msg.equals(""))
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
