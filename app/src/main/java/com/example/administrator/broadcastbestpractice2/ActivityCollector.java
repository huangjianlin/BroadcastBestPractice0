package com.example.administrator.broadcastbestpractice2;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2017/4/5 0005.
 * 强制下线功能需要先关闭掉所有的活动，然后回到登录界面
 * 该类用于管理所有的活动
 */
public class ActivityCollector {
    public static List<Activity> activities =new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
