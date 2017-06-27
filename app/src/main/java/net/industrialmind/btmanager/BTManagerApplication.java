package net.industrialmind.btmanager;

import android.app.Activity;
import android.app.Application;

import net.industrialmind.btmanager.device.BluetoothDeviceService;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

/**
 * Created by srn7919 on 04.06.17.
 */

public class BTManagerApplication extends Application implements HasDispatchingActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerIApplicationComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
