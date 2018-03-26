package yincheng.androidinterviwepoint.primary.componentInteraction.service2activity.method2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by commi on 2018/3/23.
 */

public class Service2Activity2 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class ServiceBinder extends Binder {

    }
}
