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

public class SoundFragment extends CojiBaseFragment {

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
            robot.setCallbackInterface(SoundFragment.this);
        }
        listView = (ListView)view.findViewById(R.id.menuTable);
        String[] listArr = {"Back", "Stop", "kCojiSoundIndex_NA_Sfx_Pop", "kCojiSoundIndex_A_Sfx_Pop", "kCojiSoundIndex_A_Sfx_Receive", "kCojiSoundIndex_Emoji_Intro_Music", "kCojiSoundIndex_Girl_Dance", "kCojiSoundIndex_Volcano_Explode", "kCojiSoundIndex_Lightbulb_ding", "kCojiSoundIndex_Alien", "kCojiSoundIndex_Attention", "kCojiSoundIndex_Baby_Suck", "kCojiSoundIndex_Bark", "kCojiSoundIndex_BdayMusic_1", "kCojiSoundIndex_Big_Pop", "kCojiSoundIndex_Bomb", "kCojiSoundIndex_Booo", "kCojiSoundIndex_Bounce", "kCojiSoundIndex_CarouselMusic", "kCojiSoundIndex_Cartoon_Drip", "kCojiSoundIndex_Cartoon_Drip_1", "kCojiSoundIndex_Cha_ching", "kCojiSoundIndex_Clang", "kCojiSoundIndex_Click", "kCojiSoundIndex_Coaster_Screams", "kCojiSoundIndex_Coji_Annoyed", "kCojiSoundIndex_Coji_Coji_1", "kCojiSoundIndex_Coji_Coji_2", "kCojiSoundIndex_Coji_Coji_3", "kCojiSoundIndex_Coji_Crying", "kkCojiSoundIndex_Coji_Hike", "kCojiSoundIndex_Coji_Huh_", "kCojiSoundIndex_Coji_Hungry_1", "kCojiSoundIndex_Coji_Loop_1", "kCojiSoundIndex_Coji_Macro", "kCojiSoundIndex_Coji_Munch", "kCojiSoundIndex_Coji_Ouch", "kCojiSoundIndex_Coji_Sequence_1", "kCojiSoundIndex_Coji_Serious", "kCojiSoundIndex_Coji_Shy", "kCojiSoundIndex_Coji_Sings", "kCojiSoundIndex_Coji_Smirks", "kCojiSoundIndex_Coji_Smooch", "kCojiSoundIndex_Coji_Surprised_1", "kCojiSoundIndex_Coji_Yum", "kCojiSoundIndex_CoolMusic", "kCojiSoundIndex_Crank", "kCojiSoundIndex_Detective", "kCojiSoundIndex_Devil_Sneers", "kCojiSoundIndex_Dragon", "kCojiSoundIndex_Dragon_Roar", "kCojiSoundIndex_ElectricZap", "kCojiSoundIndex_Fire", "kCojiSoundIndex_Flap_Wings", "kCojiSoundIndex_Flush", "kCojiSoundIndex_Foghorn", "kCojiSoundIndex_Generic_Car_Motor", "kCojiSoundIndex_Glug", "kCojiSoundIndex_GuitarRiff", "kCojiSoundIndex_HammerKnock", "kCojiSoundIndex_Hockey", "kCojiSoundIndex_Jet_Flying", "kCojiSoundIndex_Lightning", "kCojiSoundIndex_LowBattery", "kCojiSoundIndex_Meow", "kCojiSoundIndex_Motor_Rev", "kCojiSoundIndex_Octopus", "kCojiSoundIndex_Panting", "kCojiSoundIndex_PartyHorn", "kCojiSoundIndex_Propeller_Spins", "kCojiSoundIndex_Pump", "kCojiSoundIndex_Rain", "kCojiSoundIndex_Rattle", "kCojiSoundIndex_Reel", "kCojiSoundIndex_RegalTune", "kCojiSoundIndex_Ring", "kCojiSoundIndex_Roar", "kCojiSoundIndex_Rooster_Crows", "kCojiSoundIndex_Sax", "kCojiSoundIndex_SchoolBell", "kCojiSoundIndex_Slip", "kCojiSoundIndex_Slots", "kCojiSoundIndex_Slurpy_Lick", "kCojiSoundIndex_Sparkle", "kCojiSoundIndex_Splat", "kCojiSoundIndex_Swoosh", "kCojiSoundIndex_TechoBeat", "kCojiSoundIndex_Tick", "kCojiSoundIndex_Train_Chug", "kCojiSoundIndex_Triumphant", "kCojiSoundIndex_Trumpet", "kCojiSoundIndex_Tweet", "kCojiSoundIndex_Unlock", "kCojiSoundIndex_Whoa_2", "kCojiSoundIndex_Wink", "kCojiSoundIndex_Yawn", "kCojiSoundIndex_Zip", "kCojiSoundIndex_crack", "kCojiSoundIndex_police_whistle", "kCojiSoundIndex_Alien_Tune", "kCojiSoundIndex_Angles_Sing", "kCojiSoundIndex_Baby", "kCojiSoundIndex_Backward_3", "kCojiSoundIndex_Beep", "kCojiSoundIndex_Blink", "kCojiSoundIndex_Boing_1", "kCojiSoundIndex_Bomb_NA", "kCojiSoundIndex_Coji_Awe_Cute", "kCojiSoundIndex_Coji_Burp", "kCojiSoundIndex_Coji_Comic_Scream", "kCojiSoundIndex_Coji_No_Like", "kCojiSoundIndex_Coji_Sneeze", "kCojiSoundIndex_Coji_Sniff_2Xs", "kCojiSoundIndex_Coji_blahhh", "kCojiSoundIndex_Dizzy", "kCojiSoundIndex_Dog", "kCojiSoundIndex_Excite", "kCojiSoundIndex_Fireworks", "kCojiSoundIndex_Fly_Buzz", "kCojiSoundIndex_Frog", "kCojiSoundIndex_Giggle", "kCojiSoundIndex_Grumpy_3", "kCojiSoundIndex_Head_Button_3", "kCojiSoundIndex_Humph", "kCojiSoundIndex_Laugh_3", "kCojiSoundIndex_Meow_NA", "kCojiSoundIndex_Meow_Scratch", "kCojiSoundIndex_Monkey_Sounds", "kCojiSoundIndex_Munch", "kCojiSoundIndex_Music_Note", "kCojiSoundIndex_Oink_Snort", "kCojiSoundIndex_Pleading", "kCojiSoundIndex_Plop", "kCojiSoundIndex_Power_Boat", "kCojiSoundIndex_Power_up", "kCojiSoundIndex_Rocket_Blast_Off", "kCojiSoundIndex_Scratch", "kCojiSoundIndex_Side_Button_2", "kCojiSoundIndex_Siren", "kCojiSoundIndex_Slime", "kCojiSoundIndex_Snore", "kCojiSoundIndex_Snore_3", "kCojiSoundIndex_Sparkle_NA", "kCojiSoundIndex_Spin_3", "kCojiSoundIndex_Splash", "kCojiSoundIndex_Spray", "kCojiSoundIndex_Tiptoe", "kCojiSoundIndex_Turn", "kCojiSoundIndex_Waiting_Whistle_2", "kCojiSoundIndex_Wave", "kCojiSoundIndex_Wee_3", "kCojiSoundIndex_Whoa_3", "kCojiSoundIndex_Wind_Gust", "kCojiSoundIndex_Woohoo", "kCojiSoundIndex_WowWee", "kCojiSoundIndex_Yippe", "kCojiSoundIndex_forward_3"};
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
                            robot.stopCommand(CojiRobotConstant.kCojiStopType.kCojiStopTypeSound);
                            break;
                        default:
                            robot.playSound(position-2);
                            break;
                    }
                }
            }
        });

        handler = new Handler();

        return view;
    }

    @Override
    public void cojiDidReceiveSoundStatus(CojiRobot cojiRobot, final CojiRobotConstant.kCojiSoundStatus status, final int arbitrarySoundID) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Sound ID: " + (int)arbitrarySoundID);
                switch (status) {
                    case kCojiSoundStatusStarted:
                        alertDialog.setMessage("Started");
                        break;
                    case kCojiSoundStatusFinished:
                        alertDialog.setMessage("Finished");
                        break;
                    case kCojiSoundStatusStopped:
                        alertDialog.setMessage("Stopped");
                        break;
                    case kCojiSoundStatusFailed:
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
