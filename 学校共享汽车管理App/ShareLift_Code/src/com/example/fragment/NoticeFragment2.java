package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dao.OfferDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.entry.Message;
import com.example.entry.Offer;
import com.example.entry.Request;
import com.example.sharelift.LoginActivity;
import com.example.sharelift.R;
import com.example.sharelift.R.id;
import com.example.sharelift.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NoticeFragment2 extends BaseFragment {
	private ListView lv;
	private List<Message> messages;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_notice, null);
		lv = (ListView) v.findViewById(R.id.lv);
		return v;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Map<String, String> map = (Map<String, String>) SPUtil.getAll(getActivity().getApplicationContext());
		messages = new ArrayList<Message>();
		for (String s:map.values()) {
			Message message = new Message(s);
			if(message.userName.contains("teacher")){
				messages.add(message);
			}
		}
		lv.setAdapter(new MyNoticesAdapter());
		
	}

	
	class MyNoticesAdapter extends BaseAdapter {
		public MyNoticesAdapter() {

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return messages.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return messages.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(
						R.layout.request_item, null);
				holder = new ViewHolder();
				holder.text = (TextView) convertView.findViewById(R.id.tv2);
				holder.date = (TextView) convertView.findViewById(R.id.tv1);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.text.setText(messages.get(position).message);
			holder.date.setText(messages.get(position).date);

			return convertView;
		}

		class ViewHolder {
			TextView text;
			TextView date;
		}

	}

	
}
