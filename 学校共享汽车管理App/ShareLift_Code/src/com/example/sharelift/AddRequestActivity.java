package com.example.sharelift;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.ParentDao;
import com.example.entry.Parent;
import com.example.entry.Request;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class AddRequestActivity extends BaseActivity {

	private DatePicker datePicker;
	private TextView home, school;
	private Spinner spinner, spinner2;
	private Button search, back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_request);
		initViews();
		initSpinner();
		initSpinner2();
//		showToast(LoginActivity.loginUser+"");
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int year = datePicker.getYear();
				int month = datePicker.getMonth();
				month++;
				int day = datePicker.getDayOfMonth();
				Request request = new Request();
				request.userName = LoginActivity.loginUser.userName;
				request.district = ((Parent) LoginActivity.loginUser).homeAddress.split("&")[0];
				request.date = year + "-" + month + "-" + day;
				String from = home.getText().toString();
				String to = school.getText().toString();
				if(from.contains("Road")){
					from = ParentDao.getDirection(from);
				}else{
					to = ParentDao.getDirection(to);
				}
				request.address = from + " to " + to;
				request.boraddingTime = spinner.getSelectedItem().toString();
				request.passengers = Integer.parseInt(spinner2
						.getSelectedItem().toString());
				Intent intent  = new Intent(context,AvailableOfferActivity.class);
				intent.putExtra("request", request);
				startActivity(intent);
				// showToast(date+","+from+"to "+to+","+broad+","+passanger);
			}
		});

	}

	private void initViews() {
		// TODO Auto-generated method stub
		datePicker = (DatePicker) findViewById(R.id.datePicker1);
		home = (TextView) findViewById(R.id.home);
		school = (TextView) findViewById(R.id.school);
		search = (Button) findViewById(R.id.search);
		back = (Button) findViewById(R.id.back);
		findViewById(R.id.change).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s = (String) home.getText();
				home.setText(school.getText().toString());
				school.setText(s);
			}
		});
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.finish();
			}
		});
		String s = ((Parent) LoginActivity.loginUser).homeAddress.split("&")[1];
		home.setText(s);
	}

	private void initSpinner() {
		spinner = (Spinner) findViewById(R.id.spinner);
		// TODO Auto-generated method stub
		
		ArrayList<String> dataList = new ArrayList<String>();
		dataList.add("7:00-7:15");
		dataList.add("7:15-7:30");
		dataList.add("7:30-7:45");
		dataList.add("7:45-8:00");
		dataList.add("12:00-12:15");
		dataList.add("12:15-12:30");
		dataList.add("12:30-12:45");
		dataList.add("12:45-13:00");
		dataList.add("16:30-16:45");
		dataList.add("17:45-17:00");
		dataList.add("17:00-17:15");
		dataList.add("17:15-17:30");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataList);

		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

	private void initSpinner2() {
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		// TODO Auto-generated method stub
		
		ArrayList<String> dataList = new ArrayList<String>();
		for (int i = 1; i < 10; i++) {
			dataList.add(i + "");
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataList);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner2.setAdapter(adapter);
		spinner2.setSelection(0);
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}
}