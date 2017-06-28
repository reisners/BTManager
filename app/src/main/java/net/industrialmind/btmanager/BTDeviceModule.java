package net.industrialmind.btmanager;

import android.app.Activity;
import android.app.Fragment;

import net.industrialmind.btmanager.components.IPairedBluetoothDeviceDetailFragmentSubcomponent;
import net.industrialmind.btmanager.components.IPairedBluetoothDeviceListActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by srn7919 on 04.06.17.
 */
@Module(subcomponents = {IPairedBluetoothDeviceListActivitySubcomponent.class, IPairedBluetoothDeviceDetailFragmentSubcomponent.class})
public abstract class BTDeviceModule {

    @Binds
    @IntoMap
    @ActivityKey(PairedBluetoothDeviceListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(IPairedBluetoothDeviceListActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(PairedBluetoothDeviceDetailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindYourFragmentInjectorFactory(IPairedBluetoothDeviceDetailFragmentSubcomponent.Builder builder);
}
