package com.example.fragment;

import java.util.List;

import com.example.dao.OfferDao;
import com.example.dao.ParentDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.entry.Message;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;
import com.example.sharelift.AddOfferActivity;
import com.example.sharelift.AddRequestActivity;
import com.example.sharelift.DetailActivity;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainFragment extends BaseFragment {
	TextView request, offer;
	private Button loggout, add;
	private ListView lv;
	private List<Request> requests;
	private List<Offer> offers;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_main, null);
		lv = (ListView) v.findViewById(R.id.lv);
		request = (TextView) v.findViewById(R.id.request);
		offer = (TextView) v.findViewById(R.id.offer);
		add = (Button) v.findViewById(R.id.add);
		loggout = (Button) v.findViewById(R.id.logout);
		return v;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		request.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				request.setBackgroundColor(0xFFAEAEAE);
				request.setTag(null);
				offer.setBackgroundColor(0xffffffff);
				offer.setTag(new Object());
				lv.setAdapter(new MyRequestsAdapter());
			}
		});
		offer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				offer.setBackgroundColor(0xFFAEAEAE);
				offer.setTag(null);
				request.setBackgroundColor(0xffffffff);
				request.setTag(new Object());
				lv.setAdapter(new MyofferAdapter());

			}
		});
		
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (request.getTag() == null) {
					startActivity(new Intent(getActivity(),
							AddRequestActivity.class));
				} else {
					startActivity(new Intent(getActivity(),
							AddOfferActivity.class));
				}
			}
		});
		requests = RequestDao.findAllData(getActivity(),
				LoginActivity.loginUser.userName);
		offers = OfferDao.findAllData(getActivity(),
				LoginActivity.loginUser.userName);
		if (request.getTag() == null) {
			lv.setAdapter(new MyRequestsAdapter());
		} else {
			lv.setAdapter(new MyofferAdapter());
		}
		loggout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast("Already Logout!");
				getActivity().finish();
			}
		});
	}

	
	class MyRequestsAdapter extends BaseAdapter {
		public MyRequestsAdapter() {

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return requests.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return requests.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
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
			String ad = requests.get(position).address;
			if (ad.startsWith("Home")) {
				ad = "Home to "
						+ ((Parent) LoginActivity.loginUser).homeAddress
								.split("&")[1];
			} else {
				ad = ((Parent) LoginActivity.loginUser).homeAddress.split("&")[1]
						+ " to Home";
			}
			String text = "From " + ad + ", "
					+ requests.get(position).boraddingTime + ","
					+ requests.get(position).passengers + " ...";
			holder.text.setText(text);
			holder.date.setText(requests.get(position).date);
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getActivity(),
							DetailActivity.class).putExtra("request",
							requests.get(position)));
				}
			});
			return convertView;
		}

		class ViewHolder {
			TextView text;
			TextView date;
		}

	}

	
	class MyofferAdapter extends BaseAdapter {
		public MyofferAdapter() {

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return offers.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return offers.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(
						R.layout.offer_item, null);
				holder = new ViewHolder();
				holder.text = (TextView) convertView.findViewById(R.id.tv2);
				holder.date = (TextView) convertView.findViewById(R.id.tv1);
				holder.btn = (Button) convertView.findViewById(R.id.finish);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			String ad = offers.get(position).address;
			String userName = offers.get(position).userName;
			Parent p = ParentDao.findSimpleData(getActivity(), userName);
			if (ad.startsWith("Home")) {
				ad = "Home to " + p.homeAddress.split("&")[1];
			} else {
				ad = p.homeAddress.split("&")[1] + " to Home";
			}
			String text = "From " + ad + ", "
					+ offers.get(position).boraddingTime + ","
					+ offers.get(position).seat + " ...";
			holder.text.setText(text);
			holder.date.setText(offers.get(position).date);
			if (offers.get(position).status == 1) {
				holder.btn.setVisibility(View.VISIBLE);
			} else {
				holder.btn.setVisibility(View.INVISIBLE);
			}
			holder.btn.setTag(offers.get(position));
			holder.btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Offer offer = (Offer) v.getTag();
					offer.status = 2;
					OfferDao.update(getActivity(), offer);
					showToast("Finish Offer Successed!");
					
					Message message = new Message();
					message.date = offer.date;
					message.time = System.currentTimeMillis();
					message.userName = ParentDao.findSimpleData(getActivity(),
							offer.requestId).userName;
					message.message = "The request on " + offer.date
							+ " is finished";
					SPUtil.put(getActivity().getApplicationContext(),
							message.time + "", message.to());

					
					message = new Message();
					message.date = offer.date;
					message.time = System.currentTimeMillis();
					message.userName = LoginActivity.loginUser.userName;
					message.message = "The request on " + offer.date
							+ " is finished";
					SPUtil.put(getActivity().getApplicationContext(),
							message.time + "", message.to());

					
					message = new Message();
					message.date = offer.date;
					message.time = System.currentTimeMillis();
					message.userName = "teacher";
					message.message = "The request on " + offer.date
							+ " is finished";
					SPUtil.put(getActivity().getApplicationContext(),
							message.time + "", message.to());
					v.setVisibility(View.INVISIBLE);
				}
			});
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getActivity(),
							DetailActivity.class).putExtra("offer",
							offers.get(position)));
				}
			});
			return convertView;
		}

		class ViewHolder {
			TextView text;
			TextView date;
			Button btn;
		}

	}
}
