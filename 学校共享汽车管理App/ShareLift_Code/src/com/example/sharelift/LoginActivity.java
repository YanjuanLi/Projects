package com.example.sharelift;

import com.example.dao.ParentDao;
import com.example.dao.TeacherDao;
import com.example.entry.Parent;
import com.example.entry.Teacher;
import com.example.entry.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	public static User loginUser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final CheckBox checkBox1 = (CheckBox) findViewById(R.id.rb_1);
		final CheckBox checkBox2 = (CheckBox) findViewById(R.id.rb_2);
		Button regsit = (Button) findViewById(R.id.regist);
		Button login = (Button) findViewById(R.id.login);
		regsit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, SelectActivity.class);
				startActivity(intent);
			}
		});
		checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				checkBox2.setChecked(!isChecked);

			}
		});
		checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				checkBox1.setChecked(!isChecked);

			}
		});
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText et1 = (EditText) findViewById(R.id.et1);
				EditText et2 = (EditText) findViewById(R.id.et2);
				if (checkBox1.isChecked()) {
					Parent parent = ParentDao.findSimpleData(context, et1
							.getText().toString());
					if (parent != null
							&& et2.getText().toString().equals(parent.password)) {
						showToast("Login Success !");
						loginUser = parent;
						startActivity(new Intent(context,MainActivity.class));
					} else {
						showToast("Login Faild !");
					}

				} else {
					Teacher teacher = TeacherDao.findSimpleData(context, et1
							.getText().toString());
					if (teacher != null
							&& et2.getText().toString()
									.equals(teacher.password)) {
						showToast("Login Success !");
						loginUser = teacher;
						startActivity(new Intent(context,MainActivity.class));
					} else {
						showToast("Login Faild !");
					}
				}
			}
		});
	}

}
