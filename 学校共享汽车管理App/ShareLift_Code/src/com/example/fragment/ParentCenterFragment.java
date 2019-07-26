package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dao.ConstDB;
import com.example.dao.OfferDao;
import com.example.dao.ParentDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.entry.Message;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;
import com.example.sharelift.LoginActivity;
import com.example.sharelift.R;
import com.example.sharelift.R.id;
import com.example.sharelift.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ParentCenterFragment extends BaseFragment {
	private EditText[] etitTexts = new EditText[9];
	private Spinner spinner;
	private Button change;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_parent_center, null);
		initViews(v);
		initSpinner(v);
		initData();
		v.findViewById(R.id.change).setOnClickListener(new OnClickListener() {
			
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
				 if(TextUtils.isEmpty(parent.password)||TextUtils.isEmpty(parent.childName)||TextUtils.isEmpty(parent.childStudentID)||TextUtils.isEmpty(parent.childClassNumber)){
					Toast.makeText(getActivity(), "Please be sure to complete your message!", 1).show();
					return;
				}
				 ParentDao.update(getActivity(), parent);
				 LoginActivity.loginUser = parent;
				 showToast("Change Information Successed!");
			}
		});
		return v;
	}

	private void initData() {
		// TODO Auto-generated method stub
		Parent parent = (Parent) LoginActivity.loginUser;
		etitTexts[0].setText(parent.userName);
		etitTexts[1].setText(parent.password);
		etitTexts[2].setText(parent.childName);
		etitTexts[3].setText(parent.childStudentID);
		etitTexts[4].setText(parent.childClassNumber);
		etitTexts[5].setText(parent.phoneNumber);
		etitTexts[6].setText(parent.district);
		etitTexts[7].setText(parent.driver);
		etitTexts[8].setText(parent.car);
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		int res[] = new int[] { R.id.et1, R.id.et2, R.id.et3, R.id.et4,
				R.id.et5, R.id.et6, R.id.et7, R.id.et8, R.id.et9 };
		for (int i = 0; i < res.length; i++) {
			etitTexts[i] = (EditText) root.findViewById(res[i]);
		}
	}

	private void initSpinner(View root) {
		spinner = (Spinner) root.findViewById(R.id.spinner);
		// TODO Auto-generated method stub
		
		List<String> dataList = new ArrayList<String>();
		dataList.add("Haidian");
		dataList.add("Chaoyang");
		dataList.add("Fengtai");
		dataList.add("Dongcheng");
		dataList.add("Xicheng");
		dataList.add("Shijingshan");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, dataList);

		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		
		spinner.setAdapter(adapter);
		spinner.setSelection(dataList.indexOf(((Parent)LoginActivity.loginUser).homeAddress));
		
	}

}
