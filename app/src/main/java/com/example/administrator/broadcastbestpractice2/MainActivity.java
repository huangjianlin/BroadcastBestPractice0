package com.example.administrator.broadcastbestpractice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义强制下线的按钮
        Button forceOffline=(Button) findViewById(R.id.force_offline);
        //下线按钮点击事件，用于发送下线的命令，相当于领导发布指令
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播值，通知强制下线
                Intent intent =new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}