package net.industrialmind.btmanager.pairedbtdevice;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Stefan on 01.06.2017.
 */

@Subcomponent
public interface PairedBluetoothDeviceListActivitySubcomponent extends AndroidInjector<PairedBluetoothDeviceListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PairedBluetoothDeviceListActivity> {}
}
