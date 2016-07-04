package com.junxu.weixin.adapter;

import java.util.List;
import java.util.Map;

import com.junxu.weixin.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class XAdapter extends BaseAdapter{
	 
	private List<Map<String, Object>> listMaps;
	private LayoutInflater inflater;
	private Context context;
	
	public XAdapter( Context context,LayoutInflater inflater, List<Map<String, Object>> listMaps) {
		this.inflater = inflater;
		this.context = context;
		this.listMaps = listMaps;
	}
	@Override
	public int getCount() {
		return listMaps.size();
	}

	@Override
	public int getViewTypeCount() {
		return 2;
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
	public Object getItem(int arg0) {
		return listMaps.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder=null;
		ViewHolder1 viewHolder1=null;
		int t =getItemViewType(arg0);
		 
		 
		if(arg1==null){
			 
			switch (t) {
				case 0:
					viewHolder = new ViewHolder();
					arg1 = inflater.inflate(R.layout.tx_item_two, null);
					viewHolder.tv_two = (TextView) arg1.findViewById(R.id.tx_item_two);
					arg1.setTag(viewHolder);
					break;
	
				case 1:
					viewHolder1 = new ViewHolder1();
					arg1 = inflater.inflate(R.layout.tx_item, null);
					viewHolder1.tv = (TextView) arg1.findViewById(R.id.tx_item);
					viewHolder1.img = (ImageView) arg1.findViewById(R.id.tx_img);
					arg1.setTag(viewHolder1);
					break;
			}
			 
			 
		}
		else {
			switch (t) {
				case 0:
					viewHolder = (ViewHolder) arg1.getTag();
					break;
	
				case 1:
					viewHolder1 = (ViewHolder1) arg1.getTag();
					break;
			}
		} 
		Object[] m = listMaps.toArray();
		Map<String, Object> mm = (Map<String, Object>) m[arg0];
		switch (t) {
			case 0:
				viewHolder.tv_two.setText((String) mm.get("name") );
				break;
	
			case 1:
				 
				int a = -1;
				a = (Integer) mm.get("img");
				viewHolder1.tv.setText((String) mm.get("name"));
				Bitmap btm1 = BitmapFactory.decodeResource(context.getResources(),a);
				Bitmap btm2 = Bitmap.createScaledBitmap(btm1, 105, 105, false);
				viewHolder1.img.setImageBitmap(btm2);
				break;
		}
		return arg1;
	}
	
	static class ViewHolder{
		TextView tv_two;
	}
	static class ViewHolder1{
		TextView tv;
		ImageView img;
	}
 
}
