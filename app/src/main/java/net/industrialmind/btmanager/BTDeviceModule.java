package net.industrialmind.btmanager;

import android.app.Activity;

import net.industrialmind.btmanager.components.IPairedBluetoothDeviceListActivitySubcomponent;
import net.industrialmind.btmanager.device.BluetoothDeviceService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by srn7919 on 04.06.17.
 */
@Module(subcomponents = {IPairedBluetoothDeviceListActivitySubcomponent.class})
public abstract class BTDeviceModule {

    @Binds
    @IntoMap
    @ActivityKey(PairedBluetoothDeviceListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(IPairedBluetoothDeviceListActivitySubcomponent.Builder builder);
}
