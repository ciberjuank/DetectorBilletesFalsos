package com.appsimple.DetectorBilleteFalso2.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.DetectorBilleteFalso2.R;
import com.appsimple.DetectorBilleteFalso2.enums.SupportedCountry;

public class CountryGridViewAdapter  extends BaseAdapter{
	 private Context mContext;
	    public String[] options = {SupportedCountry.ARGENTINA.toString(),
	    		SupportedCountry.COLOMBIA.toString(),
	    		SupportedCountry.USA.toString(),
	    		SupportedCountry.BRASIL.toString(),
	    		SupportedCountry.EUROPE.toString(),
	    		SupportedCountry.CHINA.toString(),
	    		SupportedCountry.MEXICO.toString()};

	    public Integer[] flags = {R.drawable.argentina_flag, 
	    		R.drawable.colombia_flag, R.drawable.usa_flag,
	    		R.drawable.brazil_flag, 
	    		R.drawable.europe_flag, 
	    		R.drawable.china_flag,
	    		R.drawable.mexico_flag};

	    
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
	        itemMenu.setOrientation(LinearLayout.VERTICAL);
	        itemMenu.setGravity(Gravity.CENTER_HORIZONTAL);
	        TextView textView = new TextView(mContext);
	        String optionString = options[position];
			textView.setGravity(Gravity.CENTER);
	        int textColor = Integer.parseInt("0000CD", 16) + 0xFF000000;
			textView.setTextSize(25);
			textView.setTextColor(textColor);

			
	        textView.setText(optionString);	 
	        ImageView imgFlag = new ImageView(mContext);
	        imgFlag.setImageResource(flags[position]);;
	        
	        itemMenu.addView(imgFlag);
	        itemMenu.addView(textView);
	        
	        return itemMenu;
	    }
	    
}
