package com.gettingdressed.loadmap;

/**
 *  Loads initial maps HOT and COLD 
 *  into PropertiesTemperatureValue ENUM
 *   
 *  Property file is: GettingDressed_English.properties
 *  
 */


import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.gettingdressed.enums.PropertiesTemperatureValue;
import com.gettingdressed.exception.GettingDressedException;


public class LoadConfiguartionValuesMap {
	
	public static Map<String, Integer> itemsInFailure = new HashMap<>();
	
	public static Map<String, Map<Integer, String>> loadConfigurationValues() {
		Properties prop = new Properties();
		InputStream input = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();  
		input = loader.getResourceAsStream("GettingDressed_English.properties");
	
		Map<String, Map<Integer, String>> temperatureAndCommands = new HashMap<>();
	
		try {
			prop.load(input);
			Enumeration<?> e = prop.propertyNames();
		   while (e.hasMoreElements()) {
			 String key = (String) e.nextElement();
			 itemsInFailure.put(key, 0);
			 String value = prop.getProperty(key);
			 List<String> temperatureList = Arrays.asList(value.split(","));
			 temperatureAndCommands.put(temperatureList.get(0), loadCommands(temperatureList, key));
		  }
		}catch (Exception e) {
			temperatureAndCommands = null; 
		}

	  return temperatureAndCommands;
	}
	private  static Map<Integer, String> loadCommands(List<String> commands, String key) throws GettingDressedException{
		Map<Integer, String> commandsMap = new HashMap<>();  
		String delimiter = PropertiesTemperatureValue.DELIMITER.toString();

		int length = commands.size();
	  try {  	
		for(int i = 1; i < length; i++ ) {
			int index = commands.get(i).indexOf(delimiter);
			Integer firstParam = new Integer(commands.get(i).substring(0, index).trim());
			if (commandsMap.containsKey(firstParam)) {
				throw new GettingDressedException(firstParam);
			} else {
				commandsMap.put(firstParam, commands.get(i).substring(index + 1, commands.get(i).length()));
				if (commandsMap.get(firstParam).equals(PropertiesTemperatureValue.FAIL.toString())) {
					itemsInFailure.put(key, itemsInFailure.get(key)+1);
				}
			}
       }
	  }catch (NumberFormatException ne) {
		  throw new GettingDressedException(ne);
	  }
		return commandsMap;
	}
}
