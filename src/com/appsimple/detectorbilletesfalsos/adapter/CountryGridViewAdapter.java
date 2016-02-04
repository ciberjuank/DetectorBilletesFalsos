package com.appsimple.detectorbilletesfalsos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.detectorbilletesfalsos.R;
import com.appsimple.detectorbilletesfalsos.enums.SupportedCountry;

public class CountryGridViewAdapter  extends BaseAdapter{

	 private Context mContext;
	    public String[] options = {SupportedCountry.ARGENTINA.toString(),
	    		SupportedCountry.BRASIL.toString(),
	    		SupportedCountry.COLOMBIA.toString(),
	    		SupportedCountry.EUROPE.toString(),
	    		SupportedCountry.USA.toString(),
	    		SupportedCountry.CHINA.toString()};

	    public Integer[] flags = {R.drawable.argentina_flag, 
	    		R.drawable.brazil_flag, R.drawable.colombia_flag,
	    		R.drawable.europe_flag, R.drawable.usa_flag,
	    		R.drawable.china_flag};

	    
	    // Constructor
	    public CountryGridViewAdapter(Context c){
	        mContext = c;
	    }

	    @Override
	    public int getCount() {
	        return options.length;
	    }

	    @Override
	    public Object getItem(int position) {
	        return options[position];
	    }

	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        LinearLayout itemMenu = new LinearLayout(mContext);
	    	
	        TextView textView = new TextView(mContext);
	        String optionString = options[position];
	        textView.setText(optionString);	 
	        ImageView imgFlag = new ImageView(mContext);
	        imgFlag.setImageResource(flags[position]);;
	        
	        itemMenu.addView(imgFlag);
	        itemMenu.addView(textView);
	        
	        return itemMenu;
	    }
	    
}
