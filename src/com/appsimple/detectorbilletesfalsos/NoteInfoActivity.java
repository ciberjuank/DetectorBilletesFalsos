package com.appsimple.detectorbilletesfalsos;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextThemeWrapper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.detectorbilletesfalsos.beans.CurrencyInfo;
import com.appsimple.detectorbilletesfalsos.enums.CurrencyInfoKey;
import com.appsimple.detectorbilletesfalsos.enums.IntentParam;
import com.appsimple.detectorbilletesfalsos.enums.SupportedCountry;
import com.appsimple.detectorbilletesfalsos.utils.JSONUtils;

public class NoteInfoActivity extends Activity {
	
	private Context ctx;
	
   
	  private CardView createSingleCard(String currency, String country) {
		  
	        CardView card = new CardView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardViewStyle), null, 0);
	        
	        LinearLayout rightInner = new LinearLayout(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardContent), null, 0);
	        rightInner.setOrientation(LinearLayout.HORIZONTAL);

	        LinearLayout leftInner = new LinearLayout(new ContextThemeWrapper(NoteInfoActivity.this, R.style.CardContent), null, 0);
	        leftInner.setOrientation(LinearLayout.VERTICAL);
	        TextView currencyTitle = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));
	        currencyTitle.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
	        ));

	        currencyTitle.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
	        currencyTitle.setText(getString (R.string.country) + ": " + country);

	        TextView countryDescription = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));

	        countryDescription.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
	        ));
	        countryDescription.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
	        countryDescription.setText(getString (R.string.currency) + ": " + currency);

	        TextView watermarkDescription = new TextView(new ContextThemeWrapper(NoteInfoActivity.this, R.style.cardTextStyle));

	        watermarkDescription.setLayoutParams(new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
	        ));
	        watermarkDescription.setBackgroundColor(getResources().getColor(R.color.defaultCardBackground));
	        watermarkDescription.setText(getString (R.string.watermark) + ": " + country);

	        
	        leftInner.addView(currencyTitle);
	        leftInner.addView(countryDescription);
	        leftInner.addView(watermarkDescription);
	        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
	                LinearLayout.LayoutParams.MATCH_PARENT,
	                LinearLayout.LayoutParams.MATCH_PARENT
	        );
	        card.setLayoutParams(lParams);

	        ImageView noteImg = new ImageView(ctx);
	        noteImg.setImageResource(R.drawable.ar_note);
	        rightInner.addView(noteImg);
	        rightInner.addView (leftInner);
	        card.addView(rightInner);

	        return card;

	    }
	  

	
    private CardView createSingleCard(String header, String description1, String description2) {

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
        cardInner.addView(noteSecurityDescription);
        cardInner.addView(watermarkDescription);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        card.setLayoutParams(lParams);

        card.addView(cardInner);

        return card;

    }

    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_info_activity);
		ctx = getApplicationContext();
		Intent currentIntent = getIntent();
		int country = currentIntent.getIntExtra(IntentParam.COUNTRY.toString(), 0);
		List<CurrencyInfo> notes = loadNoteInfo(country);
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
			if (current.getCountry().equals(country)){
				filtered.add(current);
			}
		}
		return filtered;
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
			updatedCurrencyList.add(updatedItem);
		}		
		
		return updatedCurrencyList;
	}

	
	public void setupMainContent (List<CurrencyInfo> notes, Integer country){
		LinearLayout lContent = (LinearLayout) findViewById(R.id.noteInfoContent);
		String currency = getString(R.string.Currency) +": " +notes.get(0).getCurrency() + notes.get(0);
		String countryString = SupportedCountry.values()[country].toString();
		CardView cardHeader = createSingleCard(currency, countryString);
		lContent.addView(cardHeader);
		for (CurrencyInfo note : notes){
			String denomination = getString(R.string.Denomination) + ":" + note.getDenomination();
			CardView cardItem = createSingleCard(denomination, note.getDescription(), note.getWatermark());
			lContent.addView(cardItem);
		}
	}
	
}
