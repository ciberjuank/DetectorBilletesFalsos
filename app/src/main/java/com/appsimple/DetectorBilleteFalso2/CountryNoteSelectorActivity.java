package com.appsimple.DetectorBilleteFalso2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.appsimple.DetectorBilleteFalso2.adapter.CountryGridViewAdapter;
import com.appsimple.DetectorBilleteFalso2.enums.IntentParam;
import com.appsimple.DetectorBilleteFalso2.enums.SupportedCountry;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
*/
public class CountryNoteSelectorActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.country_selection);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		WindowManager.LayoutParams layout = getWindow().getAttributes();
		getWindow().setAttributes(layout);
		setupGridView();
		initializeBanner();
	}

	private void initializeBanner() {
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
	}

	private void callInfoActivity(SupportedCountry country) {
		Intent nextActivity = new Intent(CountryNoteSelectorActivity.this,
				NoteInfoActivity.class);
		nextActivity
				.putExtra(IntentParam.COUNTRY.toString(), country.ordinal());
		startActivity(nextActivity);
	}

	private void setupGridView() {

		GridView gridView = (GridView) findViewById(R.id.gridCountryView);
		gridView.setAdapter(new CountryGridViewAdapter(this));
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// Check position and call the designed callbackfunction
				SupportedCountry country = SupportedCountry.values()[position];
				callInfoActivity(country);
			}
		});
	}

}
