package com.appsimple.detectorbilletesfalsos;

import java.util.ArrayList;
import java.util.List;

import com.appsimple.detectorbilletesfalsos.beans.CurrencyInfo;
import com.appsimple.detectorbilletesfalsos.enums.CurrencyInfoKey;
import com.appsimple.detectorbilletesfalsos.utils.JSONUtils;

import android.app.Activity;

public class NotesSecurityActivity extends Activity{
	
	private List<CurrencyInfo> updateCurrencyLocale (List<CurrencyInfo> currencies){
		List<CurrencyInfo> updatedCurrencyList = new ArrayList<CurrencyInfo>();
		for(CurrencyInfo item: currencies){
			CurrencyInfo updatedItem = new CurrencyInfo();
			updatedItem.setCountry(item.getCountry());
			updatedItem.setCurrency(item.getCurrency());
			updatedItem.setDenomination(item.getDenomination());
			//Verify locale
			if (CurrencyInfoKey.REAL_50_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_50_description)); 
				updatedItem.setWatermark(getString(R.string.real_50_watermark)); break;
			}
			else if(CurrencyInfoKey.REAL_100_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_100_description)); 
				updatedItem.setWatermark(getString(R.string.real_100_watermark)); break;
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
