package net.industrialmind.btmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.industrialmind.btmanager.device.BluetoothDeviceService;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * A fragment representing a single Paired Bluetooth Device detail screen.
 * This fragment is either contained in a {@link PairedBluetoothDeviceListActivity}
 * in two-pane mode (on tablets) or a {@link PairedBluetoothDeviceDetailActivity}
 * on handsets.
 */
public class PairedBluetoothDeviceDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The BTDevice this fragment is presenting.
     */
    private BluetoothDeviceService.BTDevice mItem;

    @Inject
    BluetoothDeviceService btService;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PairedBluetoothDeviceDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the bluetooth device specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = btService.getPairedDevice(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pairedbluetoothdevice_detail, container, false);

        // Show the BTDevice name as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.pairedbluetoothdevice_detail)).setText(mItem.name);
        }

        return rootView;
    }
}
