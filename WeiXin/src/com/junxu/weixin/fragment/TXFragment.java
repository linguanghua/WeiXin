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

public class TXFragment extends Fragment implements OnItemClickListener{
	
	private ListView iView;
	private XAdapter txAdapter;
	private String[] string = { "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z" }; 
	private List<Map<String, Object>> listMaps;
	private String[] names = {"新的朋友","群聊","标签","公众号"}; 
	private int[] r_ids = {R.drawable.a_b,R.drawable.a_j,R.drawable.a_b,R.drawable.a_h}; 
	
	
	private void init() {
	listMaps = new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<names.length;i++){
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("name", names[i]);
			map1.put("type", 1);
			map1.put("img", r_ids[i]);
		
			listMaps.add(map1);
		}
 
		int total=4;
		for(int k=0;k<string.length;k++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", string[k]);
			map.put("type", 0);
			
			listMaps.add(map);
			total++;
			for(int i=0;i<5;i++){
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("name", "联系人"+i);
				map1.put("type", 1);
				map1.put("img", R.drawable.a_c);
				
				listMaps.add(total,map1);
				total++;
			}
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		init();
		View rootView = inflater.inflate(R.layout.wx, container,false);
		iView = (ListView) rootView.findViewById(R.id.wx_lv);
		txAdapter = new XAdapter(getActivity(),inflater,listMaps);
		
		iView.setAdapter(txAdapter);
		iView.setOnItemClickListener(this);
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Toast.makeText(getActivity(), "132", Toast.LENGTH_SHORT).show();
	}

}
