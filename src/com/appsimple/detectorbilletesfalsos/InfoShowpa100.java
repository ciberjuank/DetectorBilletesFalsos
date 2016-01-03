package com.appsimple.detectorbilletesfalsos;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class InfoShowpa100 extends Activity {

	Bitmap bitmap;
	Bitmap background;
	int heightblock = 100;
	int widthblock = 100;
	int screenheight = 480;
	int screenwidth = 600;
	int bitmapnumber = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.showinfo);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		Typeface tf = Typeface.createFromAsset(getAssets(),
				"font/rough_typewriter.otf");

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenheight = metrics.heightPixels;
		screenwidth = metrics.widthPixels;

		heightblock = screenheight / 5;
		widthblock = screenwidth / 10;

		TextView title = (TextView) findViewById(R.id.title);
		title.setText(R.string.txta);

		AdRequest adRequest = new AdRequest.Builder().build();
		AdView adView = (AdView) this.findViewById(R.id.admob);
		adView.loadAd(adRequest);

		TextView btnnext = (TextView) findViewById(R.id.btnnext);
		btnnext.setTypeface(tf);
		btnnext.setText(R.string.btnnext);

		btnnext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				TextView title = (TextView) findViewById(R.id.title);
				ImageView imageshow = (ImageView) findViewById(R.id.imageshow);
				bitmapnumber = bitmapnumber + 1;
				bitmap = SelectImagesClass.selectImages(bitmap,
						heightblock * 4, widthblock * 8, getResources(),
						bitmapnumber, R.drawable.pa_100a_a,
						R.drawable.pa_100a_r, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				title.setText(SelectImagesClass.selectText(getResources(),
						bitmapnumber, R.string.txta, R.string.txtr, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0));
				imageshow.setImageBitmap(bitmap);

			}

		});

		TextView btnprevious = (TextView) findViewById(R.id.btnprevious);
		btnprevious.setTypeface(tf);
		btnprevious.setText(R.string.btnprevious);

		btnprevious.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				TextView title = (TextView) findViewById(R.id.title);
				ImageView imageshow = (ImageView) findViewById(R.id.imageshow);

				if (bitmapnumber != 0) {
					bitmapnumber = bitmapnumber - 1;
					bitmap = SelectImagesClass.selectImages(bitmap,
							heightblock * 4, widthblock * 8, getResources(),
							bitmapnumber, R.drawable.pa_100a_a,
							R.drawable.pa_100a_r, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
					title.setText(SelectImagesClass.selectText(getResources(),
							bitmapnumber, R.string.txta, R.string.txtr, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0));

					imageshow.setImageBitmap(bitmap);
				}

			}

		});

		RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.layout);

		rlayout.getLayoutParams().height = screenheight;

		background = ScaledFactor.decodeSampledBitmapFromResource(
				getResources(), R.drawable.appsimplelogo, screenheight,
				screenwidth);

		BitmapDrawable drawbackground = new BitmapDrawable(background);
		rlayout.setBackgroundDrawable(drawbackground);

		ImageView imageshow = (ImageView) findViewById(R.id.imageshow);

		imageshow.getLayoutParams().height = heightblock * 5;
		imageshow.getLayoutParams().width = screenwidth;

		bitmap = ScaledFactor.decodeSampledBitmapFromResource(getResources(),
				R.drawable.pa_100a_a, heightblock * 5, screenwidth);
		imageshow.setImageBitmap(bitmap);
		AbsolutPosition.setPosition(imageshow, 0, 0, widthblock, heightblock);

		title.setTypeface(tf);
		title.setTextSize(TypedValue.COMPLEX_UNIT_PX, heightblock * 3 / 5);

		AbsolutPosition.setPositionnocenter(title, 4, 2, widthblock,
				heightblock);

		btnnext.setTextSize(TypedValue.COMPLEX_UNIT_PX, heightblock * 3 / 5);
		AbsolutPosition.setPositionnocenterx(btnnext, 8, 4, widthblock,
				heightblock);
		btnnext.setGravity(Gravity.RIGHT);

		btnprevious
				.setTextSize(TypedValue.COMPLEX_UNIT_PX, heightblock * 3 / 5);
		AbsolutPosition.setPositionnocenterx(btnprevious, 0, 4, widthblock,
				heightblock);
		btnprevious.setGravity(Gravity.LEFT);

	}

	@Override
	protected void onResume() {

		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();

	}

	@Override
	public void onBackPressed() {

		super.onBackPressed();
	}

}
