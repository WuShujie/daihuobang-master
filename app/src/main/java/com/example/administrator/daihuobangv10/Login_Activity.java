package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by wsj on 16/6/23.
 */
public class Login_Activity extends Activity {

    private SharedPreferences sp;
    private String username,pwd;
    private Button btn_login;
    private Button btn_regist;
    private EditText et_username;
    private EditText et_pwd;
    private CheckBox cb_rempwd,cb_autologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //获取页面上的相关控件
        btn_login = (Button) findViewById(R.id.btn_login);
//        Button btn_findpwd = (Button) findViewById(R.id.btn_findpwd);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        et_username = (EditText) findViewById(R.id.et_username);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        cb_rempwd = (CheckBox) findViewById(R.id.checkbox_rememberpwd);
        cb_autologin = (CheckBox)findViewById(R.id.checkbox_autologin);

        sp = getSharedPreferences("userInfo",0);
        final String name = sp.getString("USERNAME","");
        final String password = sp.getString("PASSWORD","");
        boolean remember = sp.getBoolean("remember",false);
        boolean autologin = sp.getBoolean("autologin",false);

        if (remember) {
            et_username.setText(name);
            et_pwd.setText(password);
            cb_rempwd.setChecked(true);
        }

        if (autologin) {
            cb_autologin.setChecked(true);
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = et_username.getText().toString();
                pwd = et_pwd.getText().toString();
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("USERNAME",username);
                editor.putString("PASSWORD",pwd);

                if (cb_rempwd.isChecked())
                    editor.putBoolean("remember",true);
                else
                    editor.putBoolean("remember",false);

                if (cb_autologin.isChecked())
                    editor.putBoolean("autologin",true);
                else
                    editor.putBoolean("autologin",false);

                editor.commit();









                Intent intent = new Intent();
                intent.setClass(Login_Activity.this,SideSlip_Activity.class);
                Login_Activity.this.startActivity(intent);
            }
        });

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login_Activity.this,Regist_Activity.class);
                Login_Activity.this.startActivity(intent);
            }
        });


    }
}
