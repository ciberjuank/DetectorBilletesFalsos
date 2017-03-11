package com.appsimple.DetectorBilleteFalso2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Thread splashThread = new Thread() {
			@Override
			public void run() {

				try {
					int waited = 0;
					while (waited < 1000) {
						sleep(100);
						waited += 100;
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					finish();
					Intent mainIntent = new Intent().setClass(Splash.this,
							NewMainActivity.class);
					startActivity(mainIntent);

				}
			}
		};
		splashThread.start();

	}

}
