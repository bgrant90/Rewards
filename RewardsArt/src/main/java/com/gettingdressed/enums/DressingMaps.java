package com.gettingdressed.enums;

/*
 *  Contains initial map for HOT and COLD values
 * 
 */

import java.util.Map;

import com.gettingdressed.loadmap.LoadConfiguartionValuesMap;


public enum DressingMaps {
		
	DressingValues(LoadConfiguartionValuesMap.loadConfigurationValues());
	
	private Map<String, Map<Integer, String>> dressingMaps;
	
	private DressingMaps(Map<String, Map<Integer, String>> dressingMaps ) {
		this.dressingMaps = dressingMaps;
	}
	
	public Map<Integer, String> getDressingMap (String temperature) {
		 return this.dressingMaps.get(temperature);	
	}
	
	public Map<String, Map<Integer, String>>getMap () {
		return this.dressingMaps;
	}

}
