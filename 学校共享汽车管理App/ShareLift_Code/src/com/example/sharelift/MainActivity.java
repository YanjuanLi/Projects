package com.example.sharelift;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.example.entry.Parent;
import com.example.fragment.BaseFragment;
import com.example.fragment.MainFragment;
import com.example.fragment.MainFragment2;
import com.example.fragment.NoticeFragment;
import com.example.fragment.NoticeFragment2;
import com.example.fragment.ParentCenterFragment;
import com.example.fragment.TeacherCenterFragment;

/**
 * Main page
 * 
 */
public class MainActivity extends FragmentActivity {

	private Context context;
	private LinearLayout ll_bottom;

	BaseFragment fragments[];
	String[] fragmentsTag;
	private int lastShowFragment = 0;
	MyViewPager pager;
	List<BaseFragment> fragmentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
		initBottom();
		initFragment();
		pager = (MyViewPager) findViewById(R.id.pager);
		pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),
				fragmentList));
		pager.setOffscreenPageLimit(0);
		pager.setDuration(0);
		pager.setCanScroll(false);// 设置为不可左右切页

	}

	private void initFragment() {
		fragmentList = new ArrayList<BaseFragment>();
		if (LoginActivity.loginUser instanceof Parent) {
			BaseFragment fragment = new MainFragment();
			BaseFragment fragment2 = new NoticeFragment();
			BaseFragment fragment3 = new ParentCenterFragment();
			fragmentList.add(fragment);
			fragmentList.add(fragment2);
			fragmentList.add(fragment3);
		}else{
			BaseFragment fragment = new MainFragment2();
			BaseFragment fragment2 = new NoticeFragment2();
			BaseFragment fragment3 = new TeacherCenterFragment();
			fragmentList.add(fragment);
			fragmentList.add(fragment2);
			fragmentList.add(fragment3);
		}
	}

	void initBottom() {
		ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
		for (int i = 0; i < ll_bottom.getChildCount(); i++) {
			final int index = i;
			ll_bottom.getChildAt(i).setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					pager.setCurrentItem(index);
					for (int i = 0; i < ll_bottom.getChildCount(); i++) {
						ll_bottom.getChildAt(i).setSelected(false);
					}
					v.setSelected(true);
				}
			});
		}
		ll_bottom.getChildAt(0).setSelected(true);
	}
}
