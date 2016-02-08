package com.appsimple.detectorbilletesfalsos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.appsimple.detectorbilletesfalsos.adapter.MenuGridViewAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class NewMainActivity extends Activity {
	protected PowerManager.WakeLock mWakeLock;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_mainactivity);
		AdRequest adRequest = new AdRequest.Builder().build();
		AdView adView = (AdView) this.findViewById(R.id.admob);
		adView.bringToFront();
		adView.loadAd(adRequest);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,
				"My Tag");
		this.mWakeLock.acquire();

		WindowManager.LayoutParams layout = getWindow().getAttributes();
		layout.screenBrightness = 1F;
		getWindow().setAttributes(layout);
		setupGridView();

	}

	private void callInitUv() {
		Intent start = new Intent(NewMainActivity.this, InitUVActivity.class);
		start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(start);
	}

	private void callWatermark() {
		Intent start = new Intent(NewMainActivity.this, WatermarkActivity.class);
		start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(start);
	}

	private void callNoteSpec() {
		Intent intent = new Intent(NewMainActivity.this, CountryNoteSelectorActivity.class);
		startActivity(intent);
	}

	private void callRemoveAds() {

		Intent browserIntent = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("market://details?id=com.appsimple.DetectorBilleteFalsoPaid"));

		startActivity(browserIntent);

	}

	public void rateUs() {

		AlertDialog.Builder alertbox = new AlertDialog.Builder(
				NewMainActivity.this);
		alertbox.setTitle(R.string.btnboxrate);
		// alertbox.setIcon(R.drawable.icon);
		alertbox.setCancelable(false);
		alertbox.setMessage(R.string.boxrate);

		alertbox.setPositiveButton(R.string.btnboxclose,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});
		alertbox.setNegativeButton(R.string.btnboxrate,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Intent browserIntent = new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("https://play.google.com/store/apps/details?id=com.appsimple.DetectorBilleteFalso&feature=search_result#?t=W251bGwsMSwxLDEsImNvbS5hcHBzaW1wbGUuRGV0ZWN0b3JCaWxsZXRlRmFsc28iXQ.."));
						startActivity(browserIntent);

					}

				});
		alertbox.show();
	}

	private void callShare() {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		String textToShare = getString(R.string.share_text_dialog) + " " + getString(R.string.andrioid_playstore_url);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, textToShare);
		startActivity(Intent.createChooser(intent, "Share"));
	}

	private void callHelp() {
		AlertDialog.Builder alertbox = new AlertDialog.Builder(
				NewMainActivity.this);
		alertbox.setTitle(R.string.boxhelptitle);
		// alertbox.setIcon(R.drawable.icon);
		alertbox.setCancelable(false);
		alertbox.setMessage(R.string.boxhelp);

		alertbox.setPositiveButton(R.string.btnboxclose,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		alertbox.show();
	}

	private void setupGridView() {

		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new MenuGridViewAdapter(this));
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Check position and call the designed callbackfunction

				switch (position) {
				case 0:
					callInitUv();
					break;
				case 1:
					callWatermark();
					break;
				case 2:
					callNoteSpec();
					break;
				case 3:
					callRemoveAds();
					break;
				case 4:
					callHelp();
					break;
				case 5:
					callShare();
					break;

				}
			}
		});
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
		Intent start = new Intent(NewMainActivity.this, Menu.class);

		start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(start);
	}
}
