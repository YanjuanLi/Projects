package com.example.sharelift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class SelectActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		findViewById(R.id.parent).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,RegistParentActivity.class);
				startActivity(intent);
				context.finish();
			}
		});
		findViewById(R.id.teacher).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,RegistTeacherActivity.class);
				startActivity(intent);
				context.finish();
			}
		});
	}

	
}
