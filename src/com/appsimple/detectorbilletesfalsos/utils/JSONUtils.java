package com.appsimple.detectorbilletesfalsos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.appsimple.detectorbilletesfalsos.beans.CurrencyInfo;

public class JSONUtils {

	private static JSONUtils instance;

	private JSONUtils() {
	}

	public static JSONUtils getInstance() {
		if (instance != null) {
			instance = new JSONUtils();
		}
		return instance;
	}

	private String loadJSONFromAsset(Context ctx, String jsonFile) {
		String json = null;
		try {
			InputStream is = ctx.getAssets().open(jsonFile);
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;
	}

	public List<CurrencyInfo> parseJson(Context ctx, String jsonFile) {

		JSONObject obj;
		List<CurrencyInfo> currencyList = new ArrayList<CurrencyInfo>();
		try {
			obj = new JSONObject(loadJSONFromAsset(ctx, jsonFile));

			JSONArray m_jArry = obj.getJSONArray(jsonFile);

			for (int i = 0; i < m_jArry.length(); i++) {
				JSONObject jo_inside = m_jArry.getJSONObject(i);
				CurrencyInfo item = new CurrencyInfo();
				item.setCountry(jo_inside.getString("country"));
				item.setCurrency(jo_inside.getString("currency"));
				item.setDenomination(jo_inside.getString("denomination"));
				item.setDescription(jo_inside.getString("description"));

				currencyList.add(item);
			}
		} catch (Exception e) {
			Log.d("JSONUTILS",
					"Error while trying to parse JSON: " + e.getMessage());
		}
		return currencyList;
	}

}
