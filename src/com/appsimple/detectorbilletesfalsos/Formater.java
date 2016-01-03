package com.appsimple.detectorbilletesfalsos;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

public class Formater {

	public static Bitmap check(boolean isopen, Bitmap open, Bitmap closed,
			Bitmap stars1, Bitmap stars2, Bitmap stars3, int numberofstars) {

		if (isopen) {

			if (numberofstars == 1) {

				return stars1;
			}

			else if (numberofstars == 2) {
				return stars2;
			} else if (numberofstars == 3) {
				return stars3;
			} else
				return open;

		}

		else {
			return closed;
		}

	}

	public static void formatTxt(TextView view, int txtheight, int viewheight,
			int viewwidth, String txt, Typeface tf) {

		view.setTypeface(tf);
		view.setText(txt);
		view.setTextSize(TypedValue.COMPLEX_UNIT_PX, txtheight);
		view.getLayoutParams().height = viewheight;
		view.getLayoutParams().width = viewwidth;
		view.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

	}

}
