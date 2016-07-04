package com.junxu.weixin.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.junxu.weixin.R;
import com.junxu.weixin.adapter.WAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class WFragment extends Fragment implements OnItemClickListener{
	
	private ListView lView;
	private List<Map<String, Object>> listMaps;
	private WAdapter wAdapter=null;
	private String[] names = {"^","","相册","收藏","","钱包","卡卷","","表情","","设置","*"}; 
	private int[] r_ids = {0,0,R.drawable.ak_,R.drawable.akc,0,R.drawable.aka,R.drawable.akb
			,0,R.drawable.ak2,0,R.drawable.akd,0}; 
	
	private void init() {
		listMaps = new ArrayList<Map<String,Object>>();
		for(int i=0;i<names.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", names[i]);
			if(names[i].equals("")||names[i].equals("*")||names[i].equals("^")){
				map.put("type", 0);
			}else{
				map.put("type", 1);
			}
			map.put("img", r_ids[i]);
			listMaps.add(map);
		}
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "华");
		map1.put("wxh", "LGH_LinXu");
		map1.put("type", 2);
		map1.put("img", R.drawable.ak2);
		map1.put("ewm", R.drawable.a_f);
		listMaps.add(1, map1);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.wx, container,false);
		init();
		lView = (ListView) rootView.findViewById(R.id.wx_lv);
		wAdapter = new WAdapter(getActivity(), listMaps, inflater);
		lView.setAdapter(wAdapter);
		lView.setOnItemClickListener(this);
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getActivity(), "132", Toast.LENGTH_SHORT).show();
	}

}
