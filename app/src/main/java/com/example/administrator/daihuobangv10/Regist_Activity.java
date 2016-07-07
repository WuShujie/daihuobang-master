package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.daihuobangv10.util.HttpConnect;

/**
 * Created by wsj on 16/6/23.
 */
public class Regist_Activity extends Activity implements View.OnClickListener{

    private EditText et_username;
    private EditText et_password;
    private EditText et_phone;
    private EditText et_idnum;
    private EditText et_repwd;
    private Button regist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);


        regist = (Button) findViewById(R.id.btn_regist);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_pwd);
        et_repwd = (EditText) findViewById(R.id.et_repwd);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_idnum = (EditText)findViewById(R.id.et_idcard);





        regist.setOnClickListener(this);
//                TextInputLayout input = (TextInputLayout)findViewById(R.id.textinput);
//                if (repwd.equalsIgnoreCase(pwd)){
//                    input.setError("right!");
//                }
//                else
//                    input.setErrorEnabled(false);
//                    input.setError("not the same password!");






    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 2:
                    String s = (String)msg.obj;
                    if (!s.equals(0)) {
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(Regist_Activity.this,SideSlip_Activity.class);
                        Regist_Activity.this.startActivity(intent);
                    }
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        final String username = et_username.getText().toString();
        final String pwd = et_password.getText().toString().trim();
        final String repwd = et_repwd.getText().toString().trim();
        final String phone = et_phone.getText().toString().trim();
        final String idnum = et_idnum.getText().toString().trim();

        final String url = "http://localhost:3000/user/addUser?"+"userName="+username+"&userPassword="+pwd+
                "&phoneNumber="+phone+"&idNumber="+idnum;

        Log.i("url",url);



        new Thread() {
            @Override
            public void run() {
                try {

                    String response = HttpConnect.doget(url);

                    Message msg = Message.obtain();
                    msg.what = 2;
                    msg.obj = response;
                    handler.sendMessage(msg);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
