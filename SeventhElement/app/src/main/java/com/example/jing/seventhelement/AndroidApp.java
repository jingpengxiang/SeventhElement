package com.example.jing.seventhelement;

import android.app.Application;
import android.content.Context;

import com.example.jing.seventhelement.base.LogicProxy;

/**
 * 项目名称： SeventhElement
 * 创建人： Jing
 * 创建时间： 16/7/31  10:39
 * 修改备注：
 */
public class AndroidApp extends Application{


    private static AndroidApp instance = new AndroidApp();
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        LogicProxy.getInstance().init(/*每增加一个实现类，在这里加上*/);
    }

    public static AndroidApp getInstance(){

        return instance;
    }

    public static Context getContext(){
        return context;
    }

}
