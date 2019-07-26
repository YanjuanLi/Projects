package com.example.sharelift;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.ConstDB;
import com.example.dao.ParentDao;
import com.example.entry.Parent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistParentActivity extends BaseActivity {
	private Spinner spinner,spinnerRoad;
	
	private List<String> dataList;
	
	private ArrayAdapter<String> adapter,adapterRoad;
	private EditText[] etitTexts = new EditText[9];
	private Button regist,back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_parent);
		initViews();
		initSpinner();
		initSpinnerRoad();
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RegistParentActivity.this.finish();
			}
		});
		regist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Parent parent = new Parent();
				parent.userName = etitTexts[0].getText().toString();
				parent.password = etitTexts[1].getText().toString();
				parent.childName = etitTexts[2].getText().toString();
				parent.childStudentID = etitTexts[3].getText().toString();
				parent.childClassNumber = etitTexts[4].getText().toString();
				parent.phoneNumber =etitTexts[5].getText().toString();
				parent.district = etitTexts[6].getText().toString();
				parent.driver = etitTexts[7].getText().toString();
				parent.car = etitTexts[8].getText().toString();
				parent.homeAddress=spinner.getSelectedItem().toString();
				parent.homeAddress+="&";
				parent.homeAddress+=spinnerRoad.getSelectedItem().toString();
				if(ParentDao.findSimpleData(context, parent.userName)!=null){
					Toast.makeText(context, "Already exist this user!", 1).show();
					return;
				}else if(TextUtils.isEmpty(parent.password)||TextUtils.isEmpty(parent.childName)
						||TextUtils.isEmpty(parent.childStudentID)||TextUtils.isEmpty(parent.childClassNumber)){
					Toast.makeText(context, "Please be sure to complete your message!", 1).show();
					return;
				}else if(!ConstDB.studentId.contains(parent.childStudentID )){
					showToast("The information provided is incorrect.");
					return ;
				}
				ParentDao.insert(context, parent);
				Intent intent = new Intent(context,RegistSuccessActivity.class);
				startActivity(intent);
				context.finish();
				
			}
		});
	}

	private void initViews() {
		// TODO Auto-generated method stub
		int res[] = new int[] { R.id.et1, R.id.et2, R.id.et3, R.id.et4,
				R.id.et5, R.id.et6, R.id.et7, R.id.et8, R.id.et9};
		for (int i = 0; i < res.length; i++) {
			etitTexts[i] = (EditText) findViewById(res[i]);
		}
		regist  = (Button) findViewById(R.id.regist);
		back  = (Button) findViewById(R.id.back);
	}

	private void initSpinner() {
		spinner = (Spinner) findViewById(R.id.spinner);
		// TODO Auto-generated method stub
		
		dataList = new ArrayList<String>();
		dataList.add("Haidian");
		dataList.add("Chaoyang");
		dataList.add("Fengtai");
		dataList.add("Dongcheng");
		dataList.add("Xicheng");
		dataList.add("Shijingshan");
		
		adapter = new ArrayAdapter<String>(this,
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
	private void initSpinnerRoad() {
		spinnerRoad = (Spinner) findViewById(R.id.spinner_road);
		adapterRoad = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, ConstDB.roads);
		adapterRoad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerRoad.setAdapter(adapterRoad);
		spinnerRoad.setSelection(0);
		
	}

}
