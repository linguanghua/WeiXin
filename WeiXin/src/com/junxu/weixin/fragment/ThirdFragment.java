package com.junxu.weixin.fragment;

import com.junxu.weixin.MainActivity;
import com.junxu.weixin.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment{
	private Button button;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.three, container,false);
		button = (Button) rootView.findViewById(R.id.start_btn);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(),MainActivity.class));
				getActivity().finish();
			}
		});
		return rootView;
	}

}
