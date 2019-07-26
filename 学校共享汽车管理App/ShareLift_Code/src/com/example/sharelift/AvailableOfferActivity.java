package com.example.sharelift;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dao.OfferDao;
import com.example.dao.ParentDao;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;


public class AvailableOfferActivity extends BaseActivity {
	private ListView lv;
	private List<Offer> offers;
	private List<Parent> parents;
	Request request;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_available_offer);
		lv = (ListView) findViewById(R.id.lv);
		request = (Request) getIntent().getSerializableExtra("request");
		// showToast(request+"");
		// showToast(offers.size()+"");
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				showToast(offers.get(position) + "");
				Intent intent = new Intent(context,ConfirmOfferActivity.class);
				intent.putExtra("parent", parents.get(position));
				intent.putExtra("offer", offers.get(position));
				intent.putExtra("request", request);
				startActivity(intent);
			}
		});
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.finish();
			}
		});

	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		List<Offer> temp = OfferDao.findDataByRequest(context, request);
		offers = new ArrayList<Offer>();
		for (int i = 0; i < temp.size(); i++) {
			
			if(!temp.get(i).userName.equals(LoginActivity.loginUser.userName)){
				offers.add(temp.get(i));
			}
//			offers.add(temp.get(i));
		}
		parents = new ArrayList<Parent>();
		for (int i = 0; i < offers.size(); i++) {
			Parent parent1 = ParentDao.findSimpleData(context,
					offers.get(i).userName);
			parents.add(parent1);
		}
		lv.setAdapter(new MyofferAdapter());
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
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.request_item, null);
				holder = new ViewHolder();
				holder.text = (TextView) convertView.findViewById(R.id.tv2);
				holder.date = (TextView) convertView.findViewById(R.id.tv1);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			Parent  parent1 = parents.get(position);
			String text = parent1 .userName + ", " + parent1.driver + ","
					+ parent1.car + "," + offers.get(position).seat + " ...";
			holder.text.setText(text);
			String ad = offers.get(position).address;
			if(ad.startsWith("Home")){
				ad = "Home to "+((Parent)LoginActivity.loginUser).homeAddress.split("&")[1];
			}else{
				ad = ((Parent)LoginActivity.loginUser).homeAddress.split("&")[1]+" to Home";
			}
			holder.date.setText(offers.get(position).date + " "
					+ ad + " "
					+ offers.get(position).boraddingTime);

			return convertView;
		}

		class ViewHolder {
			TextView text;
			TextView date;
		}

	}

}
