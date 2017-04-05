package com.example.administrator.broadcastbestpractice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**
 * A login screen that offers login via email/password.
 * 登录界面控制类
 */
public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //定义登录名控件
        accountEdit=(EditText) findViewById(R.id.account);
        //定义登录密码控件
        passwordEdit=(EditText) findViewById(R.id.password);
        //定义登录按钮
        login=(Button) findViewById(R.id.login);
        //登录按钮点击事件
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               //获取登录名
                String account=accountEdit.getText().toString();
                //获取登录密码
                String password=passwordEdit.getText().toString();
                //设置固定账号和密码
                if(account.equals("admin") && password.equals("123456")){
                    //匹配成功时就进入主界面MainActivity
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    //否则提示错误
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

