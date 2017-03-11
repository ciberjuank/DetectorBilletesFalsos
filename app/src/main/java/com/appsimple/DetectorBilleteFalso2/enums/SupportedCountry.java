package com.appsimple.DetectorBilleteFalso2.enums;

public enum SupportedCountry {
	ARGENTINA ("Argentina"),
	COLOMBIA ("Colombia"),
	USA ("USA"),
	BRASIL("Brasil"),
	EUROPE ("Europe"),
	CHINA ("China"),
	MEXICO("Mexico");
	
	private String description;
	
	SupportedCountry (String description){
		this.description = description;
	}
	
	public String toString (){
		return this.description;
	}

}
