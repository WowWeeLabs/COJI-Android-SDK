package com.wowwee.coji_android_sampleproject.com.wowwee.coji_android_sampleproject.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotConstant;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.R;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

import java.util.ArrayList;

/**
 * Created by davidchan on 22/3/2017.
 */

public class ButtonTestFragment extends CojiBaseFragment {

    Handler handler;
    ListView listView;

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

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        if (CojiRobotFinder.getInstance().getCojiRobotConnectedList().size() > 0) {
            CojiRobot robot = (CojiRobot) CojiRobotFinder.getInstance().getCojiRobotConnectedList().get(0);
            robot.setCallbackInterface(ButtonTestFragment.this);
        }
        listView = (ListView)view.findViewById(R.id.menuTable);
        String[] ledNameArr = {"Back", "Button: Left", "Button: Head", "Button: Right", "Acceleromter: Tilt Left", "Acceleromter: Tilt Right", "Acceleromter: Tilt Forward", "Acceleromter: Tilt Backward", "Acceleromter: Shake", "Acceleromter: Pick Up"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, ledNameArr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (CojiRobotFinder.getInstance().getCojiRobotConnectedList().size() > 0) {
                    CojiRobot robot = (CojiRobot)CojiRobotFinder.getInstance().getCojiRobotConnectedList().get(0);
                    switch (position) {
                        case 0:
                            FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new MenuFragment(), R.id.view_id_content, false);
                            break;
                    }
                }
            }
        });

        handler = new Handler();

        return view;
    }

    @Override
    public void cojiDidReceiveButtonPressed(CojiRobot coji, final CojiRobotConstant.kCojiButtonStatus headLeftSW, final CojiRobotConstant.kCojiButtonStatus headCenterSW, final CojiRobotConstant.kCojiButtonStatus headRightSW) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] ledNameArr = {"Back", "Button: Left", "Button: Head", "Button: Right", "Acceleromter: Tilt Left", "Acceleromter: Tilt Right", "Acceleromter: Tilt Forward", "Acceleromter: Tilt Backward", "Acceleromter: Shake", "Acceleromter: Pick Up"};
                if (headLeftSW == CojiRobotConstant.kCojiButtonStatus.kCojiButtonStatusPressed)
                    ledNameArr[1] = ledNameArr[1] + " Pressed";
                if (headCenterSW == CojiRobotConstant.kCojiButtonStatus.kCojiButtonStatusPressed)
                    ledNameArr[2] = ledNameArr[2] + " Pressed";
                if (headRightSW == CojiRobotConstant.kCojiButtonStatus.kCojiButtonStatusPressed)
                    ledNameArr[3] = ledNameArr[3] + " Pressed";

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, ledNameArr);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void cojiDidReceiveAccelerometerStatus(CojiRobot cojiRobot, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus1, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus2, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus3, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus4, final CojiRobotConstant.kCojiAccelerometerStatus kCojiAccelerometerStatus5) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                String[] ledNameArr = {"Back", "Button: Left", "Button: Head", "Button: Right", "Acceleromter: Tilt Left", "Acceleromter: Tilt Right", "Acceleromter: Tilt Forward", "Acceleromter: Tilt Backward", "Acceleromter: Shake", "Acceleromter: Pick Up"};
                if (kCojiAccelerometerStatus == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[4] = ledNameArr[4] + " Detected";
                if (kCojiAccelerometerStatus1 == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[5] = ledNameArr[5] + " Detected";
                if (kCojiAccelerometerStatus2 == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[6] = ledNameArr[6] + " Detected";
                if (kCojiAccelerometerStatus3 == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[7] = ledNameArr[7] + " Detected";
                if (kCojiAccelerometerStatus4 == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[8] = ledNameArr[8] + " Detected";
                if (kCojiAccelerometerStatus5 == CojiRobotConstant.kCojiAccelerometerStatus.kCojiAccelerometerStatusDetected)
                    ledNameArr[9] = ledNameArr[9] + " Detected";

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, ledNameArr);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}