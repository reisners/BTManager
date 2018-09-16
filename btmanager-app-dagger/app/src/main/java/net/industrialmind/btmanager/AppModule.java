package net.industrialmind.btmanager;

import android.content.Context;

import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceDetailFragmentSubcomponent;
import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceListActivitySubcomponent;
import net.industrialmind.btmanager.manager.BluetoothDeviceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by srn7919 on 04.06.17.
 */
@Module(subcomponents = {PairedBluetoothDeviceListActivitySubcomponent.class, PairedBluetoothDeviceDetailFragmentSubcomponent.class})
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    BluetoothDeviceManager provideBluetoothDeviceService() {
        return new BluetoothDeviceManager();
    }
}
