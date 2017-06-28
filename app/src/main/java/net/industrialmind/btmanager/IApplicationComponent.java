package net.industrialmind.btmanager;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by srn7919 on 04.06.17.
 */
@Singleton
@Component(modules={BTDeviceModule.class, AndroidInjectionModule.class})
public interface IApplicationComponent {
    void inject(BTManagerApplication application);
    void inject(PairedBluetoothDeviceListActivity activity);
    void inject(PairedBluetoothDeviceDetailFragment fragment);
}
