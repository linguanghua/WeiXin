package com.junxu.weixin;

import java.util.ArrayList;
import java.util.List;

import com.junxu.weixin.fragment.FXFragment;
import com.junxu.weixin.fragment.TXFragment;
import com.junxu.weixin.fragment.WFragment;
import com.junxu.weixin.fragment.WXFragment;

 

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener, OnPageChangeListener {
	private ViewPager vPager ;
	private FragmentPagerAdapter faAdapter;
	List<Fragment> fragments;
	private ImageButton btn_wx;
	private ImageButton btn_tx;
	private ImageButton btn_fx;
	private ImageButton btn_w;
	private TextView tv_wx;
	private TextView tv_tx;
	private TextView tv_fx;
	private TextView tv_w;
	private int ids[] = {R.id.wx,R.id.tx,R.id.tv_fx,R.id.w};
	private int pic_sle[] = {R.drawable.al_,R.drawable.al8,R.drawable.alb,R.drawable.ald};
	private int pic[] = {R.drawable.ala,R.drawable.al9,R.drawable.alc,R.drawable.ale};
	private List<ImageButton> img_btn ;
	private List<TextView> tvs;
	private int id = -1;
	
	private void init() {
		vPager = (ViewPager) findViewById(R.id.vpager);
		
		btn_wx = (ImageButton) findViewById(R.id.wx);
		btn_tx = (ImageButton) findViewById(R.id.tx);
		btn_fx = (ImageButton) findViewById(R.id.fx);
		btn_w  = (ImageButton) findViewById(R.id.w);
		
		tv_wx = (TextView) findViewById(R.id.tv_wx);
		tv_tx = (TextView) findViewById(R.id.tv_tx);
		tv_fx = (TextView) findViewById(R.id.tv_fx);
		tv_w = (TextView) findViewById(R.id.tv_w);
		
		tv_wx.setOnClickListener(this);
		tv_tx.setOnClickListener(this);
		tv_fx.setOnClickListener(this);
		tv_w.setOnClickListener(this);
		
		tvs = new ArrayList<TextView>();
		tvs.add(tv_wx);
		tvs.add(tv_tx);
		tvs.add(tv_fx);
		tvs.add(tv_w);
		
		btn_wx.setOnClickListener(this);
		btn_tx.setOnClickListener(this);
		btn_fx.setOnClickListener(this);
		btn_w.setOnClickListener(this);
		img_btn = new ArrayList<ImageButton>();
		img_btn.add(btn_wx);
		img_btn.add(btn_tx);
		img_btn.add(btn_fx);
		img_btn.add(btn_w);
		
		fragments = new ArrayList<Fragment>();
		fragments.add(new WXFragment());
		fragments.add(new TXFragment());
		fragments.add(new FXFragment());
		fragments.add(new WFragment());
		
		faAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return fragments.size();
			}
			
			@Override
			public Fragment getItem(int arg0) {
				return fragments.get(arg0);
			}
		};
		
		vPager.setAdapter(faAdapter);
		vPager.setOnPageChangeListener(this);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
			case R.id.action_s:
				Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_search:
				Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
				break;
	
			 
		}
		if (id == R.id.action_s) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.wx || v.getId()==R.id.tv_wx){
			id=0;
			vPager.setCurrentItem(0);
		}else if(v.getId()==R.id.tx || v.getId()==R.id.tv_tx){
			id=1;
			vPager.setCurrentItem(1);
		}else if(v.getId()==R.id.fx || v.getId()==R.id.tv_fx){
			id=2;
			vPager.setCurrentItem(2);
		}else if(v.getId()==R.id.w || v.getId()==R.id.tv_w){
			id=3;
			vPager.setCurrentItem(3);
		}
		
		 
		changeStatus(id);
		
	}
	
	private void changeStatus(int id){
		for(int  i=0;i<ids.length;i++){
			if(i == id){
				tvs.get(i).setTextColor(getResources().getColor(R.color.green));
				img_btn.get(i).setImageDrawable(getResources().getDrawable(pic_sle[i]));
			}else{
				tvs.get(i).setTextColor(getResources().getColor(R.color.gray));
				img_btn.get(i).setImageDrawable(getResources().getDrawable(pic[i]));
			}
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int arg0) {
		changeStatus(arg0);
	}
	
	 
 

}
