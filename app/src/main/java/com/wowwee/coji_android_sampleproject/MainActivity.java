package com.wowwee.coji_android_sampleproject;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.wowwee.bluetoothrobotcontrollib.BluetoothRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.com.wowwee.coji_android_sampleproject.fragment.ConnectFragment;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter.getDefaultAdapter();
        FragmentHelper.switchFragment(getSupportFragmentManager(), new ConnectFragment(), R.id.view_id_content, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        for (CojiRobot robot : (List<CojiRobot>)CojiRobotFinder.getInstance().getCojiRobotConnectedList()){
            robot.disconnect();
        }
        System.exit(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // disable idle timer
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for (CojiRobot robot : (List<CojiRobot>)CojiRobotFinder.getInstance().getCojiRobotConnectedList()){
            robot.disconnect();
        }

        BluetoothRobot.unbindBluetoothLeService(MainActivity.this);

        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
