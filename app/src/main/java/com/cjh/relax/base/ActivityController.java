package com.cjh.relax.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    private static List<Activity> activities = new ArrayList<>();


    /**
     * 将增加的activity添加到存放activity的列表中
     * @param addActivity
     */
    public static void addActivity(Activity addActivity){

        activities.add(addActivity);

    }

    /**
     * 从activity列表中activity
     * @param reActivity
     */
    public static void removeActivity(Activity reActivity){

        activities.remove(reActivity);

    }

    /**
     * activity列表中的活动全部清除
     */
    public static void AllFinish(){

        if (activities != null){

            for (Activity activity : activities){

                activity.finish();

            }

        }

    }

}
