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
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotConstant;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.R;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

import java.util.ArrayList;

/**
 * Created by davidchan on 22/3/2017.
 */

public class AnimationFragment extends CojiBaseFragment {

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
            robot.setCallbackInterface(AnimationFragment.this);
        }
        listView = (ListView)view.findViewById(R.id.menuTable);
        String[] listArr = {"Back", "Stop", "kCojiAnimationIndex_Character_001", "kCojiAnimationIndex_Character_002", "kCojiAnimationIndex_Character_003", "kCojiAnimationIndex_Character_004", "kCojiAnimationIndex_Character_005", "kCojiAnimationIndex_Character_006", "kCojiAnimationIndex_Character_007", "kCojiAnimationIndex_Character_008", "kCojiAnimationIndex_Character_009", "kCojiAnimationIndex_Character_010", "kCojiAnimationIndex_Character_011", "kCojiAnimationIndex_Character_012", "kCojiAnimationIndex_Character_013", "kCojiAnimationIndex_Character_014", "kCojiAnimationIndex_Character_015", "kCojiAnimationIndex_Character_016", "kCojiAnimationIndex_Character_017", "kCojiAnimationIndex_Character_018", "kCojiAnimationIndex_Character_019", "kCojiAnimationIndex_Character_020", "kCojiAnimationIndex_Character_021", "kCojiAnimationIndex_Character_022", "kCojiAnimationIndex_Character_023", "kCojiAnimationIndex_Character_024", "kCojiAnimationIndex_Character_025", "kCojiAnimationIndex_Character_026", "kCojiAnimationIndex_Character_027", "kCojiAnimationIndex_Character_028", "kCojiAnimationIndex_Character_029", "kCojiAnimationIndex_Character_030", "kCojiAnimationIndex_Default_001", "kCojiAnimationIndex_Default_002", "kCojiAnimationIndex_Default_003", "kCojiAnimationIndex_Default_004", "kCojiAnimationIndex_Default_005", "kCojiAnimationIndex_Default_007", "kCojiAnimationIndex_Default_008", "kCojiAnimationIndex_Default_010", "kCojiAnimationIndex_Default_011", "kCojiAnimationIndex_Default_012", "kCojiAnimationIndex_Default_013", "kCojiAnimationIndex_Default_014", "kCojiAnimationIndex_Default_015", "kCojiAnimationIndex_Default_016", "kCojiAnimationIndex_Default_017", "kCojiAnimationIndex_Default_018", "kCojiAnimationIndex_Default_019", "kCojiAnimationIndex_Default_020", "kCojiAnimationIndex_Default_021", "kCojiAnimationIndex_Default_022", "kCojiAnimationIndex_Default_023", "kCojiAnimationIndex_Default_024", "kCojiAnimationIndex_Default_025", "kCojiAnimationIndex_Default_026", "kCojiAnimationIndex_Default_027", "kCojiAnimationIndex_Default_028", "kCojiAnimationIndex_Default_029", "kCojiAnimationIndex_Default_030", "kCojiAnimationIndex_Emoji_001", "kCojiAnimationIndex_Emoji_002", "kCojiAnimationIndex_Emoji_003", "kCojiAnimationIndex_Emoji_004", "kCojiAnimationIndex_Emoji_005", "kCojiAnimationIndex_Emoji_006", "kCojiAnimationIndex_Emoji_007", "kCojiAnimationIndex_Emoji_008", "kCojiAnimationIndex_Emoji_009", "kCojiAnimationIndex_Emoji_010 ", "kCojiAnimationIndex_Emoji_011", "kCojiAnimationIndex_Emoji_012", "kCojiAnimationIndex_Emoji_013", "kCojiAnimationIndex_Emoji_014", "kCojiAnimationIndex_Emoji_015", "kCojiAnimationIndex_Emoji_016", "kCojiAnimationIndex_Emoji_017", "kCojiAnimationIndex_Emoji_018", "kCojiAnimationIndex_Emoji_019", "kCojiAnimationIndex_Emoji_020", "kCojiAnimationIndex_Emoji_021", "kCojiAnimationIndex_Emoji_022", "kCojiAnimationIndex_Emoji_023", "kCojiAnimationIndex_Emoji_024", "kCojiAnimationIndex_Emoji_025", "kCojiAnimationIndex_Emoji_026", "kCojiAnimationIndex_Emoji_027", "kCojiAnimationIndex_Emoji_028", "kCojiAnimationIndex_Emoji_029", "kCojiAnimationIndex_Emoji_030", "kCojiAnimationIndex_Emoji_031", "kCojiAnimationIndex_Emoji_032", "kCojiAnimationIndex_Reward_001", "kCojiAnimationIndex_Reward_002", "kCojiAnimationIndex_Reward_003", "kCojiAnimationIndex_Reward_004", "kCojiAnimationIndex_Reward_005", "kCojiAnimationIndex_Reward_006", "kCojiAnimationIndex_Reward_007", "kCojiAnimationIndex_Reward_008", "kCojiAnimationIndex_Reward_009", "kCojiAnimationIndex_Reward_010", "kCojiAnimationIndex_Reward_011", "kCojiAnimationIndex_Reward_012", "kCojiAnimationIndex_Reward_013", "kCojiAnimationIndex_Reward_014", "kCojiAnimationIndex_Reward_015", "kCojiAnimationIndex_Reward_016", "kCojiAnimationIndex_Reward_017", "kCojiAnimationIndex_Reward_018", "kCojiAnimationIndex_Reward_019", "kCojiAnimationIndex_Reward_020", "kCojiAnimationIndex_Reward_021", "kCojiAnimationIndex_Reward_022", "kCojiAnimationIndex_Reward_023", "kCojiAnimationIndex_Reward_024", "kCojiAnimationIndex_Reward_025", "kCojiAnimationIndex_Reward_026", "kCojiAnimationIndex_Reward_027", "kCojiAnimationIndex_Reward_028", "kCojiAnimationIndex_Reward_029", "kCojiAnimationIndex_Reward_030", "kCojiAnimationIndex_Reward_031", "kCojiAnimationIndex_Reward_032", "kCojiAnimationIndex_Reward_033", "kCojiAnimationIndex_Reward_034", "kCojiAnimationIndex_Tool_001", "kCojiAnimationIndex_Tool_002", "kCojiAnimationIndex_Tool_003", "kCojiAnimationIndex_Tool_004", "kCojiAnimationIndex_Tool_005", "kCojiAnimationIndex_Tool_006", "kCojiAnimationIndex_Tool_007", "kCojiAnimationIndex_Tool_008", "kCojiAnimationIndex_Tool_009", "kCojiAnimationIndex_Tool_010", "kCojiAnimationIndex_Tool_011", "kCojiAnimationIndex_Tool_012", "kCojiAnimationIndex_Tool_013", "kCojiAnimationIndex_Tool_014", "kCojiAnimationIndex_Tool_015", "kCojiAnimationIndex_Tool_016", "kCojiAnimationIndex_Tool_017", "kCojiAnimationIndex_Tool_018", "kCojiAnimationIndex_Tool_019", "kCojiAnimationIndex_Tool_020", "kCojiAnimationIndex_Vehicle_001", "kCojiAnimationIndex_Vehicle_002", "kCojiAnimationIndex_Vehicle_003", "kCojiAnimationIndex_Vehicle_004", "kCojiAnimationIndex_Vehicle_005", "kCojiAnimationIndex_Vehicle_006", "kCojiAnimationIndex_Vehicle_007", "kCojiAnimationIndex_Vehicle_008", "kCojiAnimationIndex_Vehicle_009", "kCojiAnimationIndex_Vehicle_010", "kCojiAnimationIndex_Vehicle_011", "kCojiAnimationIndex_Vehicle_012", "kCojiAnimationIndex_Vehicle_013", "kCojiAnimationIndex_Vehicle_014", "kCojiAnimationIndex_Vehicle_015", "kCojiAnimationIndex_Vehicle_016", "kCojiAnimationIndex_Vehicle_017", "kCojiAnimationIndex_Vehicle_018", "kCojiAnimationIndex_Vehicle_019", "kCojiAnimationIndex_Vehicle_020"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, listArr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (CojiRobotFinder.getInstance().getCojiRobotConnectedList().size() > 0) {
                    CojiRobot robot = (CojiRobot)CojiRobotFinder.getInstance().getCojiRobotConnectedList().get(0);
                    switch (position) {
                        case 0:
                            FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new PlayingFragment(), R.id.view_id_content, false);
                            break;
                        case 1:
                            robot.stopCommand(CojiRobotConstant.kCojiStopType.kCojiStopTypeAnimation);
                            break;
                        default:
                            robot.playAnimation(true, position-2);
                            break;
                    }
                }
            }
        });

        handler = new Handler();

        return view;
    }

    @Override
    public void cojiDidReceiveAnimationStatus(CojiRobot cojiRobot, final CojiRobotConstant.kCojiAnimationStatus status, final int arbitraryAnimationID) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Animation ID: " + (int)arbitraryAnimationID);
                switch (status) {
                    case kCojiAnimationStatusStarted:
                        alertDialog.setMessage("Started");
                        break;
                    case kCojiAnimationStatusFinished:
                        alertDialog.setMessage("Finished");
                        break;
                    case kCojiAnimationStatusStopped:
                        alertDialog.setMessage("Stopped");
                        break;
                    case kCojiAnimationStatusFailed:
                        alertDialog.setMessage("Fail");
                        break;
                }
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
