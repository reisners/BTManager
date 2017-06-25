package net.industrialmind.btmanager.components;

import android.app.Activity;

import net.industrialmind.btmanager.PairedBluetoothDeviceListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Stefan on 01.06.2017.
 */

@Subcomponent
public interface IPairedBluetoothDeviceListActivitySubcomponent extends AndroidInjector<PairedBluetoothDeviceListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PairedBluetoothDeviceListActivity> {}
}
