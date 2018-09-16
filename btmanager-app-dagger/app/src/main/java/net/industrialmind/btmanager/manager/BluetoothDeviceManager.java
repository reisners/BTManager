package net.industrialmind.btmanager.manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Stefan on 25.05.2017.
 */

public class BluetoothDeviceManager {

    public static final BTDevice DUMMY_DEVICE = new BTDevice("12:34:56:78", "Dumb Dummy Device", null, true);
    public static final BTDevice DUMMY_DEVICE2 = new BTDevice("22:34:56:78", "2nd Dumb Dummy Device", null, true);

    public static class BTDevice {
        public final String id;
        public final String name;
        public final String connectedTo;
        private boolean isConnected;

        public BTDevice(String id, String name, String connectedTo, boolean isConnected) {
            this.id = id;
            this.name = name;
            this.connectedTo = connectedTo;
            this.isConnected = isConnected;
        }

        public boolean isConnected() {
            return isConnected;
        }

        public void setConnected(boolean connected) {
            this.isConnected = connected;
        }
    }

    @Inject
    public BluetoothDeviceManager() {}

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
            list.add(DUMMY_DEVICE2);
        }
        return list;
    }

    public BTDevice getPairedDevice(String id) {
        if (btAdapter != null) {
            return btdevice(btAdapter.getRemoteDevice(id));
        } else {
            //FIXME for emulation only - throw exception instead for production
            return DUMMY_DEVICE.id.equals(id) ? DUMMY_DEVICE : (DUMMY_DEVICE2.id.equals(id) ? DUMMY_DEVICE2 : null);
        }
    }

    private BTDevice btdevice(BluetoothDevice device) {
        return new BTDevice(device.getAddress(), device.getName(), null, true);
    }

    public BluetoothDevice getDevice(BTDevice btDevice) {
        return btAdapter.getRemoteDevice(btDevice.id);
    }
}
