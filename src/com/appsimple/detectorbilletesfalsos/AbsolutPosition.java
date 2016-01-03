package com.appsimple.detectorbilletesfalsos;

import android.view.View;
import android.widget.RelativeLayout;

public class AbsolutPosition {
	

	
	public static void setPosition( View view, int positionx, int positiony, int gridx, int gridy){

		int outputx = gridx * positionx  ;
		int outputy = gridy * positiony ; 
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
		params.topMargin = outputy;   
		params.leftMargin = outputx;
		view.setLayoutParams(params); 
		
		}
	
	public static void setPositionmiddle( View view, int positionx, int positiony, int gridx, int gridy){

		int outputx = gridx * positionx - (gridx/2 + view.getWidth()/2);
		int outputy = gridy * positiony - (gridy/2 + view.getHeight()/2); 
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
		params.topMargin = outputy;   
		params.leftMargin = outputx;
		view.setLayoutParams(params); 
		
		}
	public static void setPositionnocenter( View view, int positionx, double d, int gridx, int gridy){

		int outputx = gridx * positionx - (gridx/2);
		int outputy = (int) (gridy * d - (gridy/2)); 
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
		params.topMargin = outputy;   
		params.leftMargin = outputx;
		view.setLayoutParams(params); 
		
		}
	public static void setPositionnocenterx( View view, int positionx, double d, int gridx, int gridy){

		int outputx = gridx * positionx ;
		int outputy = (int) (gridy * d - (gridy/2)); 
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
		params.topMargin = outputy;   
		params.leftMargin = outputx;
		view.setLayoutParams(params); 
		
		}

}
