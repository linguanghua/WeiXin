package com.junxu.weixin.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.junxu.weixin.R;

import android.R.integer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class WXFragment extends Fragment{
	private ListView lv;
	private List<String> datas;
	private SimpleAdapter adapter;
	private List<Map<String,Object>> mData;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.wx, container,false);
		datas = new ArrayList<String>();
		for(int i=0;i<100;i++){
			datas.add("标题"+i);
		}
		 
		lv = (ListView) rootView.findViewById(R.id.wx_lv);
		
	    mData = new ArrayList<Map<String,Object>>();
	    for(int i=0;i<datas.size();i++){
	    	Map<String, Object> map = new HashMap<String,Object>();
	    	map.put("icon", R.drawable.a_c);
	    	map.put("title", datas.get(i));
	    	map.put("content", datas.get(i));
	    	mData.add(map);
	    }
		adapter = new SimpleAdapter(getActivity(), mData, R.layout.wxitem,
				new String[]{"icon","title","content"}, new int[]{R.id.img,R.id.title,R.id.content});
		lv.setAdapter(adapter);
		return rootView;
	}

}
