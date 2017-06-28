package net.industrialmind.btmanager.components;

import net.industrialmind.btmanager.PairedBluetoothDeviceDetailFragment;
import net.industrialmind.btmanager.PairedBluetoothDeviceListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Stefan on 01.06.2017.
 */

@Subcomponent
public interface IPairedBluetoothDeviceDetailFragmentSubcomponent extends AndroidInjector<PairedBluetoothDeviceDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PairedBluetoothDeviceDetailFragment> {}
}
