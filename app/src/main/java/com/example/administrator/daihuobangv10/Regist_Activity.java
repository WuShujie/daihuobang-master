package com.example.administrator.daihuobangv10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by wsj on 16/6/23.
 */
public class Regist_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);

        Button btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Regist_Activity.this,SideSlip_Activity.class);
                Regist_Activity.this.startActivity(intent);
            }
        });
    }
}
