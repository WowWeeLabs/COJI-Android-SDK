package com.wowwee.coji_android_sampleproject.com.wowwee.coji_android_sampleproject.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobot;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.R;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

import java.util.ArrayList;

/**
 * Created by davidchan on 22/3/2017.
 */

public class ChangeLEDFragment extends CojiBaseFragment {

    Handler handler;

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

        ListView listView = (ListView)view.findViewById(R.id.menuTable);
        String[] ledNameArr = {"Back", "Off", "White", "Red", "Green", "Blue", "Yellow", "Magenta", "Cyan", "Request Current Color"};
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
                        case 1:
                            robot.setChestRGBLED(false, false, false);
                            break;
                        case 2:
                            robot.setChestRGBLED(true, true, true);
                            break;
                        case 3:
                            robot.setChestRGBLED(true, false, false);
                            break;
                        case 4:
                            robot.setChestRGBLED(false, true, false);
                            break;
                        case 5:
                            robot.setChestRGBLED(false, false, true);
                            break;
                        case 6:
                            robot.setChestRGBLED(true, true, false);
                            break;
                        case 7:
                            robot.setChestRGBLED(true, false, true);
                            break;
                        case 8:
                            robot.setChestRGBLED(false, true, true);
                            break;
                        case 9:
                            robot.setCallbackInterface(ChangeLEDFragment.this);
                            robot.requestChestRGBLED();
                            break;
                    }
                }
            }
        });

        handler = new Handler();

        return view;
    }

    @Override
    public void cojiDidReceiveChestLEDStatus(CojiRobot cojiRobot, final boolean b, final boolean b1, final boolean b2) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Red: " + (b?"True":"False") + " " + "Green: " + (b1?"True":"False") + " " +"Blue: " + (b2?"True":"False"));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }
}
