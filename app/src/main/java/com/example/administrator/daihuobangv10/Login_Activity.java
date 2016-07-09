package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.daihuobangv10.Dao.User;
import com.example.administrator.daihuobangv10.util.HttpConnect;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by wsj on 16/6/23.
 */
public class Login_Activity extends Activity implements View.OnClickListener{

    private SharedPreferences sp;
    private String phone,pwd;
    private Button btn_login;
    private Button btn_regist;
    private EditText et_phonenum;
    private EditText et_pwd;
    private CheckBox cb_rempwd,cb_autologin;

//利用handler接收子线程的消息并在主线程处理
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    //接收传来的信息
                    String s = msg.obj.toString();
                    Log.i("tag",s);

                    if (s.equals("-1")) {
                        Toast.makeText(getApplicationContext(),"输入的手机号与密码不匹配",Toast.LENGTH_SHORT).show();
//                        setDialog("输入的手机号与密码不匹配");  //弹出对话框提示
                    }else {
                        try{
                            //将string转化为JSON并逐一获取object中的内容，写入到user类中
                            JSONArray ja = new JSONArray(s);
                            JSONObject json = ja.getJSONObject(0);

                            User.id = json.getString("id");
                            User.username = json.getString("name");
                            User.password = json.getString("phonenumber");
                            User.idcardNum = json.getString("idnumber");
                            Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();

                        }catch (Exception e) {
                            e.printStackTrace();
                        }

                        //跳转到用户主界面
                        Intent intent1 = new Intent();
                        intent1.setClass(Login_Activity.this,SideSlip_Activity.class);
                        Login_Activity.this.startActivity(intent1);
                    }
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //获取页面上的相关控件
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_toregist);
        et_phonenum = (EditText) findViewById(R.id.et_phonenum);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        cb_rempwd = (CheckBox) findViewById(R.id.checkbox_rememberpwd);
        cb_autologin = (CheckBox)findViewById(R.id.checkbox_autologin);

        //利用sharepreference存储记住的用户名密码
        sp = getSharedPreferences("userInfo",0);
        final String phone = sp.getString("PHONE","");
        final String password = sp.getString("PASSWORD","");
        boolean remember = sp.getBoolean("remember",false);
        boolean autologin = sp.getBoolean("autologin",false);

        if (remember) {
            et_phonenum.setText(phone);
            et_pwd.setText(password);
            cb_rempwd.setChecked(true);
        }
        if (autologin) {
            cb_autologin.setChecked(true);
        }

//为登录按钮设置监听
        btn_login.setOnClickListener(this);
//为注册按钮设置监听
        btn_regist.setOnClickListener(this);
    }

//    实现onclick接口，响应点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:    //对登录按钮的响应

//                从edittext中获取用户输入的内容
                phone = et_phonenum.getText().toString();
                pwd = et_pwd.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                //将获取到的内容存入到sharepreference的editor中
                editor.putString("PHONE",phone);
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

                //拼接URL
                final String url = "http://120.27.48.82:3000/user/logIn?"+"phoneNumber="+phone+"&userPassword="+pwd;

                Log.i("tag",url);

                //新建线程进行网络访问
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            String response = HttpConnect.doget(url);   //网络访问

                            //将后台返回的数据利用message发送给主线程的handler处理
                            Message msg = Message.obtain();
                            msg.what = 1;
                            msg.obj = response;
                            handler.sendMessage(msg);
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;

            case R.id.btn_toregist: //注册按钮的响应
                //跳转到主界面
                Intent intent2 = new Intent();
                intent2.setClass(Login_Activity.this,Regist_Activity.class);
                Login_Activity.this.startActivity(intent2);
                break;
        }
    }

    /**
     * 弹出对话框提示
     * @param msg
     */
    public void setDialog(String msg) {
        new AlertDialog.Builder(getApplicationContext())
                .setTitle("提示")
                .setMessage(msg)
                .setNegativeButton("确认",null)
                .show();
    }
}
