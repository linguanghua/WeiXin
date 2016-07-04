package com.junxu.weixin;

import java.util.ArrayList;
import java.util.List;

import com.junxu.weixin.fragment.FirstFragment;
import com.junxu.weixin.fragment.SecondFragment;
import com.junxu.weixin.fragment.ThirdFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class Guide extends FragmentActivity{
	private ViewPager vp;
	private List<Fragment> fragments;
	private FragmentPagerAdapter fpAdapter;
	
	private void init() {
		vp = (ViewPager) findViewById(R.id.vp);
		fragments = new ArrayList<Fragment>();
		fragments.add(new FirstFragment());
		fragments.add(new SecondFragment());
		fragments.add(new ThirdFragment());
		
		fpAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return fragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				return fragments.get(arg0);
			}
		};
		
		 
		
		vp.setAdapter(fpAdapter);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guide);
		super.onCreate(savedInstanceState);
		 
		init();
	}

}
