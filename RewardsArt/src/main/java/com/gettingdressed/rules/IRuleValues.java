package com.gettingdressed.rules;

import java.util.Map;

public interface IRuleValues {
	
	public void setTemperature(String temperature );
	
	public void setEntry (Integer entry);
	
	public void setDressingMap (Map<Integer, String> dressingMap);
	
	public boolean isEntryFound (); 
	
	public boolean isHeadWear (); 
	
	public boolean isPantsOn ();
	
	public boolean isSocksOn ();
			
	public boolean isPropertyFailStatus(); 
	
	public boolean isValueLessThanPJsOff (); 

	public void setSocksOn (boolean on); 
	
	public boolean getSocksOn();
	
	public void setShirtOn (boolean on);
	
	public boolean isShirtOn();
	
	public void setPajamasOff (boolean off);
	
	public boolean isPajamasAlreadyOff();
	
	public boolean isValueShirtOn();
	
	public boolean isValuePJsOff();
	
	public boolean isValueFootWear();	
	
	public boolean isValuePantsOn();
	
	public void setPantsOn(boolean on);
	
	public boolean isValueSocksOn();
	
	public boolean isValueLeavingHouse();
	
	public boolean isLeavingHouse (Integer commandsRan);

}
