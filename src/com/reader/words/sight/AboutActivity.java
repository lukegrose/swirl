package com.reader.words.sight;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_layout);
	}
	
	public void handleDoneButton(View view) {
    	onBackPressed();
    }
}
