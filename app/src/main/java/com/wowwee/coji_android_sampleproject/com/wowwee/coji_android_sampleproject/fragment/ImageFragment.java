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
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotConstant.kCojiImage_AnimationTemplate;
import com.wowwee.bluetoothrobotcontrollib.coji.CojiRobotFinder;
import com.wowwee.coji_android_sampleproject.R;
import com.wowwee.coji_android_sampleproject.utils.FragmentHelper;

/**
 * Created by davidchan on 22/3/2017.
 */

public class ImageFragment extends CojiBaseFragment {

    Handler handler;
    ListView listView;
    boolean selectedTemplate;
    kCojiImage_AnimationTemplate selectedTemplateIndex;
    String[] listArr;
    String[] templateListArr;
    ArrayAdapter<String> adapter;
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
            robot.setCallbackInterface(ImageFragment.this);
        }
        listView = (ListView)view.findViewById(R.id.menuTable);
        String[] arr = {"Back", "kCojiImageIndex_Character_1F408", "kCojiImageIndex_Character_1F408_B", "kCojiImageIndex_Character_1F408_C", "kCojiImageIndex_Character_1F408_D", "kCojiImageIndex_Character_1F408_E", "kCojiImageIndex_Character_1F408_F", "kCojiImageIndex_Character_1F408_G", "kCojiImageIndex_Character_1F418", "kCojiImageIndex_Character_1F418_B", "kCojiImageIndex_Character_1F418_C", "kCojiImageIndex_Character_1F419", "kCojiImageIndex_Character_1F419_B", "kCojiImageIndex_Character_1F427", "kCojiImageIndex_Character_1F427_B", "kCojiImageIndex_Character_1F42D", "kCojiImageIndex_Character_1F42D_B", "kCojiImageIndex_Character_1F42D_C", "kCojiImageIndex_Character_1F42D_D", "kCojiImageIndex_Character_1F432", "kCojiImageIndex_Character_1F432_B", "kCojiImageIndex_Character_1F432_C", "kCojiImageIndex_Character_1F432_D", "kCojiImageIndex_Character_1F432_E", "kCojiImageIndex_Character_1F432_F", "kCojiImageIndex_Character_1F432_G", "kCojiImageIndex_Character_1F433", "kCojiImageIndex_Character_1F433_B", "kCojiImageIndex_Character_1F433_C", "kCojiImageIndex_Character_1F433_D", "kCojiImageIndex_Character_1F433_E", "kCojiImageIndex_Character_1F433_F", "kCojiImageIndex_Character_1F433_G", "kCojiImageIndex_Character_1F433_H", "kCojiImageIndex_Character_1F435", "kCojiImageIndex_Character_1F435_B", "kCojiImageIndex_Character_1F435_C", "kCojiImageIndex_Character_1F435_D", "kCojiImageIndex_Character_1F436", "kCojiImageIndex_Character_1F436_B", "kCojiImageIndex_Character_1F436_C", "kCojiImageIndex_Character_1F436_D", "kCojiImageIndex_Character_1F437", "kCojiImageIndex_Character_1F437_B", "kCojiImageIndex_Character_1F437_C", "kCojiImageIndex_Character_1F438", "kCojiImageIndex_Character_1F438_B", "kCojiImageIndex_Character_1F438_C", "kCojiImageIndex_Character_1F438_D", "kCojiImageIndex_Character_1F438_E", "kCojiImageIndex_Character_1F438_F", "kCojiImageIndex_Character_1F438_G", "kCojiImageIndex_Character_1F438_H", "kCojiImageIndex_Character_1F438_I", "kCojiImageIndex_Character_1F438_J", "kCojiImageIndex_Character_1F46e", "kCojiImageIndex_Character_1F476", "kCojiImageIndex_Character_1F476_B", "kCojiImageIndex_Character_1F476_C", "kCojiImageIndex_Character_1F476_D", "kCojiImageIndex_Character_1F476_E", "kCojiImageIndex_Character_1F476_F", "kCojiImageIndex_Character_1F476_G", "kCojiImageIndex_Character_1F476_H", "kCojiImageIndex_Character_1F478", "kCojiImageIndex_Character_1F478_B", "kCojiImageIndex_Character_1F47b", "kCojiImageIndex_Character_1F47b_B", "kCojiImageIndex_Character_1F47d", "kCojiImageIndex_Character_1F47d_B", "kCojiImageIndex_Character_1F47d_C", "kCojiImageIndex_Character_1F483", "kCojiImageIndex_Character_1F483_B", "kCojiImageIndex_Character_1F483_C", "kCojiImageIndex_Character_1F483_D", "kCojiImageIndex_Character_1F483_E", "kCojiImageIndex_Character_1F483_F", "kCojiImageIndex_Character_1F981", "kCojiImageIndex_Character_1F981_B", "kCojiImageIndex_Character_1F981_C", "kCojiImageIndex_Character_1F981_D", "kCojiImageIndex_Character_1F981_E", "kCojiImageIndex_Character_1F984", "kCojiImageIndex_Character_1F984_B", "kCojiImageIndex_Character_1f40c", "kCojiImageIndex_Character_1f411", "kCojiImageIndex_Character_1f411_B", "kCojiImageIndex_Character_1f413", "kCojiImageIndex_Character_1f413_B", "kCojiImageIndex_Character_1f413_C", "kCojiImageIndex_Character_1f413_D", "kCojiImageIndex_Character_1f426", "kCojiImageIndex_Character_1f426_B", "kCojiImageIndex_Character_1f429", "kCojiImageIndex_Character_1f429_B", "kCojiImageIndex_Character_1f42c", "kCojiImageIndex_Character_1f42c_B", "kCojiImageIndex_Character_1f42c_C", "kCojiImageIndex_Character_1f42c_D", "kCojiImageIndex_Character_1f42c_E", "kCojiImageIndex_Character_1f42c_F", "kCojiImageIndex_Character_1f42c_G", "kCojiImageIndex_Character_1f47e", "kCojiImageIndex_Character_1f47e_B", "kCojiImageIndex_Character_1f575", "kCojiImageIndex_Character_1f577", "kCojiImageIndex_Character_1f577_B", "kCojiImageIndex_Character_1f63b", "kCojiImageIndex_Character_1f63b_B", "kCojiImageIndex_Character_1f916", "kCojiImageIndex_Character_1f916_B", "kCojiImageIndex_Character_1f916_C", "kCojiImageIndex_Character_1f916_D", "kCojiImageIndex_Character_1f916_E", "kCojiImageIndex_Character_Blank", "kCojiImageIndex_Default_1F337", "kCojiImageIndex_Default_1F337_D", "kCojiImageIndex_Default_1F337_G", "kCojiImageIndex_Default_1F337_H", "kCojiImageIndex_Default_1F337_J", "kCojiImageIndex_Default_1F337_K", "kCojiImageIndex_Default_1F3B6", "kCojiImageIndex_Default_1F3B6_B", "kCojiImageIndex_Default_1F4a3", "kCojiImageIndex_Default_1F4a3_B", "kCojiImageIndex_Default_1F4a3_C", "kCojiImageIndex_Default_1F4a3_D", "kCojiImageIndex_Default_1F4a3_E", "kCojiImageIndex_Default_1F4a3_F", "kCojiImageIndex_Default_1F4a3_G", "kCojiImageIndex_Default_1F4a3_H", "kCojiImageIndex_Default_1F4a3_I", "kCojiImageIndex_Default_1F4a3_J", "kCojiImageIndex_Default_1F4a3_K", "kCojiImageIndex_Default_1F4a9", "kCojiImageIndex_Default_1F4a9_B", "kCojiImageIndex_Default_1F4a9_C", "kCojiImageIndex_Default_1F4a9_D", "kCojiImageIndex_Default_1F4a9_E", "kCojiImageIndex_Default_1F4a9_F", "kCojiImageIndex_Default_1F4a9_G", "kCojiImageIndex_Default_1F504_A", "kCojiImageIndex_Default_1F504_B", "kCojiImageIndex_Default_1F504_C", "kCojiImageIndex_Default_1F504_D", "kCojiImageIndex_Default_1F61A", "kCojiImageIndex_Default_1F61A_B", "kCojiImageIndex_Default_1F61A_C", "kCojiImageIndex_Default_1F61A_DD", "kCojiImageIndex_Default_1F61A_EE", "kCojiImageIndex_Default_1F61A_F", "kCojiImageIndex_Default_1F61A_G", "kCojiImageIndex_Default_1F61A_H", "kCojiImageIndex_Default_1F61A_I", "kCojiImageIndex_Default_1F61A_J", "kCojiImageIndex_Default_1f32e", "kCojiImageIndex_Default_1f32e_B", "kCojiImageIndex_Default_1f32e_C", "kCojiImageIndex_Default_1f32e_D", "kCojiImageIndex_Default_1f32e_E", "kCojiImageIndex_Default_1f32e_F", "kCojiImageIndex_Default_1f386", "kCojiImageIndex_Default_1f386_B", "kCojiImageIndex_Default_1f386_C", "kCojiImageIndex_Default_1f386_D", "kCojiImageIndex_Default_1f386_E", "kCojiImageIndex_Default_1f386_F", "kCojiImageIndex_Default_1f386_G", "kCojiImageIndex_Default_1f386_H", "kCojiImageIndex_Default_1f44c_1f3fd", "kCojiImageIndex_Default_1f44c_1f3fd_B", "kCojiImageIndex_Default_1f44d_1f3fd", "kCojiImageIndex_Default_1f44d_1f3fd_B", "kCojiImageIndex_Default_1f44e_1f3fd", "kCojiImageIndex_Default_1f44e_1f3fd_B", "kCojiImageIndex_Default_1f49c", "kCojiImageIndex_Default_1f49c_A", "kCojiImageIndex_Default_1f603", "kCojiImageIndex_Default_1f603_B", "kCojiImageIndex_Default_1f603_C", "kCojiImageIndex_Default_1f607", "kCojiImageIndex_Default_1f607_B", "kCojiImageIndex_Default_1f607_C", "kCojiImageIndex_Default_1f607_D", "kCojiImageIndex_Default_1f607_E", "kCojiImageIndex_Default_1f608", "kCojiImageIndex_Default_1f608_B", "kCojiImageIndex_Default_1f608_C", "kCojiImageIndex_Default_1f608_D", "kCojiImageIndex_Default_1f60a", "kCojiImageIndex_Default_1f60a_B", "kCojiImageIndex_Default_1f60f", "kCojiImageIndex_Default_1f60f_B", "kCojiImageIndex_Default_1f61b", "kCojiImageIndex_Default_1f61b_B", "kCojiImageIndex_Default_1f61b_C", "kCojiImageIndex_Default_1f620", "kCojiImageIndex_Default_1f620_B", "kCojiImageIndex_Default_1f620_C", "kCojiImageIndex_Default_1f622", "kCojiImageIndex_Default_1f622_B", "kCojiImageIndex_Default_1f622_C", "kCojiImageIndex_Default_1f622_D", "kCojiImageIndex_Default_1f622_E", "kCojiImageIndex_Default_1f622_F", "kCojiImageIndex_Default_1f622_G", "kCojiImageIndex_Default_1f622_H", "kCojiImageIndex_Default_1f622_I", "kCojiImageIndex_Default_1f622_J", "kCojiImageIndex_Default_1f622_K", "kCojiImageIndex_Default_1f631", "kCojiImageIndex_Default_1f631_B", "kCojiImageIndex_Default_1f631_C", "kCojiImageIndex_Default_1f631_D", "kCojiImageIndex_Default_1f631_E", "kCojiImageIndex_Default_1f631_F", "kCojiImageIndex_Default_1f631_G", "kCojiImageIndex_Default_1f631_H", "kCojiImageIndex_Default_1f634", "kCojiImageIndex_Default_1f634_B", "kCojiImageIndex_Default_1f634_C", "kCojiImageIndex_Default_1f634_D", "kCojiImageIndex_Default_1f634_E", "kCojiImageIndex_Default_1f634_F", "kCojiImageIndex_Default_1f634_G", "kCojiImageIndex_Default_1f634_H", "kCojiImageIndex_Default_1f635", "kCojiImageIndex_Default_1f635_B", "kCojiImageIndex_Default_1f635_C", "kCojiImageIndex_Default_1f635_D", "kCojiImageIndex_Default_1f635_E", "kCojiImageIndex_Default_1f635_F", "kCojiImageIndex_Default_1f635_G", "kCojiImageIndex_Default_1f635_H", "kCojiImageIndex_Default_2196", "kCojiImageIndex_Default_2196_B", "kCojiImageIndex_Default_2196_C", "kCojiImageIndex_Default_2196_D", "kCojiImageIndex_Default_2196_E", "kCojiImageIndex_Default_2197", "kCojiImageIndex_Default_2197_B", "kCojiImageIndex_Default_2197_C", "kCojiImageIndex_Default_2197_D", "kCojiImageIndex_Default_2197_E", "kCojiImageIndex_Default_2934", "kCojiImageIndex_Default_2934_B", "kCojiImageIndex_Default_2934_C", "kCojiImageIndex_Default_2934_D", "kCojiImageIndex_Default_2934_E", "kCojiImageIndex_Default_2935", "kCojiImageIndex_Default_2935_B", "kCojiImageIndex_Default_2935_C", "kCojiImageIndex_Default_2935_D", "kCojiImageIndex_Default_2935_E", "kCojiImageIndex_Default_2B06", "kCojiImageIndex_Default_2B06_B", "kCojiImageIndex_Default_2B06_C", "kCojiImageIndex_Default_2B06_D", "kCojiImageIndex_Default_2B06_E", "kCojiImageIndex_Default_2B07", "kCojiImageIndex_Default_2B07_B", "kCojiImageIndex_Default_2B07_C", "kCojiImageIndex_Default_2B07_D", "kCojiImageIndex_Default_2B07_E", "kCojiImageIndex_Default_3030", "kCojiImageIndex_Default_3030_B", "kCojiImageIndex_Default_3030_C", "kCojiImageIndex_Default_3030_D", "kCojiImageIndex_Default_3030_E", "kCojiImageIndex_Default_Blank_Gery", "kCojiImageIndex_Eyes_Eyes_1", "kCojiImageIndex_Eyes_Eyes_2", "kCojiImageIndex_Eyes_Eyes_3", "kCojiImageIndex_Eyes_Eyes_DownA", "kCojiImageIndex_Eyes_Eyes_DownB", "kCojiImageIndex_Eyes_Eyes_DownC", "kCojiImageIndex_Eyes_Eyes_DownD", "kCojiImageIndex_Eyes_Eyes_IpB", "kCojiImageIndex_Eyes_Eyes_LeftA", "kCojiImageIndex_Eyes_Eyes_LeftB", "kCojiImageIndex_Eyes_Eyes_LeftC", "kCojiImageIndex_Eyes_Eyes_PleadA", "kCojiImageIndex_Eyes_Eyes_PleadB", "kCojiImageIndex_Eyes_Eyes_PleadC", "kCojiImageIndex_Eyes_Eyes_PleadD", "kCojiImageIndex_Eyes_Eyes_PleadE", "kCojiImageIndex_Eyes_Eyes_PleadF", "kCojiImageIndex_Eyes_Eyes_PleadG", "kCojiImageIndex_Eyes_Eyes_PleadH", "kCojiImageIndex_Eyes_Eyes_PleadI", "kCojiImageIndex_Eyes_Eyes_PleadJ", "kCojiImageIndex_Eyes_Eyes_RightA", "kCojiImageIndex_Eyes_Eyes_RightB", "kCojiImageIndex_Eyes_Eyes_RightC", "kCojiImageIndex_Eyes_Eyes_ShyA", "kCojiImageIndex_Eyes_Eyes_ShyB", "kCojiImageIndex_Eyes_Eyes_ShyC", "kCojiImageIndex_Eyes_Eyes_ShyD", "kCojiImageIndex_Eyes_Eyes_ShyE", "kCojiImageIndex_Eyes_Eyes_ShyF", "kCojiImageIndex_Eyes_Eyes_ShyG", "kCojiImageIndex_Eyes_Eyes_ShyH", "kCojiImageIndex_Eyes_Eyes_UpA", "kCojiImageIndex_Eyes_Eyes_UpB", "kCojiImageIndex_Eyes_Eyes_UpC", "kCojiImageIndex_Eyes_Eyes_UpD", "kCojiImageIndex_Eyes_Eyes_UpE", "kCojiImageIndex_Eyes_Eyes_Wink", "kCojiImageIndex_Eyes_Eyes_WinkB", "kCojiImageIndex_Eyes_Eyes_angryA", "kCojiImageIndex_Eyes_Eyes_angryB", "kCojiImageIndex_Eyes_Eyes_boredA", "kCojiImageIndex_Eyes_Eyes_boredB", "kCojiImageIndex_Eyes_Eyes_boredC", "kCojiImageIndex_Eyes_Eyes_boredD", "kCojiImageIndex_Eyes_Eyes_boredE", "kCojiImageIndex_Eyes_Eyes_boredF", "kCojiImageIndex_Eyes_Eyes_cheekyA", "kCojiImageIndex_Eyes_Eyes_cheekyB", "kCojiImageIndex_Eyes_Eyes_cheekyC", "kCojiImageIndex_Eyes_Eyes_confusedA", "kCojiImageIndex_Eyes_Eyes_confusedB", "kCojiImageIndex_Eyes_Eyes_confusedC", "kCojiImageIndex_Eyes_Eyes_confusedD", "kCojiImageIndex_Eyes_Eyes_confusedE", "kCojiImageIndex_Eyes_Eyes_confusedF", "kCojiImageIndex_Eyes_Eyes_dizzyA", "kCojiImageIndex_Eyes_Eyes_dizzyB", "kCojiImageIndex_Eyes_Eyes_dizzyC", "kCojiImageIndex_Eyes_Eyes_dizzyD", "kCojiImageIndex_Eyes_Eyes_dizzyE", "kCojiImageIndex_Eyes_Eyes_dizzyF", "kCojiImageIndex_Eyes_Eyes_dizzyG", "kCojiImageIndex_Eyes_Eyes_dizzyH", "kCojiImageIndex_Eyes_Eyes_dizzyI", "kCojiImageIndex_Eyes_Eyes_exciteA", "kCojiImageIndex_Eyes_Eyes_exciteB", "kCojiImageIndex_Eyes_Eyes_exciteC", "kCojiImageIndex_Eyes_Eyes_exciteD", "kCojiImageIndex_Eyes_Eyes_grumpyA", "kCojiImageIndex_Eyes_Eyes_grumpyB", "kCojiImageIndex_Eyes_Eyes_sadA", "kCojiImageIndex_Eyes_Eyes_sadB", "kCojiImageIndex_Eyes_Eyes_sadC", "kCojiImageIndex_Eyes_Eyes_sadcryA", "kCojiImageIndex_Eyes_Eyes_sadcryB", "kCojiImageIndex_Eyes_Eyes_sadcryC", "kCojiImageIndex_Eyes_Eyes_sadcryD", "kCojiImageIndex_Eyes_Eyes_sadcryE", "kCojiImageIndex_Eyes_Eyes_sadcryF", "kCojiImageIndex_Eyes_Eyes_sadcryG", "kCojiImageIndex_Eyes_Eyes_sadcryH", "kCojiImageIndex_Eyes_Eyes_sadcryI", "kCojiImageIndex_Eyes_Eyes_sadcryJ", "kCojiImageIndex_Eyes_Eyes_sadcryK", "kCojiImageIndex_Eyes_Eyes_sadcryL", "kCojiImageIndex_Eyes_Eyes_seriousA", "kCojiImageIndex_Eyes_Eyes_seriousB", "kCojiImageIndex_Eyes_Eyes_sleepA", "kCojiImageIndex_Eyes_Eyes_sleepB", "kCojiImageIndex_Eyes_Eyes_sleepC", "kCojiImageIndex_Eyes_Eyes_surprisedA", "kCojiImageIndex_Eyes_Eyes_surprisedB", "kCojiImageIndex_Eyes_Eyes_tiredA", "kCojiImageIndex_Eyes_Eyes_tiredB", "kCojiImageIndex_Eyes_Eyes_tiredC", "kCojiImageIndex_Eyes_Eyes_tiredD", "kCojiImageIndex_Eyes_Eyes_tiredE", "kCojiImageIndex_Reward_1f327", "kCojiImageIndex_Reward_1f327_B", "kCojiImageIndex_Reward_1f328", "kCojiImageIndex_Reward_1f328_B", "kCojiImageIndex_Reward_1f328_C", "kCojiImageIndex_Reward_1f342", "kCojiImageIndex_Reward_1f342_B", "kCojiImageIndex_Reward_1f342_C", "kCojiImageIndex_Reward_1f355", "kCojiImageIndex_Reward_1f355_B", "kCojiImageIndex_Reward_1f355_C", "kCojiImageIndex_Reward_1f355_D", "kCojiImageIndex_Reward_1f355_E", "kCojiImageIndex_Reward_1f355_F", "kCojiImageIndex_Reward_1f355_G", "kCojiImageIndex_Reward_1f367", "kCojiImageIndex_Reward_1f367_B", "kCojiImageIndex_Reward_1f367_C", "kCojiImageIndex_Reward_1f367_D", "kCojiImageIndex_Reward_1f367_E", "kCojiImageIndex_Reward_1f367_F", "kCojiImageIndex_Reward_1f381", "kCojiImageIndex_Reward_1f383", "kCojiImageIndex_Reward_1f383_B", "kCojiImageIndex_Reward_1f387_", "kCojiImageIndex_Reward_1f387_B", "kCojiImageIndex_Reward_1f387_C", "kCojiImageIndex_Reward_1f387_D", "kCojiImageIndex_Reward_1f387_E", "kCojiImageIndex_Reward_1f387_F", "kCojiImageIndex_Reward_1f387_G", "kCojiImageIndex_Reward_1f3a0", "kCojiImageIndex_Reward_1f3a7", "kCojiImageIndex_Reward_1f3b0", "kCojiImageIndex_Reward_1f3b0_B", "kCojiImageIndex_Reward_1f3b0_C", "kCojiImageIndex_Reward_1f3b0_D", "kCojiImageIndex_Reward_1f3b0_E", "kCojiImageIndex_Reward_1f3b0_F", "kCojiImageIndex_Reward_1f3b0_G", "kCojiImageIndex_Reward_1f3c2", "kCojiImageIndex_Reward_1f3c2_B", "kCojiImageIndex_Reward_1f3c2_C", "kCojiImageIndex_Reward_1f3c2_D", "kCojiImageIndex_Reward_1f3c2_E", "kCojiImageIndex_Reward_1f3c2_F", "kCojiImageIndex_Reward_1f3c4", "kCojiImageIndex_Reward_1f3c4_B", "kCojiImageIndex_Reward_1f3c5", "kCojiImageIndex_Reward_1f3c6", "kCojiImageIndex_Reward_1f3c6_B", "kCojiImageIndex_Reward_1f3c8", "kCojiImageIndex_Reward_1f3c8_B", "kCojiImageIndex_Reward_1f3c8_C", "kCojiImageIndex_Reward_1f3d2", "kCojiImageIndex_Reward_1f3d2_B", "kCojiImageIndex_Reward_1f3d2_C", "kCojiImageIndex_Reward_1f3d2_D", "kCojiImageIndex_Reward_1f3d2_E", "kCojiImageIndex_Reward_1f3d2_F", "kCojiImageIndex_Reward_1f3d2_G", "kCojiImageIndex_Reward_1f3d5", "kCojiImageIndex_Reward_1f3d6", "kCojiImageIndex_Reward_1f3eb", "kCojiImageIndex_Reward_1f3eb_B", "kCojiImageIndex_Reward_1f3eb_C", "kCojiImageIndex_Reward_1f3f0", "kCojiImageIndex_Reward_1f3f0_B", "kCojiImageIndex_Reward_1f407", "kCojiImageIndex_Reward_1f407_B", "kCojiImageIndex_Reward_1f407_C", "kCojiImageIndex_Reward_1f41d", "kCojiImageIndex_Reward_1f41d_B", "kCojiImageIndex_Reward_1f423", "kCojiImageIndex_Reward_1f423_B", "kCojiImageIndex_Reward_1f423_C", "kCojiImageIndex_Reward_1f423_D", "kCojiImageIndex_Reward_1f423_E", "kCojiImageIndex_Reward_1f441", "kCojiImageIndex_Reward_1f441_B", "kCojiImageIndex_Reward_1f441_C", "kCojiImageIndex_Reward_1f441_D", "kCojiImageIndex_Reward_1f451", "kCojiImageIndex_Reward_1f496", "kCojiImageIndex_Reward_1f496_B", "kCojiImageIndex_Reward_1f4a5", "kCojiImageIndex_Reward_1f4a5_B", "kCojiImageIndex_Reward_1f4a5_C", "kCojiImageIndex_Reward_1f4a5_D", "kCojiImageIndex_Reward_1f4a5_E", "kCojiImageIndex_Reward_1f4a5_F", "kCojiImageIndex_Reward_1f4ab", "kCojiImageIndex_Reward_1f4ab_B", "kCojiImageIndex_Reward_1f4ab_C", "kCojiImageIndex_Reward_1f4ab_D", "kCojiImageIndex_Reward_1f4ab_E", "kCojiImageIndex_Reward_1f4ab_F", "kCojiImageIndex_Reward_1f4cc", "kCojiImageIndex_Reward_1f60d", "kCojiImageIndex_Reward_1f60d_B", "kCojiImageIndex_Reward_1f68c", "kCojiImageIndex_Reward_1f68d", "kCojiImageIndex_Reward_1f910", "kCojiImageIndex_Reward_1f910E", "kCojiImageIndex_Reward_1f910_B", "kCojiImageIndex_Reward_1f910_C", "kCojiImageIndex_Reward_1f910_D", "kCojiImageIndex_Reward_1f910_G", "kCojiImageIndex_Reward_2603", "kCojiImageIndex_Reward_2603_B", "kCojiImageIndex_Reward_262e", "kCojiImageIndex_Reward_26a1", "kCojiImageIndex_Reward_26a1_B", "kCojiImageIndex_Reward_26a1_C", "kCojiImageIndex_Tool_1F354", "kCojiImageIndex_Tool_1F354_B", "kCojiImageIndex_Tool_1F354_C", "kCojiImageIndex_Tool_1F354_D", "kCojiImageIndex_Tool_1F354_E", "kCojiImageIndex_Tool_1F354_F", "kCojiImageIndex_Tool_1F354_G", "kCojiImageIndex_Tool_1F354_H", "kCojiImageIndex_Tool_1F354_I", "kCojiImageIndex_Tool_1F354_J", "kCojiImageIndex_Tool_1F354_K", "kCojiImageIndex_Tool_1F4a1", "kCojiImageIndex_Tool_1F4a1_B", "kCojiImageIndex_Tool_1F4a1_C", "kCojiImageIndex_Tool_1F4a1_D", "kCojiImageIndex_Tool_1F4a1_E", "kCojiImageIndex_Tool_1F4a1_F", "kCojiImageIndex_Tool_1f308", "kCojiImageIndex_Tool_1f308_B", "kCojiImageIndex_Tool_1f308_C", "kCojiImageIndex_Tool_1f308_D", "kCojiImageIndex_Tool_1f308_E", "kCojiImageIndex_Tool_1f308_G", "kCojiImageIndex_Tool_1f308_H", "kCojiImageIndex_Tool_1f30b", "kCojiImageIndex_Tool_1f30b_B", "kCojiImageIndex_Tool_1f30b_C", "kCojiImageIndex_Tool_1f30b_D", "kCojiImageIndex_Tool_1f30b_E", "kCojiImageIndex_Tool_1f30b_F", "kCojiImageIndex_Tool_1f30b_G", "kCojiImageIndex_Tool_1f30b_H", "kCojiImageIndex_Tool_1f32a", "kCojiImageIndex_Tool_1f32a_B", "kCojiImageIndex_Tool_1f32d", "kCojiImageIndex_Tool_1f32d_B", "kCojiImageIndex_Tool_1f32d_C", "kCojiImageIndex_Tool_1f32d_D", "kCojiImageIndex_Tool_1f32d_E", "kCojiImageIndex_Tool_1f34c", "kCojiImageIndex_Tool_1f34c_B", "kCojiImageIndex_Tool_1f34c_C", "kCojiImageIndex_Tool_1f34c_D", "kCojiImageIndex_Tool_1f366", "kCojiImageIndex_Tool_1f366_B", "kCojiImageIndex_Tool_1f366_C", "kCojiImageIndex_Tool_1f366_D", "kCojiImageIndex_Tool_1f366_E", "kCojiImageIndex_Tool_1f366_F", "kCojiImageIndex_Tool_1f37c", "kCojiImageIndex_Tool_1f37c_B", "kCojiImageIndex_Tool_1f37c_C", "kCojiImageIndex_Tool_1f37c_D", "kCojiImageIndex_Tool_1f37c_E", "kCojiImageIndex_Tool_1f37c_F", "kCojiImageIndex_Tool_1f382", "kCojiImageIndex_Tool_1f382_B", "kCojiImageIndex_Tool_1f388", "kCojiImageIndex_Tool_1f388_B", "kCojiImageIndex_Tool_1f389", "kCojiImageIndex_Tool_1f389_B", "kCojiImageIndex_Tool_1f39f", "kCojiImageIndex_Tool_1f39f_B", "kCojiImageIndex_Tool_1f3a3", "kCojiImageIndex_Tool_1f3a3_B", "kCojiImageIndex_Tool_1f3a3_C", "kCojiImageIndex_Tool_1f3a3_D", "kCojiImageIndex_Tool_1f3a3_E", "kCojiImageIndex_Tool_1f3a3_F", "kCojiImageIndex_Tool_1f3a4", "kCojiImageIndex_Tool_1f3a4_B", "kCojiImageIndex_Tool_1f3b7", "kCojiImageIndex_Tool_1f3b7_B", "kCojiImageIndex_Tool_1f3b8", "kCojiImageIndex_Tool_1f3b8_B", "kCojiImageIndex_Tool_1f484", "kCojiImageIndex_Tool_1f484_B", "kCojiImageIndex_Tool_1f484_C", "kCojiImageIndex_Tool_1f484_D", "kCojiImageIndex_Tool_1f484_E", "kCojiImageIndex_Tool_1f484_F", "kCojiImageIndex_Tool_1f48b", "kCojiImageIndex_Tool_1f48b_B", "kCojiImageIndex_Tool_1f48c", "kCojiImageIndex_Tool_1f511", "kCojiImageIndex_Tool_1f511_B", "kCojiImageIndex_Tool_1f511_C", "kCojiImageIndex_Tool_1f511_D", "kCojiImageIndex_Tool_1f525", "kCojiImageIndex_Tool_1f525_B", "kCojiImageIndex_Tool_1f526", "kCojiImageIndex_Tool_1f526_B", "kCojiImageIndex_Tool_1f526_C", "kCojiImageIndex_Tool_1f526_D", "kCojiImageIndex_Tool_1f527", "kCojiImageIndex_Tool_1f527_B", "kCojiImageIndex_Tool_1f528", "kCojiImageIndex_Tool_1f528_B", "kCojiImageIndex_Tool_1f52e", "kCojiImageIndex_Tool_1f52e_B", "kCojiImageIndex_Tool_1f576", "kCojiImageIndex_Tool_1f576_B", "kCojiImageIndex_Tool_1f576_C", "kCojiImageIndex_Tool_1f6bd", "kCojiImageIndex_Tool_1f9c0", "kCojiImageIndex_Tool_23f0", "kCojiImageIndex_Tool_23f0_B", "kCojiImageIndex_Tool_23f0_C", "kCojiImageIndex_Tool_23f0_D", "kCojiImageIndex_Tool_23f0_E", "kCojiImageIndex_Tool_23f0_F", "kCojiImageIndex_Tool_23f0_G", "kCojiImageIndex_Tool_23f0_H", "kCojiImageIndex_Tool_23f0_I", "kCojiImageIndex_Tool_2602", "kCojiImageIndex_Tool_2602_B", "kCojiImageIndex_Tool_2602_C", "kCojiImageIndex_Tool_26bd", "kCojiImageIndex_Tool_26bd_B", "kCojiImageIndex_Vehicle_1F3cd", "kCojiImageIndex_Vehicle_1F3cd_B", "kCojiImageIndex_Vehicle_1F3cd_C", "kCojiImageIndex_Vehicle_1F680", "kCojiImageIndex_Vehicle_1F680_B", "kCojiImageIndex_Vehicle_1F680_C", "kCojiImageIndex_Vehicle_1F680_D", "kCojiImageIndex_Vehicle_1F681", "kCojiImageIndex_Vehicle_1F681_B", "kCojiImageIndex_Vehicle_1F681_C", "kCojiImageIndex_Vehicle_1F682", "kCojiImageIndex_Vehicle_1F682_B", "kCojiImageIndex_Vehicle_1F692_A", "kCojiImageIndex_Vehicle_1F692_B", "kCojiImageIndex_Vehicle_1F692_C", "kCojiImageIndex_Vehicle_1F692_D", "kCojiImageIndex_Vehicle_1F692_E", "kCojiImageIndex_Vehicle_1F692_F", "kCojiImageIndex_Vehicle_1F692_G", "kCojiImageIndex_Vehicle_1F692_H", "kCojiImageIndex_Vehicle_1F692_I", "kCojiImageIndex_Vehicle_1F692_J", "kCojiImageIndex_Vehicle_1F692_K", "kCojiImageIndex_Vehicle_1F692_L", "kCojiImageIndex_Vehicle_1F692_M", "kCojiImageIndex_Vehicle_1F692_Njpg", "kCojiImageIndex_Vehicle_1F692_O", "kCojiImageIndex_Vehicle_1F693", "kCojiImageIndex_Vehicle_1F693_B", "kCojiImageIndex_Vehicle_1F6F3", "kCojiImageIndex_Vehicle_1F6F3_B", "kCojiImageIndex_Vehicle_1f3a2", "kCojiImageIndex_Vehicle_1f3a2_B", "kCojiImageIndex_Vehicle_1f3a2_C", "kCojiImageIndex_Vehicle_1f3a2_D", "kCojiImageIndex_Vehicle_1f3a2_E", "kCojiImageIndex_Vehicle_1f3a2_F", "kCojiImageIndex_Vehicle_1f3a2_G", "kCojiImageIndex_Vehicle_1f3a2_H", "kCojiImageIndex_Vehicle_1f3a2_I", "kCojiImageIndex_Vehicle_1f3a2_J", "kCojiImageIndex_Vehicle_1f3c1", "kCojiImageIndex_Vehicle_1f3c1_B", "kCojiImageIndex_Vehicle_1f3c1_C", "kCojiImageIndex_Vehicle_1f3c3", "kCojiImageIndex_Vehicle_1f3c3_B", "kCojiImageIndex_Vehicle_1f3c3_C", "kCojiImageIndex_Vehicle_1f3ce", "kCojiImageIndex_Vehicle_1f3ce_B", "kCojiImageIndex_Vehicle_1f3ce_C", "kCojiImageIndex_Vehicle_1f3ce_D", "kCojiImageIndex_Vehicle_1f3ce_E", "kCojiImageIndex_Vehicle_1f3ce_F", "kCojiImageIndex_Vehicle_1f3d7", "kCojiImageIndex_Vehicle_1f3d7_B", "kCojiImageIndex_Vehicle_1f3d7_C", "kCojiImageIndex_Vehicle_1f3d7_D", "kCojiImageIndex_Vehicle_1f3d7_E", "kCojiImageIndex_Vehicle_1f3d7_F", "kCojiImageIndex_Vehicle_1f4a6", "kCojiImageIndex_Vehicle_1f4a6_B", "kCojiImageIndex_Vehicle_1f4a8", "kCojiImageIndex_Vehicle_1f4a8_B", "kCojiImageIndex_Vehicle_1f691", "kCojiImageIndex_Vehicle_1f691_B", "kCojiImageIndex_Vehicle_1f6a6", "kCojiImageIndex_Vehicle_1f6a6_B", "kCojiImageIndex_Vehicle_1f6e5", "kCojiImageIndex_Vehicle_1f6e5_B", "kCojiImageIndex_Vehicle_1f6e5_C", "kCojiImageIndex_Vehicle_1f6e5_D", "kCojiImageIndex_Vehicle_2693", "kCojiImageIndex_Vehicle_2693_B", "kCojiImageIndex_Vehicle_2693_C", "kCojiImageIndex_Vehicle_26fd", "kCojiImageIndex_Vehicle_26fd_B", "kCojiImageIndex_Vehicle_26fd_C", "kCojiImageIndex_Vehicle_26fd_D", "kCojiImageIndex_Vehicle_2708", "kCojiImageIndex_Vehicle_2708_B"};
        String[] templateArr = {"Back", "kCojiImage_AnimationTemplate_ScaleUp", "kCojiImage_AnimationTemplate_ScaleDown", "kCojiImage_AnimationTemplate_RightToLeft", "kCojiImage_AnimationTemplate_LeftToRight", "kCojiImage_AnimationTemplate_CenterToLeft", "kCojiImage_AnimationTemplate_CenterToRight", "kCojiImage_AnimationTemplate_DownToCenter", "kCojiImage_AnimationTemplate_CenterToDown", "kCojiImage_AnimationTemplate_UpToCenter", "kCojiImage_AnimationTemplate_CenterToUp", "kCojiImage_AnimationTemplate_None"};
        listArr = arr;
        templateListArr = templateArr;

        selectedTemplate = false;
        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, templateListArr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (selectedTemplate == false) {
                    switch (position) {
                        case 0:
                            FragmentHelper.switchFragment(getActivity().getSupportFragmentManager(), new PlayingFragment(), R.id.view_id_content, false);
                            break;
                        default:
                            selectedTemplate = true;
                            switch (position-1) {
                                case 0:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_ScaleUp;
                                    break;
                                case 1:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_ScaleDown;
                                    break;
                                case 2:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_RightToLeft;
                                    break;
                                case 3:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_LeftToRight;
                                    break;
                                case 4:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_CenterToLeft;
                                    break;
                                case 5:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_CenterToRight;
                                    break;
                                case 6:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_DownToCenter;
                                    break;
                                case 7:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_CenterToDown;
                                    break;
                                case 8:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_UpToCenter;
                                    break;
                                case 9:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_CenterToUp;
                                    break;
                                case 10:
                                    selectedTemplateIndex = kCojiImage_AnimationTemplate.kCojiImage_AnimationTemplate_None;
                                    break;
                            }

                            adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, listArr);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                            break;
                    }
                }
                else {
                    if (CojiRobotFinder.getInstance().getCojiRobotConnectedList().size() > 0) {
                        CojiRobot robot = (CojiRobot) CojiRobotFinder.getInstance().getCojiRobotConnectedList().get(0);
                        switch (position) {
                            case 0:
                                selectedTemplate = false;
                                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, templateListArr);
                                listView.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                                break;
                            case 1:
                                robot.stopCommand(CojiRobotConstant.kCojiStopType.kCojiStopTypeAnimation);
                                break;
                            default:
                                robot.showImage(selectedTemplateIndex, position - 2);
                                break;
                        }
                    }
                }
            }
        });

        handler = new Handler();

        return view;
    }

    @Override
    public void cojiDidReceiveImageStatus(CojiRobot cojiRobot, final CojiRobotConstant.kCojiImageStatus status, final int arbitraryImageID) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Image ID: " + (int)arbitraryImageID);
                switch (status) {
                    case kCojiImageStatusStarted:
                        alertDialog.setMessage("Started");
                        break;
                    case kCojiImageStatusFinished:
                        alertDialog.setMessage("Finished");
                        break;
                    case kCojiImageStatusStopped:
                        alertDialog.setMessage("Stopped");
                        break;
                    case kCojiImageStatusFailed:
                        alertDialog.setMessage("Failed");
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
