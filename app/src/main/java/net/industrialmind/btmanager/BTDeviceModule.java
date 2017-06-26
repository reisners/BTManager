package net.industrialmind.btmanager;

import net.industrialmind.btmanager.device.BluetoothDeviceService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by srn7919 on 04.06.17.
 */
@Module
public class BTDeviceModule {

    BluetoothDeviceService btDeviceService;

    public BTDeviceModule(BluetoothDeviceService btDeviceService) {
        this.btDeviceService = btDeviceService;
    }

    @Provides
    @Singleton
    BluetoothDeviceService providesBluetoothDeviceService() {
        return btDeviceService;
    }
}
