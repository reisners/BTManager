package net.industrialmind.btmanager;

import android.app.Activity;
import android.app.Fragment;

import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceDetailFragment;
import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceDetailFragmentSubcomponent;
import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceListActivitySubcomponent;
import net.industrialmind.btmanager.pairedbtdevice.PairedBluetoothDeviceListActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by srn7919 on 02.07.17.
 */

@Module
public abstract class BuildersModule {
    @Binds
    @IntoMap
    @ActivityKey(PairedBluetoothDeviceListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindPairedBluetookDeviceListActivityAndroidInjectorFactory(PairedBluetoothDeviceListActivitySubcomponent.Builder builder);

    @Binds
    @IntoMap
    @FragmentKey(PairedBluetoothDeviceDetailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindPairedBluetookDeviceDetailFragmentAndroidInjectorFactory(PairedBluetoothDeviceDetailFragmentSubcomponent.Builder builder);
}
