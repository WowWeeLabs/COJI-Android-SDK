package com.wowwee.coji_android_sampleproject.com.wowwee.coji_android_sampleproject.fragment;

import android.support.v4.app.Fragment;

import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotConstant;

/**
 * Created by davidchan on 24/3/2017.
 */

public class CojiBaseFragment extends Fragment implements CojiRobot.COJIRobotInterface {
    @Override
    public void cojiDeviceReady(CojiRobot cojiRobot) {

    }

    @Override
    public void cojiDeviceDisconnected(CojiRobot cojiRobot) {

    }

    @Override
    public void cojiDidReceiveBatteryInfo(CojiRobot cojiRobot, float v) {

    }

    @Override
    public void cojiDidReceiveAnimationStatus(CojiRobot paramCojiRobot, CojiRobotConstant.kCojiAnimationStatus paramkCojiAnimationStatus, int paramInt) {

    }

    @Override
    public void cojiDidReceiveSoundStatus(CojiRobot cojiRobot, CojiRobotConstant.kCojiSoundStatus kCojiSoundStatus, int i) {

    }

    @Override
    public void cojiDidReceiveImageStatus(CojiRobot cojiRobot, CojiRobotConstant.kCojiImageStatus kCojiImageStatus, int i) {

    }

    @Override
    public void cojiDidReceiveButtonPressed(CojiRobot cojiRobot, CojiRobotConstant.kCojiButtonStatus kCojiButtonStatus, CojiRobotConstant.kCojiButtonStatus kCojiButtonStatus1, CojiRobotConstant.kCojiButtonStatus kCojiButtonStatus2) {

    }

    @Override
    public void cojiDidReceiveAccelerometerStatus(CojiRobot cojiRobot, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus1, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus2, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus3, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus4, CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus5) {

    }

    @Override
    public void cojiDidReceiveChestLEDStatus(CojiRobot cojiRobot, boolean b, boolean b1, boolean b2) {

    }

    @Override
    public void cojiDidReceiveFirmwareVersion(CojiRobot cojiRobot, String s) {

    }

    @Override
    public void cojiDidReceiveVolumeLevel(CojiRobot cojiRobot, float v) {

    }

    @Override
    public void cojiDidReceiveLCDDisplayBackLight(CojiRobot cojiRobot, boolean b) {

    }
}
