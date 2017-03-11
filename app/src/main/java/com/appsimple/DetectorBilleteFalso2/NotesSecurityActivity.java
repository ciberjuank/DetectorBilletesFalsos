package com.appsimple.DetectorBilleteFalso2;

import java.util.ArrayList;
import java.util.List;

import com.appsimple.DetectorBilleteFalso2.beans.CurrencyInfo;
import com.appsimple.DetectorBilleteFalso2.enums.CurrencyInfoKey;
import com.appsimple.DetectorBilleteFalso2.utils.JSONUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;

public class NotesSecurityActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeBanner();
	}

	private void initializeBanner() {
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
	}

	private List<CurrencyInfo> updateCurrencyLocale (List<CurrencyInfo> currencies){
		List<CurrencyInfo> updatedCurrencyList = new ArrayList<CurrencyInfo>();
		for(CurrencyInfo item: currencies){
			CurrencyInfo updatedItem = new CurrencyInfo();
			updatedItem.setCountry(item.getCountry());
			updatedItem.setCurrency(item.getCurrency());
			updatedItem.setDenomination(item.getDenomination());
			//Verify description & set locale
			if (CurrencyInfoKey.REAL_50_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_50_description)); 
				updatedItem.setWatermark(getString(R.string.real_50_watermark)); 
			}
			else if(CurrencyInfoKey.REAL_100_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_100_description)); 
				updatedItem.setWatermark(getString(R.string.real_100_watermark)); 
			}
			
			else if (CurrencyInfoKey.PESO_COL_10K_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_col_10K_description)); 
				updatedItem.setWatermark(getString(R.string.peso_col_10K_watermark)); 
			}
			else if (CurrencyInfoKey.PESO_COL_50k_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_col_50K_description)); 
				updatedItem.setWatermark(getString(R.string.peso_col_50K_watermark)); break;
			}

		}		
		
		return updatedCurrencyList;
	}
	
	private List<CurrencyInfo> getCurrencyInfo(){
		JSONUtils jsonUtils = JSONUtils.getInstance();
		List<CurrencyInfo> currencies = jsonUtils.parseJson(this, "currencyInfo.json");
		return updateCurrencyLocale (currencies);
	}

}
