package com.appsimple.detectorbilletesfalsos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.appsimple.detectorbilletesfalsos.beans.CurrencyInfo;

import android.content.Context;
import android.util.Log;

public class JSONUtils {
	
	private JSONUtils instance;
	
	private JSONUtils(){}
	
	public JSONUtils getInstance(){
		if (instance != null){
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
	public CurrencyInfo parseJson(Context ctx, String jsonFile){
		
	    JSONObject obj;
		try {
			obj = new JSONObject(loadJSONFromAsset(ctx, jsonFile));
		
	        JSONArray m_jArry = obj.getJSONArray("formules");
	        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
	        HashMap<String, String> m_li;
	
	        for (int i = 0; i < m_jArry.length(); i++) {
	            JSONObject jo_inside = m_jArry.getJSONObject(i);
	            Log.d("Details-->", jo_inside.getString("formule"));
	            String formula_value = jo_inside.getString("formule");
	            String url_value = jo_inside.getString("url");
	            m_li = new HashMap<String, String>();
	            m_li.put("formule", formula_value);
	            m_li.put("url", url_value);
	
	            formList.add(m_li);
	        }
		}
		catch (Exception e){
			Log.d("JSONUTILS","Error while trying to parse JSON: " + e.getMessage());
		}
	}
	
	    
	    
}
