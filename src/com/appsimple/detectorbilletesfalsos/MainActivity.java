package com.appsimple.detectorbilletesfalsos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity {

	protected PowerManager.WakeLock mWakeLock;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainactivity);

		
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

	}

	@Override
	public void onDestroy() {
		this.mWakeLock.release();
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
		Intent start = new Intent(MainActivity.this, Menu.class);

		start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(start);
	}

}
