package me.zircon.v2test;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/29 <br>
 */
public class V2Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
