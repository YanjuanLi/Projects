package com.example.sharelift;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.dao.OfferDao;
import com.example.dao.ParentDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;

/**
 * Driver:XXX Car:XXX Date:XXX Boarding time:XXX
 * 
 * Driver Phone:XXX Driver Address: XXX
 * 
 * Passenger Name:XXX Passenger Phone:XXX Passenger Address:XXX
 */
public class DetailActivity extends BaseActivity {

	Request request;
	Parent parent;
	Offer offer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		int res[] = new int[] { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4,
				R.id.tv5,R.id.tv6 ,R.id.tv7,R.id.tv8 ,R.id.tv9  };
		TextView[] textViews = new TextView[res.length];
		for (int i = 0; i < res.length; i++) {
			textViews[i] = (TextView) findViewById(res[i]);
		}
		offer = (Offer) getIntent().getSerializableExtra("offer");
		request = (Request) getIntent().getSerializableExtra("request");
		if(request!=null){
			for (int i = 6; i < textViews.length; i++) {
				textViews[i].setVisibility(View.VISIBLE);
			}
			offer = OfferDao.findSimpleData(this, request.offerId);
			Parent offerParent = ParentDao.findSimpleData(this, offer.userName);
			Parent requestParent = ParentDao.findSimpleData(this, request.userName);
			textViews[0].setText("Driver: "+offerParent.userName);
			textViews[1].setText("Car: "+offerParent.car);
			textViews[2].setText("Date: "+offer.date);
			textViews[3].setText("Boarding time: "+offer.boraddingTime);
			textViews[4].setText("Driver Phone: "+offerParent.phoneNumber);
			String str[] = offerParent.homeAddress.split("&");
			textViews[5].append("Driver Address: "+str[0]+" "+str[1]);
			textViews[6].append("Passenger Name: "+requestParent.childName);
			textViews[7].append("Passenger Phone: "+requestParent.phoneNumber);
			str = requestParent.homeAddress.split("&");
			textViews[8].append("Passenger Address: "+str[0]+" "+str[1]);
		}else if(offer!=null){
			request = RequestDao.findSimpleData(this, offer.requestId);
			Parent offerParent = ParentDao.findSimpleData(this, offer.userName);
			textViews[0].setText("Driver: "+offerParent.userName);
			textViews[1].setText("Car: "+offerParent.car);
			textViews[2].setText("Date: "+offer.date);
			textViews[3].setText("Boarding time: "+offer.boraddingTime);
			textViews[4].setText("Driver Phone: "+offerParent.phoneNumber);
			String str[] = offerParent.homeAddress.split("&");
			textViews[5].append("Driver Address: "+str[0]+" "+str[1]);
			if(request!=null){
				for (int i = 6; i < textViews.length; i++) {
					textViews[i].setVisibility(View.VISIBLE);
				}
				Parent requestParent = ParentDao.findSimpleData(this, request.userName);
				textViews[6].append("Passenger Name: "+requestParent.childName);
				textViews[7].append("Passenger Phone: "+requestParent.phoneNumber);
				str = requestParent.homeAddress.split("&");
				textViews[8].append("Passenger Address"+str[0]+" "+str[1]);
			}
			
		}
		
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
