package com.example.sharelift;

import com.example.dao.ConstDB;
import com.example.dao.ParentDao;
import com.example.dao.TeacherDao;
import com.example.entry.Teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistTeacherActivity extends BaseActivity {
	private EditText[] etitTexts = new EditText[4];
	private Button regist, back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_teacher);
		initViews();
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.finish();
			}
		});
		regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Teacher teacher = new Teacher();
				teacher.userName = etitTexts[0].getText().toString();
				teacher.password = etitTexts[1].getText().toString();
				teacher.employeeID = etitTexts[2].getText().toString();
				teacher.phoneNumber = etitTexts[3].getText().toString();
				if (TeacherDao.findSimpleData(context, teacher.userName) != null) {
					Toast.makeText(context, "Already exist this user!", 1)
							.show();
					return;
				} else if (TextUtils.isEmpty(teacher.password)
						|| TextUtils.isEmpty(teacher.employeeID)) {
					Toast.makeText(context,
							"Please be sure to complete your message!", 1)
							.show();
					return;
				} else if (!ConstDB.employeeId.contains(teacher.employeeID)) {
					showToast("The information provided is incorrect.");
					return;
				}
				TeacherDao.insert(context, teacher);
				Intent intent = new Intent(context, RegistSuccessActivity.class);
				startActivity(intent);
				context.finish();

			}
		});
	}

	private void initViews() {
		// TODO Auto-generated method stub
		int res[] = new int[] { R.id.et1, R.id.et2, R.id.et3, R.id.et4 };
		for (int i = 0; i < res.length; i++) {
			etitTexts[i] = (EditText) findViewById(res[i]);
		}
		regist = (Button) findViewById(R.id.regist);
		back = (Button) findViewById(R.id.back);
	}

}
