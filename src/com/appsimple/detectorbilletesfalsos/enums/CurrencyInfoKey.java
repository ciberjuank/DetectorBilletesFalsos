package com.appsimple.detectorbilletesfalsos.enums;

public enum CurrencyInfoKey {
	PESO_AR_100_WATERMARK("peso_ar_100_watermark"),
	PESO_AR_100_DESCRIPTION("peso_ar_100_description"),
	PESO_AR_50_WATERMARK("peso_ar_50_watermark"),
	PESO_AR_50_DESCRIPTION("peso_ar_50_description"),
	REAL_100_WATERMARK("real_100_watermark"),
	REAL_100_DESCRIPTION("real_100_description"),
	REAL_50_WATERMARK("real_50_watermark"),
	REAL_50_DESCRIPTION("real_50_description"),
	USD_100_WATERMARK("usd_100_watermark"),
	USD_100_DESCRIPTION("usd_100_description"),
	USD_50_WATERMARK("usd_50_watermark"),
	USD_50_DESCRIPTION("usd_50_description"),
	EURO_500_WATERMARK("euro_500_watermark"),
	EURO_500_DESCRIPTION("euro_500_description"),
	EURO_100_WATERMARK("euro_100_watermark"),
	EURO_100_DESCRIPTION("euro_100_description"),
	PESO_COL_100K_WATERMARK("peso_col_100K_watermark"),
	PESO_COL_100K_DESCRIPTION("peso_col_100k_description"),
	PESO_COL_50K_WATERMARK("peso_col_50K_watermark"),
	PESO_COL_50k_DESCRIPTION("peso_col_50k_description");

	private String description;
	
	private CurrencyInfoKey(String description){
		this.description = description;
	}
	
	public String toString(){
		return description;
	}
}
