package yincheng.androidinterviwepoint;

import android.app.Application;

import yincheng.androidinterviwepoint.adapter.Utils;

/**
 * Mail : luoyincheng@gmail.com
 * Date   : 2018:04:01 14:31
 * Github : yincheng.luo
 */

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
    }
}
