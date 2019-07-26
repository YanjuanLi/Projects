package com.example.fragment;

import java.util.ArrayList;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Main page of teacher
 *
 */
public class MainFragment2 extends BaseFragment {
	private Button loggout, add;
	private ListView lv;
	private List<Offer> offers;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_main2, null);
		lv = (ListView) v.findViewById(R.id.lv);
		add = (Button) v.findViewById(R.id.add);
		loggout = (Button) v.findViewById(R.id.logout);
		return v;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
   
		offers = new ArrayList<Offer>();
   List<Offer> list = OfferDao.findAllData(getActivity());
  for(int i=0; i<list.size();i++){
   if(list.get(i).requestId>0){
      offers.add(list.get(i));

}

}
		lv.setAdapter(new MyofferAdapter());
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(),
						DetailActivity.class).putExtra("offer",
								offers.get(position)));
			}
		});
		loggout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast("Already Logout!");
				getActivity().finish();
			}
		});
	}

	

	/**
	 * 
	 */
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
			String ad =  offers.get(position).address;
			String userName = offers.get(position).userName;
			Parent p = ParentDao.findSimpleData(getActivity(), userName);
			if(ad.startsWith("Home")){
				ad = "Home to "+p.homeAddress.split("&")[1];
			}else{
				ad = p.homeAddress.split("&")[1]+" to Home";
			}
			String text = "From " + ad + ", "
					+ offers.get(position).boraddingTime + ","
					+ offers.get(position).seat + " ...";
			holder.text.setText(text);
			holder.date.setText(offers.get(position).date);
			return convertView;
		}

		class ViewHolder {
			TextView text;
			TextView date;
			Button btn;
		}

	}
}
