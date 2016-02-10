package com.appsimple.detectorbilletesfalsos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.detectorbilletesfalsos.beans.CurrencyInfo;
import com.appsimple.detectorbilletesfalsos.enums.CurrencyInfoKey;
import com.appsimple.detectorbilletesfalsos.enums.IntentParam;
import com.appsimple.detectorbilletesfalsos.enums.SupportedCountry;
import com.appsimple.detectorbilletesfalsos.utils.JSONUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class NoteInfoActivity extends Activity {
	
	private Context ctx;
	
	private String getNoteId(String country, String denomination){		
		String noteId ;
		String updatedDenomination = denomination;
		if (denomination.equals(getString(R.string.denomination_generic))){
			updatedDenomination = "all";
		}
		noteId = country.toLowerCase(ctx.getResources().getConfiguration().locale) + "_" + "note_" + updatedDenomination;
		return noteId;
	}
   
	private CardView createHeaderSingleCard(String mCurrency, String country) {
		  	
			String currency = getText(R.string.Currency) +": " + mCurrency;
	        CardView card = new CardView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardViewStyle), null, 0);
	        
	        LinearLayout leftInner = new LinearLayout(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardContent), null, 0);
	        leftInner.setOrientation(LinearLayout.VERTICAL);
	        
	        TextView countryDescription = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));
	        countryDescription.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
	        ));

	        countryDescription.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
	        countryDescription.setText(getText (R.string.country) + ": " + country);

	        TextView currencyTextView = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));

	        currencyTextView.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
	        ));
	        currencyTextView.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
	        currencyTextView.setText(currency);
	        	        
	        leftInner.addView(countryDescription);
	        
	        leftInner.addView(currencyTextView);
	        
	        
	        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT,
	                LinearLayout.LayoutParams.WRAP_CONTENT
	        );
	        card.setLayoutParams(lParams);
	        card.addView(leftInner);
	        
	        return card;

	    }
	  

	
    private CardView createSingleCard(String description1, String description2, String country, String denomination) {

    	String header = getString(R.string.Denomination) + ":" + denomination;
        CardView card = new CardView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardViewStyle), null, 0);

        LinearLayout cardInner = new LinearLayout(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardContent), null, 0);

        TextView txtTitle = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));
        txtTitle.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        txtTitle.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));

        txtTitle.setText(header);

        TextView noteSecurityDescription = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));

        noteSecurityDescription.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        noteSecurityDescription.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
        noteSecurityDescription.setText(getString (R.string.securityMeasures) + ": " + description1);

        TextView watermarkDescription = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));

        watermarkDescription.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        ));
        watermarkDescription.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
        watermarkDescription.setText(getString (R.string.watermark) + ": " + description2);

        
        cardInner.addView(txtTitle);
        ImageView noteImg = new ImageView(ctx);
        
        String noteName = getNoteId (country, denomination);
        Integer noteImageResourceId = getResources().getIdentifier(noteName, "drawable", getPackageName());
        
        noteImg.setImageResource(noteImageResourceId );
        cardInner.addView(noteImg);
        cardInner.addView(noteSecurityDescription);
        cardInner.addView(watermarkDescription);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        card.setLayoutParams(lParams);

        card.addView(cardInner);

        return card;

    }

    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.note_info_activity);
		ctx = getApplicationContext();
		Intent currentIntent = getIntent();
		int country = currentIntent.getIntExtra(IntentParam.COUNTRY.toString(), 0);
		List<CurrencyInfo> notes = loadNoteInfo(country);
		
		AdRequest adRequest = new AdRequest.Builder().build();
		AdView adView = (AdView) this.findViewById(R.id.admob);
		adView.bringToFront();
		adView.loadAd(adRequest);

		
		setupMainContent(notes, country);
	}
	
	public List<CurrencyInfo> loadNoteInfo (int country){
		JSONUtils utils = JSONUtils.getInstance();
		List<CurrencyInfo> currencies = utils.parseJson(ctx, "currencyinfo.json");
		List<CurrencyInfo>  localeCurrencies = updateCurrencyLocale (currencies);
		SupportedCountry supportedCountry = SupportedCountry.values()[country];
		return filterCurrencies(localeCurrencies, supportedCountry);
	}
	
	private List<CurrencyInfo> filterCurrencies(List<CurrencyInfo>currencies, SupportedCountry country){
		List<CurrencyInfo>filtered = new ArrayList<CurrencyInfo>();
		for (CurrencyInfo current: currencies){
			if (current.getCountry().equals(country.toString())){
				filtered.add(current);
			}
		}
		return filtered;
	}
	private String getDenomination (String denomination){
		String result = denomination;
		if (("").equals(denomination)){
			result = getString(R.string.denomination_generic);
		}
		return result;
	}
	
	private List<CurrencyInfo> updateCurrencyLocale (List<CurrencyInfo> currencies){
		List<CurrencyInfo> updatedCurrencyList = new ArrayList<CurrencyInfo>();
		for(CurrencyInfo item: currencies){
			CurrencyInfo updatedItem = new CurrencyInfo();
			updatedItem.setCountry(item.getCountry());
			updatedItem.setCurrency(item.getCurrency());
			updatedItem.setDenomination(getDenomination(item.getDenomination()));
			//Verify description & set locale
			if (CurrencyInfoKey.REAL_50_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_50_description)); 
				updatedItem.setWatermark(getString(R.string.real_50_watermark)); 
			}
			else if(CurrencyInfoKey.REAL_100_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.real_100_description)); 
				updatedItem.setWatermark(getString(R.string.real_100_watermark)); 
			}

			else if (CurrencyInfoKey.PESO_AR_100_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_arg_100_description)); 
				updatedItem.setWatermark(getString(R.string.peso_arg_100_watermark)); 
			}
			else if(CurrencyInfoKey.PESO_AR_50_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_arg_50_description)); 
				updatedItem.setWatermark(getString(R.string.peso_arg_50_watermark)); 
			}
			else if (CurrencyInfoKey.PESO_COL_10K_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_col_10K_description)); 
				updatedItem.setWatermark(getString(R.string.peso_col_10K_watermark)); 
			}
			else if (CurrencyInfoKey.PESO_COL_50k_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.peso_col_50K_description)); 
				updatedItem.setWatermark(getString(R.string.peso_col_50K_watermark)); 
			}
			else if (CurrencyInfoKey.USD_50_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.usd_50_description)); 
				updatedItem.setWatermark(getString(R.string.usd_50_watermark)); 
			}				
			else if (CurrencyInfoKey.USD_100_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.usd_100_description)); 
				updatedItem.setWatermark(getString(R.string.usd_100_watermark)); 
			}				
			else if (CurrencyInfoKey.YUAN_ALL_DEN.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.yuan_all_description)); 
				updatedItem.setWatermark(getString(R.string.yuan_all_watermark)); 
			}				
			
			else if (CurrencyInfoKey.PESO_MEX_ALL_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.pmex_all_description)); 
				updatedItem.setWatermark(getString(R.string.pmex_all_watermark)); 
			}				
			else if (CurrencyInfoKey.EURO_ALL_DESCRIPTION.toString().equals(item.getDescription())){
				updatedItem.setDescription(getString(R.string.eur_all_description)); 
				updatedItem.setWatermark(getString(R.string.eur_all_watermark)); 
			}				
			
			updatedCurrencyList.add(updatedItem);
		}		
		
		return updatedCurrencyList;
	}
	
	public void setupMainContent (List<CurrencyInfo> notes, Integer country){
		LinearLayout lContent = (LinearLayout) findViewById(R.id.noteInfoContent);
		String currency = notes.get(0).getCurrency(); 
		String countryString = SupportedCountry.values()[country].toString();
		
		String denomination = notes.get(0).getDenomination();
		
		CardView cardHeader = createHeaderSingleCard(currency, countryString);
		lContent.addView(cardHeader);
		for (CurrencyInfo note : notes){
			denomination = note.getDenomination();
			CardView cardItem = createSingleCard(note.getDescription(), note.getWatermark(), countryString, denomination);
			lContent.addView(cardItem);
		}
	}
	
}
