package com.junxu.weixin.adapter;

import java.util.List;
import java.util.Map;

import com.junxu.weixin.R;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class WAdapter extends BaseAdapter{

	private List<Map<String, Object>> listMaps;
	private Context context;
	private LayoutInflater inflater;
	
	public WAdapter(Context context, List<Map<String, Object>> listMaps,
			LayoutInflater inflater) {
		this.context = context;
		this.listMaps = listMaps;
		this.inflater = inflater;
	}
	
	@Override
	public int getCount() {
		return listMaps.size();
	}

	@Override
	public Object getItem(int arg0) {
		return listMaps.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public int getItemViewType(int position) {
		int t =-1;
		Object[] m = listMaps.toArray();
		Map<String, Object> mm = (Map<String, Object>) m[position];
		 
		t =   (Integer) mm.get("type"); 
		return t;
	}

	@Override
	public int getViewTypeCount() {
		return 3;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder=null;
		ViewHolder1 viewHolder1=null;
		ViewHolder2 viewHolder2=null;
		
		int t = getItemViewType(arg0);
		
			if(arg1==null){
				switch (t) {
				case 0:
					viewHolder2 = new ViewHolder2();
					arg1 = inflater.inflate(R.layout.tx_item_two, null);
					viewHolder2.tv = (TextView) arg1.findViewById(R.id.tx_item_two);
					arg1.setTag(viewHolder2);
					break;
					
					case 1:
						viewHolder1 = new ViewHolder1();
						arg1 = inflater.inflate(R.layout.tx_item, null);
						viewHolder1.tv_  = (TextView) arg1.findViewById(R.id.tx_item);
						viewHolder1.img_ = (ImageView) arg1.findViewById(R.id.tx_img);
						arg1.setTag(viewHolder1);
						break;
						
					case 2:
						viewHolder = new ViewHolder();
						arg1 = inflater.inflate(R.layout.witem, null);
						viewHolder.tv_one = (TextView) arg1.findViewById(R.id.tv_one);
						viewHolder.tv_two = (TextView) arg1.findViewById(R.id.tv_two);
						viewHolder.img = (ImageView) arg1.findViewById(R.id.w_img);
						viewHolder.iBtn = (ImageButton) arg1.findViewById(R.id.w_ibtn);
						arg1.setTag(viewHolder);
						break;
				}
			}else{
				switch (t) {
					case 0:
						viewHolder2 = (ViewHolder2) arg1.getTag();
						break;
					case 1:
						viewHolder1 = (ViewHolder1) arg1.getTag();
						break;
					case 2:
						viewHolder = (ViewHolder) arg1.getTag();
						break;
				}
			}
			Object[] m = listMaps.toArray();
			Map<String, Object> mm = (Map<String, Object>) m[arg0];
			int img=-1;
			img = (Integer) mm.get("img");
			 Bitmap btm1 = null, btm2=null;
			 
			switch (t) {
				case 0: 
					LayoutParams lp = (LayoutParams) viewHolder2.tv.getLayoutParams();
					String s = (String)mm.get("name");
					if(s.equals("^")){
						lp.height = 60;
						viewHolder2.tv.setLayoutParams(lp);
					}else if(s.equals("*")){
						 
						lp.height = 100;
						viewHolder2.tv.setLayoutParams(lp);
					} 
					
					viewHolder2.tv.setText("");
					break;
					
				case 1:
					 viewHolder1.tv_.setText((String)mm.get("name"));
					 if(img!=-1){
						 btm1 = BitmapFactory.decodeResource(context.getResources(), img);
						 btm2 = Bitmap.createScaledBitmap(btm1, 150, 150, false);
						 viewHolder1.img_.setImageBitmap(btm2);
					 }
					break;
				case 2:
					 int  ibtn=-1;
					      ibtn = (Integer) mm.get("ewm");
						  viewHolder.tv_one.setText((String)mm.get("name"));
						  viewHolder.tv_two.setText((String)mm.get("wxh"));
						 
						 if(img!=-1){
							 btm1 = BitmapFactory.decodeResource(context.getResources(), img);
							 btm2 = Bitmap.createScaledBitmap(btm1, 150, 150, false);
							 viewHolder.img.setImageBitmap(btm2);
						 }
						 if(ibtn != -1 ){
							 btm1 = BitmapFactory.decodeResource(context.getResources(), ibtn);
							 btm2 = Bitmap.createScaledBitmap(btm1, 75, 75, false);
							 viewHolder.iBtn.setImageBitmap(btm2);
						 }
						 
					break;
	
				 
			}
		
		return arg1;
	}
	
	static class ViewHolder{
		ImageView img;
		TextView tv_one;
		TextView tv_two;
		ImageButton iBtn;
	}
	
	static class ViewHolder1{
		ImageView img_;
		TextView tv_;
	}
	static class ViewHolder2{
		TextView tv;
	}

}
