package com.appsimple.detectorbilletesfalsos.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimple.detectorbilletesfalsos.R;

public class MenuGridViewAdapter extends BaseAdapter {

	private Context mContext;
	public int[] options = { R.string.menuInitUV, R.string.menucheckWatermark,
			R.string.menuNoteSpec, R.string.menuRemoveAdds, R.string.menuHelp,
			R.string.menuShare };

	public int[] backgroundColors = { R.color.lightViolet, R.color.darkGreen,
			R.color.lightYellow, R.color.lightGreen,
			R.color.darkBlue, R.color.darkPink };

	// Constructor
	public MenuGridViewAdapter(Context c) {
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
		
		int height = (int) (mContext.getResources().getDimension(R.dimen.option_menu_height) / mContext.getResources().getDisplayMetrics().density);
		//int width = (int) (mContext.getResources().getDimension(R.dimen.option_menu_width) / mContext.getResources().getDisplayMetrics().density);
		
		DisplayMetrics displayMetrics=mContext.getResources().getDisplayMetrics();
		int screenWidthInDp= Double.valueOf(displayMetrics.widthPixels * 0.46).intValue();
		
		AbsListView.LayoutParams lp= new AbsListView.LayoutParams(screenWidthInDp, height);
		item.setGravity(Gravity.CENTER);
		item.setOrientation(LinearLayout.VERTICAL);
		item.setBackgroundResource(backgroundColors[position]);
		ImageView icon = new ImageView(mContext);

		TextView textView = new TextView(mContext);
		textView.setGravity(Gravity.CENTER);
		textView.setBackgroundResource(R.color.trasparent);
		int textColor = Integer.parseInt("fefefe", 16) + 0xFF000000;
		textView.setTextSize(25);
		textView.setTextColor(textColor);
		String optionString = mContext.getString(options[position]);
		textView.setText(optionString);
		item.addView(icon);
		item.addView(textView);
		item.setLayoutParams(lp);
		
		return item;
	}

}
