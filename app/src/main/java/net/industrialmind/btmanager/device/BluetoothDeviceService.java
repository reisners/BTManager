package net.industrialmind.btmanager.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Stefan on 25.05.2017.
 */

public class BluetoothDeviceService {

    public static final BTDevice DUMMY_DEVICE = new BTDevice("12:34:56:78", "Dumb Dummy Device", null);

    public static class BTDevice {
        public final String id;
        public final String name;
        public final String connectedTo;

        public BTDevice(String id, String name, String connectedTo) {
            this.id = id;
            this.name = name;
            this.connectedTo = connectedTo;
        }
    }

    @Inject
    public BluetoothDeviceService() {}

    private BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

    public List<BTDevice> listPairedDevices() {
        List<BTDevice> list = new ArrayList<>();
        if (btAdapter != null) {
            for (BluetoothDevice device : btAdapter.getBondedDevices()) {
                list.add(btdevice(device));
            }
        }
        //FIXME for emulation only - remove for production!
        else {
            list.add(DUMMY_DEVICE);
        }
        return list;
    }

    public BTDevice getPairedDevice(String id) {
        if (btAdapter != null) {
            return btdevice(btAdapter.getRemoteDevice(id));
        } else {
            //FIXME for emulation only - throw exception instead for production
            return DUMMY_DEVICE.id.equals(id) ? DUMMY_DEVICE : null;
        }
    }

    private BTDevice btdevice(BluetoothDevice device) {
        return new BTDevice(device.getAddress(), device.getName(), null);
    }
}
