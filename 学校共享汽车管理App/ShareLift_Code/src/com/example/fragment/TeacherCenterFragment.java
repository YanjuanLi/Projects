package com.example.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.dao.ConstDB;
import com.example.dao.OfferDao;
import com.example.dao.ParentDao;
import com.example.dao.RequestDao;
import com.example.dao.SPUtil;
import com.example.dao.TeacherDao;
import com.example.entry.Message;
import com.example.entry.Offer;
import com.example.entry.Parent;
import com.example.entry.Request;
import com.example.entry.Teacher;
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

public class TeacherCenterFragment extends BaseFragment {
	private EditText[] etitTexts = new EditText[4];
	private Spinner spinner;
	private Button change;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_teacher_center, null);
		initViews(v);
		initData();
		v.findViewById(R.id.change).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Teacher teacher = new Teacher();
				teacher.userName = etitTexts[0].getText().toString();
				teacher.password = etitTexts[1].getText().toString();
				teacher.employeeID = etitTexts[2].getText().toString();
				teacher.phoneNumber = etitTexts[3].getText().toString();
				if (TextUtils.isEmpty(teacher.password)
						|| TextUtils.isEmpty(teacher.employeeID)) {
					Toast.makeText(getActivity(),
							"Please be sure to complete your message!", 1)
							.show();
					return;
				}
				 TeacherDao.update(getActivity(), teacher);
				 LoginActivity.loginUser = teacher;
				 showToast("Change Information Successed!");
			}
		});
		return v;
	}

	private void initData() {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) LoginActivity.loginUser;
		etitTexts[0].setText(teacher.userName);
		etitTexts[1].setText(teacher.password);
		etitTexts[2].setText(teacher.employeeID);
		etitTexts[3].setText(teacher.phoneNumber);
	}

	private void initViews(View root) {
		// TODO Auto-generated method stub
		int res[] = new int[] { R.id.et1, R.id.et2, R.id.et3, R.id.et4 };
		for (int i = 0; i < res.length; i++) {
			etitTexts[i] = (EditText) root.findViewById(res[i]);
		}
	}

	

}
