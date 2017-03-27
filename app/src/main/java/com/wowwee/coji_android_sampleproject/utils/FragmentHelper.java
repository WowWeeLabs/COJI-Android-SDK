package com.wowwee.coji_android_sampleproject.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;

public class FragmentHelper {
	public static List<WeakReference<Fragment>> fragments = new ArrayList<WeakReference<Fragment>>();
	
	private static ArrayList<String> backStackKeys = new ArrayList<String>();
	private static int backStackIndex = 0;
	
	public static void switchFragment(FragmentManager fragmentManager, Fragment fragment, int containViewId, boolean addToBackStack)
	{
//		fragments.add(new WeakReference<Fragment>(fragment));
//		
//		FragmentTransaction transaction = fragmentManager.beginTransaction();
//		transaction.replace(containViewId, fragment);
////		transaction.replace(containViewId, fragment, fragment.getClass().toString());
//		if (addToBackStack)
//		{
//			backStackIndex++;
//			String key = "" + backStackIndex;
//			transaction.addToBackStack(key);
//			backStackKeys.add(key);
//		}
//		else
//		{
////			transaction.addToBackStack(null);
//		}
//		
//		transaction.commit();
		
		boolean isContain = false;
		for (int i = 0; i < fragments.size(); i++){
			if (fragments.get(i).get() != null && fragments.get(i).get().getClass() == fragment.getClass()){
				isContain = true;
				break;
			}
		}
		if (!isContain){
			fragments.add(new WeakReference<Fragment>(fragment));
		}
		
		if (fragment.getView() != null){
			fragment.getView().setClickable(true);
		}
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (addToBackStack)
		{
			backStackIndex++;
			String key = "" + backStackIndex;
			transaction.addToBackStack(key);
			backStackKeys.add(key);
			
		}
		else
		{
//			transaction.addToBackStack(null);
		}
		transaction.replace(containViewId, fragment, ""+backStackIndex);
		transaction.commitAllowingStateLoss();
	}
	
	public static void hideAndShowFragment(FragmentManager fragmentManager, Fragment[] hideFragment, Fragment[] showFragment){
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		for (Fragment fragment : showFragment){
			transaction.show(fragment);
		}
		for (Fragment fragment : hideFragment){
			transaction.hide(fragment);
		}
		
		transaction.commitAllowingStateLoss();
	}
	
	public static void reloadFragment(FragmentManager fragmentManager, Fragment fragment, int containViewId) {
		if (fragment != null){
			FragmentTransaction ft = fragmentManager.beginTransaction();
			ft.setTransition(-1);
	//		ft.replace(containViewId, fragment);
			ft.detach(fragment);
			ft.attach(fragment);
			ft.commitAllowingStateLoss();
		}
	}
	
	public static void reloadFragment(FragmentManager fragmentManager, Fragment fragment) {
		if (fragment != null){
			FragmentTransaction ft = fragmentManager.beginTransaction();
//			ft.setTransition(-1);
	//		ft.replace(containViewId, fragment);
			ft.detach(fragment);
			ft.attach(fragment);
			ft.commitAllowingStateLoss();
		}
	}
	
	public static boolean popBackStack(FragmentManager fragmentManager)
	{
		if(backStackKeys.size() > 0)
		{
			String popToKey = backStackKeys.get(backStackKeys.size() - 1);
			backStackKeys.remove(backStackKeys.size() - 1);
			fragmentManager.popBackStack(popToKey, FragmentManager.POP_BACK_STACK_INCLUSIVE);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void popToRoot(FragmentManager fragmentManager) {
		if(backStackKeys.size() > 0) {
			String popToKey = backStackKeys.get(0);
			backStackKeys.clear();
			fragmentManager.popBackStack(popToKey, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}
	}
	
	public static void removeFragment(FragmentManager fragmentManager, int containViewId)
	{
		if(fragmentManager != null) {
			Fragment fragment = fragmentManager.findFragmentById(containViewId);
			if (fragment != null)
			{
				fragments.remove(fragment);
				
				// TODO: Remove from backStackKeys
				
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				transaction.remove(fragment);
				transaction.commitAllowingStateLoss();
			}
		}
		else {
			Log.e("FragmentHelper", "Fragment Manager = null");
		}
	}
	
	public static void clearAllBackStackFragments(FragmentManager fragmentManager)
	{
		FragmentTransaction ft = fragmentManager.beginTransaction();

	    for (WeakReference<Fragment> ref : fragments) {
	        Fragment fragment = ref.get();
	        if (fragment != null) {
	            ft.remove(fragment);
	        }
	    }
	    fragments.clear();
	    backStackKeys.clear();

	    ft.commitAllowingStateLoss();
	}
	
	public static Fragment getCurrentFragment()
	{
		Fragment fragment = null;
		if(fragments.size() > 0)
		{
			fragment = (fragments.get((fragments.size() - 1))).get();
		}
		return fragment;
	}
	
	public static void reloadAllFragments(FragmentManager fragmentManager){
		for (int i = 0; i < fragments.size(); i++){
			reloadFragment(fragmentManager, fragments.get(i).get());
		}
	}
}
