package com.gettingdressed.rules;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.gettingdressed.enums.PropertiesTemperatureValue;
import com.gettingdressed.enums.RuleValues;
import com.gettingdressed.loadmap.LoadConfiguartionValuesMap;

@Component
public class RuleValuesImpl implements IRuleValues {
		
	private Map<Integer, String> dressingMap;
	private String  temperature;
	private Integer entry;
	private boolean socksOn;
	private boolean shirtOn;
	private boolean pajamasOff;
	private boolean pantsOn;
	
	public void setTemperature(String temperature ) {
		this.temperature = temperature;
	}
	
	public void setEntry (Integer entry) {
		this.entry = entry;
	}
	
	public void setDressingMap (Map<Integer, String> dressingMap) {
		this.dressingMap = dressingMap;
	}
	
	public boolean isEntryFound () {
		if (this.dressingMap.containsKey(this.entry) == false) {
			return false;
		}
		return true;
	}
	
	public boolean isHeadWear () {
		return (this.entry.equals(RuleValues.HEAD_WEAR.toInteger())) ? true : false; 
	}
	
	public boolean isPantsOn () {
		return this.pantsOn;
	}
	
	public boolean isSocksOn () {
		return this.socksOn;
	}
		
	
	public boolean isPropertyFailStatus() {
		if (this.dressingMap.get(this.entry).equals(PropertiesTemperatureValue.FAIL.toString())) {
			return true;
		}
		return false;
	}
	
	public boolean isValueLessThanPJsOff () {
		if (this.entry < RuleValues.PJS_OFF.toInteger()) {
			return true;
		} 
		return false;
	}

	public void setSocksOn (boolean on) {
		this.socksOn = on;
	}
	
	public boolean getSocksOn () {
		return this.socksOn;
	}
	
	public void setShirtOn (boolean on) {
		this.shirtOn = on;
	}
	
	public boolean isShirtOn () {
		return this.shirtOn;
	}
	
	public void setPajamasOff (boolean off) {
		this.pajamasOff = off;
	}
	
	public boolean isPajamasAlreadyOff () {
		return this.pajamasOff;
	}
	
	public boolean isValueShirtOn () {
		if (this.entry.equals(RuleValues.SHIRT_ON.toInteger())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValuePJsOff () {
		if (this.entry.equals(RuleValues.PJS_OFF.toInteger())) {
			this.pajamasOff = true;
			return true;
		}
		return false;
	}
	
	public boolean isValueFootWear () {
		if (this.entry.equals(RuleValues.FOOT_WEAR.toInteger())) {
			return true;
		}
		return false;
	}
	
	
	public boolean isValuePantsOn () {
		if (this.entry.equals(RuleValues.PANTS_ON.toInteger())) {
			return true;
		}
		return false;
	}
	
	public void setPantsOn (boolean on) {
		this.pantsOn = true;
	}

	
	public boolean isValueSocksOn () {
		if (this.entry.equals(RuleValues.SOCKS_ON.toInteger())) {
			return true;
		}
		return false;
	}
	
	public boolean isValueLeavingHouse () {
		if (this.entry.equals(RuleValues.LEAVING_HOUSE.toInteger())) {
			return true;
		}
		return false;
	}
	
	public boolean isLeavingHouse (Integer commandsRan) {
			return (commandsRan == dressingMap.size() - LoadConfiguartionValuesMap.itemsInFailure.get(temperature)) ? true : false; 
	}
}
