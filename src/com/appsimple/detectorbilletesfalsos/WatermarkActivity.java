package com.appsimple.detectorbilletesfalsos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WatermarkActivity extends Activity {

	protected PowerManager.WakeLock mWakeLock;

	boolean isrunning = true;
	int red = 255, blue = 255, green = 255;

	// Initialize your handler:
	Handler handler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.secondactivity);

		AdRequest adRequest = new AdRequest.Builder().build();
		AdView adView = (AdView) this.findViewById(R.id.admob);
		adView.loadAd(adRequest);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
				"My Tag");
		this.mWakeLock.acquire();

		WindowManager.LayoutParams layout = getWindow().getAttributes();
		layout.screenBrightness = 1F;
		getWindow().setAttributes(layout);

		// Start fading:
		handler.postDelayed(color_fade, 0);

	}

	@Override
	public void onDestroy() {
		this.mWakeLock.release();
		isrunning = false;
		super.onDestroy();
	}

	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	public void onBackPressed() {
		this.mWakeLock.release();
		android.os.Process.killProcess(android.os.Process.myPid());
		Intent start = new Intent(WatermarkActivity.this, Menu.class);

		start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(start);
	}

	// Set up your runnable:
	private Runnable color_fade = new Runnable() {
		public void run() {

			red = red + 10;
			blue = blue + 20;
			green = green + 30;
			// if (green > 250) {
			//
			// red = 0;
			// blue = 0;
			// green = 0;
			// }

			LinearLayout colorchanger = (LinearLayout) findViewById(R.id.colorchange);
			colorchanger.setBackgroundColor(Color.argb(255, red, blue, green));
			handler.postDelayed(this, 10); // loop with 100 ms delay.
		}
	};

}
