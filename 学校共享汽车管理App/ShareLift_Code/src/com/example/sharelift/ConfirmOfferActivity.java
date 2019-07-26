package com.example.sharelift;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.dao.OfferDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;


public class ConfirmOfferActivity extends BaseActivity {

	Request request;
	Parent parent;
	Offer offer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_offer);
		int res[] = new int[] { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4,
				R.id.tv5,R.id.tv6 ,R.id.tv7 };
		TextView[] textViews = new TextView[7];
		for (int i = 0; i < textViews.length; i++) {
			textViews[i] = (TextView) findViewById(res[i]);
		}
		offer = (Offer) getIntent().getSerializableExtra("offer");
		parent = (Parent) getIntent().getSerializableExtra("parent");
		request = (Request) getIntent().getSerializableExtra("request");
		textViews[0].append(parent.userName);
		textViews[1].append(parent.car);
		textViews[2].append(offer.seat + "");
		textViews[3].append(offer.date);
		textViews[4].append(offer.boraddingTime);
		textViews[5].append(parent.phoneNumber);
		String str[] = parent.homeAddress.split("&");
		textViews[6].append(str[0]+" "+str[1]);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.finish();
			}
		});
		findViewById(R.id.request).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				request.offerId = parent.id;
				request.status = 1;
				offer.status = 1;
				offer.requestId = LoginActivity.loginUser.id;
				RequestDao.insert(context, request);
				OfferDao.update(context, offer);
				showToast("Request Successed!");
				context.finish();
				com.example.entry.Message message = new com.example.entry.Message();
				message.date = offer.date;
				message.userName = offer.userName;
				message.message = LoginActivity.loginUser.userName
						+ " has requested for your offer";
				message.time = System.currentTimeMillis();
				SPUtil.put(getApplicationContext(), message.time + "",
						message.to());
				long time = Utils.dateToStamp(offer.date);
				
				if (time - System.currentTimeMillis() < 24 * 60 * 60 * 1000) {
					
					message = new com.example.entry.Message();
					message.date = Utils.stampToDate(System.currentTimeMillis());
					message.time = System.currentTimeMillis();
					message.userName = LoginActivity.loginUser.userName;
					message.message = "Your request on " + offer.date
							+ " will take place";
					SPUtil.put(context.getApplicationContext(), message.time
							+ "", message.to());
					
					
					message = new com.example.entry.Message();
					message.date = Utils.stampToDate(System.currentTimeMillis());
					message.time = System.currentTimeMillis();
					message.userName = offer.userName;
					message.message = "Your offer on " + offer.date
							+ " will take place";
					SPUtil.put(context.getApplicationContext(), message.time
							+ "", message.to());
				}
			}
		});
	}

}
