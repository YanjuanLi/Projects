package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class BaseFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	protected void showToast(String s) {
		
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), s, 0).show();
	}
}
