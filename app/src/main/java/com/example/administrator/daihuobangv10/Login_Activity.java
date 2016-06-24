package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by wsj on 16/6/23.
 */
public class Login_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_findpwd = (Button) findViewById(R.id.btn_findpwd);
        Button btn_regist = (Button) findViewById(R.id.btn_regist);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
