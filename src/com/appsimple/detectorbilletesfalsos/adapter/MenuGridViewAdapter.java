package com.appsimple.detectorbilletesfalsos.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.detectorbilletesfalsos.R;

public class MenuGridViewAdapter  extends BaseAdapter{

	 private Context mContext;
	    public int[] options = {R.string.menuInitUV,R.string.menucheckWatermark, R.string.menuNoteSpec,
	    		R.string.menuRemoveAdds, R.string.menuHelp, R.string.menuCredits, R.string.menuShare	            
	    };

	    public int[] backgroundColors = {R.color.lightViolet, R.color.darkGreen, R.color.lightYellow, R.color.darkViolet, 
	    		R.color.lightGreen, R.color.darkBlue, R.color.dirtyWhite
	    };

	    // Constructor
	    public MenuGridViewAdapter(Context c){
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
	    
	    	LinearLayout item = new LinearLayout(mContext);
	        item.setOrientation(LinearLayout.VERTICAL);
	        item.setBackgroundColor(backgroundColors[position]);
	        ImageView icon = new ImageView(mContext);
	        
	    	TextView textView = new TextView(mContext);
	    	textView.setBackgroundColor(backgroundColors[position]);
	        String optionString = mContext.getString(options[position]);
	        textView.setText(optionString);	 
	        item.addView(icon);
	        item.addView(textView);
	        
	        return item;
	    }
	    
}
