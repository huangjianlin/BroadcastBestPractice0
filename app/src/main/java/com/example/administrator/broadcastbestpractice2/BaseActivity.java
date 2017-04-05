package com.example.administrator.broadcastbestpractice2;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
/**
 * Created by Administrator on 2017/4/5 0005.
 * 该类作为所有活动的父类，接收广播指令，在这里执行
 * 处于栈顶的活动需要接收广播命令，非栈顶的活动就要取消接收，因此采用了onResume和onPause生命周期函数
 */

public class BaseActivity extends AppCompatActivity{
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        //接收下线广播命令
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
        //启动执行下线操作方法
        receiver=new ForceOfflineReceiver();
        //注册广播接收器
        registerReceiver(receiver,intentFilter);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(receiver!=null){
            //取消注册广播接收器
            unregisterReceiver(receiver);
            receiver=null;
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
    //下线操作的方法
    class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            //先定义一个对话框，点击按钮后，弹出来的框
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("注意");
            builder.setMessage("你已下线，请重新登录！");
            //设置对话框不可取消，强制执行
            builder.setCancelable(false);
            //定义对话框里的确定按钮事件
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //销毁所有活动
                    ActivityCollector.finishAll();
                    Intent intent=new Intent(context,LoginActivity.class);
                    //重启LoginActivity
                    context.startActivity(intent);
                }
            });
            builder.show();

        }
    }

}
