package com.junxu.weixin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class WelcomeActivity extends Activity{
	private Handler handler;
	private boolean isFirstIn=true;
	
	static class MyHandler extends Handler{
		Context context;
		public MyHandler(Context context) {
			this.context = context;
		}
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				startMain();
				break;
			case 1:
				startGuide();
				break;
		}
			super.handleMessage(msg);
		}
		
		public void startMain(){
			Intent intent = new Intent(context,MainActivity.class);
			context.startActivity(intent);
			((Activity) context).finish();
		}
		
		public void startGuide(){
			Intent intent = new Intent(context,Guide.class);
			context.startActivity(intent);
			((Activity) context).finish();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		handler =  new MyHandler(this);
		init();
		super.onCreate(savedInstanceState);
	}
	private void init() {
		SharedPreferences preferences = getSharedPreferences("start",MODE_PRIVATE);
		isFirstIn = preferences.getBoolean("isFirstIn", true);
		if(!isFirstIn){
			 handler.sendEmptyMessageDelayed(0, 2000);
		}else{
			 handler.sendEmptyMessageDelayed(1, 2000);
			 Editor editor = preferences.edit();
			 editor.putBoolean("isFirstIn", false);
			 editor.commit();
		}

	}
	
	 


}


