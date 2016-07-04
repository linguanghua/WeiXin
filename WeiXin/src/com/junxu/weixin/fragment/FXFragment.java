package com.junxu.weixin.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.junxu.weixin.R;
import com.junxu.weixin.adapter.XAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FXFragment extends Fragment implements OnItemClickListener{
	private ListView iView;
	private XAdapter fxAdapter;
 
	private List<Map<String, Object>> listMaps;
	private String[] names = {"","朋友圈","","扫一扫","摇一摇","","附近的人","漂流瓶","","购物","游戏"}; 
	private int[] r_ids = {0,R.drawable.afe,0,R.drawable.afg,
			R.drawable.afh,0,R.drawable.afd,R.drawable.afb,0,R.drawable.axw,R.drawable.ak6}; 
	
	private void init() {
		listMaps = new ArrayList<Map<String,Object>>();
	 
		for(int k=0;k<names.length;k++){
			if(names[k].equals("")){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", "");
				map.put("type", 0);
				listMaps.add(map);
			}else{
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("name", names[k]);
				map1.put("type", 1);
				map1.put("img", r_ids[k]);
				listMaps.add(k,map1);
			}
		}
			 
			 
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		init();
		View rootView = inflater.inflate(R.layout.wx, container,false);
		iView = (ListView) rootView.findViewById(R.id.wx_lv);
		fxAdapter = new XAdapter(getActivity(),inflater,listMaps);
		
		iView.setAdapter(fxAdapter);
		iView.setOnItemClickListener(this);
		return rootView;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getActivity(), "132", Toast.LENGTH_SHORT).show();
		
	}

	
}
