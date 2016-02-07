package com.appsimple.detectorbilletesfalsos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class Information extends Activity {
	// Save game
	public static final String PREFS_NAME = "MyPrefsFile";
	static SharedPreferences settings;
	SharedPreferences.Editor editor;


	// hasta aca es save game

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.infoselector);


		AdRequest adRequest = new AdRequest.Builder().build();
		AdView adView = (AdView) this.findViewById(R.id.admob);
		adView.loadAd(adRequest);
		/*
		 * 
		 * si necesito poner un dialog box al principio ya esta el codigo !
		 * 
		 * 
		 * 
		 * AlertDialog.Builder alertbox = new AlertDialog.Builder(Menu.this);
		 * alertbox.setTitle(R.string.boxstarttitle); //
		 * alertbox.setIcon(R.drawable.icon); alertbox.setCancelable(false);
		 * alertbox.setMessage(R.string.boxstart);
		 * 
		 * alertbox.setPositiveButton(R.string.btnboxclose, new
		 * DialogInterface.OnClickListener() { public void
		 * onClick(DialogInterface dialog, int id) { } });
		 * 
		 * alertbox.show();
		 */

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"font/rough_typewriter.otf");

		TextView btnstart = (TextView) findViewById(R.id.btnstart);
		btnstart.setText(R.string.btnstart);
		btnstart.setTypeface(font);
		btnstart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MediaPlayer mediaPlayer = MediaPlayer.create(
						getApplicationContext(), R.raw.button);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				{

					Intent start = new Intent(Information.this, PesosArgentinos.class);

					start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(start);

				}
				;
			}
		});

		Typeface font2 = Typeface.createFromAsset(getAssets(),
				"font/rough_typewriter.otf");

		TextView btnstart2 = (TextView) findViewById(R.id.btnstart2);
		btnstart2.setText(R.string.btnstart2);
		btnstart2.setTypeface(font2);
		btnstart2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MediaPlayer mediaPlayer = MediaPlayer.create(
						getApplicationContext(), R.raw.button);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				{

					Intent start = new Intent(Information.this, WatermarkActivity.class);

					start.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(start);

				}
				;
			}
		});

		TextView btnhelp = (TextView) findViewById(R.id.btnhelp);
		btnhelp.setText(R.string.btnhelp);
		btnhelp.setTypeface(font);
		btnhelp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MediaPlayer mediaPlayer = MediaPlayer.create(
						getApplicationContext(), R.raw.button);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				AlertDialog.Builder alertbox = new AlertDialog.Builder(
						Information.this);
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
		});

		TextView btnabout = (TextView) findViewById(R.id.btnabout);
		btnabout.setText(R.string.btnabout);
		btnabout.setTypeface(font);
		btnabout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MediaPlayer mediaPlayer = MediaPlayer.create(
						getApplicationContext(), R.raw.button);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				AlertDialog.Builder alertbox = new AlertDialog.Builder(
						Information.this);
				alertbox.setTitle(R.string.boxabouttitle);
				// alertbox.setIcon(R.drawable.icon);
				alertbox.setCancelable(false);
				alertbox.setMessage(R.string.boxabout);

				alertbox.setPositiveButton(R.string.btnno,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
				alertbox.setNegativeButton(R.string.btnyes,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

							rateUs();
							   
							}
						});
				alertbox.show();
			}
		});

		Typeface font3 = Typeface.createFromAsset(getAssets(),
				"font/rough_typewriter.otf");

		TextView btnexit = (TextView) findViewById(R.id.btnExit);
		btnexit.setText(R.string.btnexit);
		btnexit.setTypeface(font3);
		btnexit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				MediaPlayer mediaPlayer = MediaPlayer.create(
						getApplicationContext(), R.raw.button);
				try {
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} catch (Exception e) {
					e.printStackTrace();
				}

				android.os.Process.killProcess(android.os.Process.myPid());
				// menu.this.finish();

			}
		});

	}

	
	public void rateUs(){
		
			AlertDialog.Builder alertbox = new AlertDialog.Builder(
					Information.this);
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