package com.appsimple.detectorbilletesfalsos;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SelectImagesClass {

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

	public static Bitmap selectImages(Bitmap bitmap, int reqHeight,
			int reqWidth, Resources res, int bitmapnumber, int resIddefault,
			int resId1, int resId2, int resId3, int resId4, int resId5,
			int resId6, int resId7, int resId8, int resId9, int resId10,
			int resId11) {

		int max = 0;
		int resId = 0; // the output id
		if (resIddefault != 0) {
			max = max + 1;
		}
		if (resId1 != 0) {
			max = max + 1;
		}
		if (resId2 != 0) {
			max = max + 1;
		}
		if (resId3 != 0) {
			max = max + 1;
		}
		if (resId4 != 0) {
			max = max + 1;
		}
		if (resId5 != 0) {
			max = max + 1;
		}
		if (resId6 != 0) {
			max = max + 1;
		}
		if (resId7 != 0) {
			max = max + 1;
		}
		if (resId8 != 0) {
			max = max + 1;
		}
		if (resId9 != 0) {
			max = max + 1;
		}
		if (resId10 != 0) {
			max = max + 1;
		}
		if (resId11 != 0) {
			max = max + 1;
		}

		bitmapnumber = bitmapnumber % max;

		if (bitmapnumber == 0) {
			resId = resIddefault;

		}

		if (bitmapnumber == 1) {
			resId = resId1;

		}

		if (bitmapnumber == 2) {
			resId = resId2;

		}
		if (bitmapnumber == 3) {
			resId = resId3;

		}

		if (bitmapnumber == 4) {
			resId = resId4;

		}

		if (bitmapnumber == 5) {
			resId = resId5;

		}

		if (bitmapnumber == 6) {
			resId = resId6;

		}

		if (bitmapnumber == 7) {
			resId = resId7;

		}

		if (bitmapnumber == 8) {
			resId = resId8;

		}

		if (bitmapnumber == 9) {
			resId = resId9;

		}

		if (bitmapnumber == 10) {
			resId = resId10;

		}
		if (bitmapnumber == 11) {
			resId = resId11;

		}

		// First decode with inJustDecodeBounds=true to check dimensions

		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);
		options.inPurgeable = true;

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		if (bitmap != null) {
			bitmap.recycle();
		}
		return BitmapFactory.decodeResource(res, resId, options);

	}

	public static int selectText(Resources res, int bitmapnumber,
			int resIddefault, int resId1, int resId2, int resId3, int resId4,
			int resId5, int resId6, int resId7, int resId8, int resId9,
			int resId10, int resId11, int resId12) {

		int max = 0;
		int resId = 0; // the output id
		if (resIddefault != 0) {
			max = max + 1;
		}
		if (resId1 != 0) {
			max = max + 1;
		}
		if (resId2 != 0) {
			max = max + 1;
		}
		if (resId3 != 0) {
			max = max + 1;
		}
		if (resId4 != 0) {
			max = max + 1;
		}
		if (resId5 != 0) {
			max = max + 1;
		}
		if (resId6 != 0) {
			max = max + 1;
		}
		if (resId7 != 0) {
			max = max + 1;
		}
		if (resId8 != 0) {
			max = max + 1;
		}
		if (resId9 != 0) {
			max = max + 1;
		}
		if (resId10 != 0) {
			max = max + 1;
		}
		if (resId11 != 0) {
			max = max + 1;
		}

		bitmapnumber = bitmapnumber % max;

		if (bitmapnumber == 0) {
			resId = resIddefault;

		}

		if (bitmapnumber == 1) {
			resId = resId1;

		}

		if (bitmapnumber == 2) {
			resId = resId2;

		}
		if (bitmapnumber == 3) {
			resId = resId3;

		}

		if (bitmapnumber == 4) {
			resId = resId4;

		}

		if (bitmapnumber == 5) {
			resId = resId5;

		}

		if (bitmapnumber == 6) {
			resId = resId6;

		}

		if (bitmapnumber == 7) {
			resId = resId7;

		}

		if (bitmapnumber == 8) {
			resId = resId8;

		}

		if (bitmapnumber == 9) {
			resId = resId9;

		}

		if (bitmapnumber == 10) {
			resId = resId10;

		}
		if (bitmapnumber == 11) {
			resId = resId11;

		}

		return resId;

	}

}
