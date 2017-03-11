package com.appsimple.DetectorBilleteFalso2.service;

import android.content.Context;
import android.content.Intent;

public class TwitterService {

	private static TwitterService instance;
	private static Context ctx;
	private TwitterService(){}
	
	public static TwitterService getInstance(){
		if (instance == null){
			instance = new TwitterService();
		}
		return instance;
	}
	
	public static void shareDialog(String tweetText){
		
		Intent tweet = new Intent(Intent.ACTION_SEND);
		
		tweet.putExtra(Intent.EXTRA_TEXT, tweetText);
		tweet.setType("application/twitter");
		
		ctx.startActivity(tweet);
	}
	
}
