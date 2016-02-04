package com.appsimple.detectorbilletesfalsos.service;

import com.google.android.gms.plus.PlusShare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GplusService {
	
	private static GplusService instance;
	private static Context ctx;
	private GplusService(){}
	
	public static GplusService getInstance(){
		if (instance == null){
			instance = new GplusService();
		}
		return instance;
	}
	
	public void shareDialog (String title, String applicationId, 
		String dialogTitle, String dialogDescription, String url){
		PlusShare.Builder gpBuilder = new PlusShare.Builder(ctx);
        
		gpBuilder.addCallToAction(
		          "CREATE_ITEM", /** call-to-action button label */
		          Uri.parse(url), /** call-to-action url (for desktop use) */
		          "/pages/create" /** call to action deep-link ID (for mobile use), 512 characters or fewer */);

		      // Set the content url (for desktop use).
		gpBuilder.setContentUrl(Uri.parse(url));

		      // Set the target deep-link ID (for mobile use).
		gpBuilder.setContentDeepLinkId("/pages/",
		              null, null, null);

		      // Set the share text.
		gpBuilder.setText(dialogDescription);

		ctx.startActivity(gpBuilder.getIntent());
	
	}
	
}
