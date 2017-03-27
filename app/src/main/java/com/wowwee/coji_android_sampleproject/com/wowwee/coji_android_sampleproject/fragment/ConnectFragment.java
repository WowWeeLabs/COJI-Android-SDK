package com.wowwee.coji_android_sampleproject.com.wowwee.coji_android_sampleproject.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.R;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidchan on 22/3/2017.
 */

public class ConnectFragment extends CojiBaseFragment {
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter mBluetoothAdapter;
    private Handler handler;
    private ListView listView;
    List<String> robotNameList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null)
            return null;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getActivity().getWindow().getDecorView().setSystemUiVisibility(flags);


        View view = inflater.inflate(R.layout.fragment_connect, container, false);

        listView = (ListView)view.findViewById(R.id.connectionTable);
        String[] robotNameArr = {"Please turn on COJI"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, robotNameArr);
        listView.setAdapter(adapter);

        Button refreshBtn = (Button)view.findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CojiRobotFinder.getInstance().clearFoundCOJIList();
                scanLeDevice(false);
                updateCojiList();
                scanLeDevice(true);
            }
        });

        this.initBluetooth();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (CojiRobotFinder.getInstance().getCojiFoundList().size() > 0) {
                    String targetRobotName = robotNameList.get(position);
                    for (CojiRobot robot : (List<CojiRobot>) CojiRobotFinder.getInstance().getCojiFoundList()) {
                        if (robot.getName().contentEquals(targetRobotName)) {
                            final CojiRobot connectCojiRobot = robot;
                            getActivity().runOnUiThread(new Runnable() {
                                public void run() {
                                    connect(connectCojiRobot);
                                    // Stop scan Coji
                                    scanLeDevice(false);
                                }
                            });
                            break;
                        }
                    }
                }
            }
        });

        return view;
    }

    void connect(CojiRobot robot) {
        robot.setCallbackInterface(this);
        robot.connect(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

        // Register CojiRobotFinder broadcast receiver
        this.getActivity().registerReceiver(mCojiFinderBroadcastReceiver, CojiRobotFinder.getCojiRobotFinderIntentFilter());

        // Ensures Bluetooth is enabled on the device.  If Bluetooth is not currently enabled,
        // fire an intent to display a dialog asking the user to grant permission to enable it.
        if (mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled()) {
            if (!mBluetoothAdapter.isEnabled()) {
                try {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

                } catch (ActivityNotFoundException ex) {
                }
            }
        }

        // Start scan
        CojiRobotFinder.getInstance().clearFoundCOJIList();
        scanLeDevice(false);
        updateCojiList();
        scanLeDevice(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.getActivity().unregisterReceiver(mCojiFinderBroadcastReceiver);
        scanLeDevice(false);
    }

    private void initBluetooth(){
        final BluetoothManager bluetoothManager = (BluetoothManager) this.getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        CojiRobotFinder.getInstance().setBluetoothAdapter(mBluetoothAdapter);
        CojiRobotFinder.getInstance().setApplicationContext(this.getActivity());
    }

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            Log.d("CojiScan", "Scan Le device start");
            // Stops scanning after a pre-defined scan period.
            CojiRobotFinder.getInstance().scanForCOJIContinuous();
        }else{
            Log.d("CojiScan", "Scan Le device stop");
            CojiRobotFinder.getInstance().stopScanForCOJIContinuous();
        }
    }

    private void updateCojiList(){
        robotNameList = new ArrayList();
        for (CojiRobot robot : (List<CojiRobot>)CojiRobotFinder.getInstance().getCojiFoundList()) {
            robotNameList.add(robot.getName());
        }

        String[] robotNameArr;
        if (robotNameList.size() > 0)
            robotNameArr = robotNameList.toArray(new String[0]);
        else {
            robotNameArr = new String[1];
            robotNameArr[0] = "Please turn on COJI";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, robotNameArr);
        listView.setAdapter(adapter);
    }

    private final BroadcastReceiver mCojiFinderBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (CojiRobotFinder.COJIRobotFinder_COJIFound.equals(action)){
                BluetoothDevice device = (BluetoothDevice)(intent.getExtras().get("BluetoothDevice"));
                Log.d("BLE", "CojiScanFragment broadcast receiver found COJI: " + device.getName());
                updateCojiList();
            } else if (CojiRobotFinder.COJIRobotFinder_COJIListCleared.equals(action)) {
                updateCojiList();
            }
        }
    };

    @Override
    public void cojiDeviceReady(CojiRobot cojiRobot) {
        FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new MenuFragment(), R.id.view_id_content, false);
    }
}
