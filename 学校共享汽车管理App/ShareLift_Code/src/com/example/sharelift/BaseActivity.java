package com.example.sharelift;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {
	protected BaseActivity context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		context = this;
	}

	protected void showToast(String s) {
		// TODO Auto-generated method stub
		Toast.makeText(context, s, 0).show();
	}
}
