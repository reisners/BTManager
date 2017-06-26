package net.industrialmind.btmanager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by srn7919 on 04.06.17.
 */
@Singleton
@Component(modules={BTDeviceModule.class})
public interface BTComponent {
    void inject(PairedBluetoothDeviceListActivity activity);
    void inject(PairedBluetoothDeviceDetailFragment fragment);
}
