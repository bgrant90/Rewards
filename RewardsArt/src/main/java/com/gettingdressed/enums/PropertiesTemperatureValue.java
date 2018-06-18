package com.gettingdressed.enums;

public enum PropertiesTemperatureValue {
	
	  TEMPERATURE_VALUE("temperature"),
	  DRESSED_COMMANDS("tempCommand"),
	  DELIMITER("="),
	  INPUT_DELIMITER(","),
	  FAIL("fail"),
	  OUTPUT("OUTPUT: "),
	  INPUT("INPUT: "),
	  HOT("HOT"),
	  COLD("COLD");
	  
		
	private String temperature;
	private Integer command;
	
	private PropertiesTemperatureValue(String value) {
		this.temperature = value;
	}
	
	public String toString() {
		return this.temperature;
	}
	
	public Integer toInteger() {
		return this.command;
	}
}
