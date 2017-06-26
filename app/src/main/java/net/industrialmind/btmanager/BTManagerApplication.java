package net.industrialmind.btmanager;

import android.app.Application;

import net.industrialmind.btmanager.device.BluetoothDeviceService;

/**
 * Created by srn7919 on 04.06.17.
 */

public class BTManagerApplication extends Application {

    private BTComponent btComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        btComponent = DaggerBTComponent.builder().bTDeviceModule(new BTDeviceModule(new BluetoothDeviceService())).build();
    }

    public BTComponent getBTComponent() {
        return btComponent;
    }
}
