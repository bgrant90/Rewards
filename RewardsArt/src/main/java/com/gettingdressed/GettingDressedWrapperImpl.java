package com.gettingdressed;

/*
 * 
 *  Main Entry to application. This class processes the rules 
 *  Hot And Cold.
 * 
 *  RUNS DUPLICATE ENTRY RULE
 * 
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gettingdressed.dto.IGettingDressedDTO;
import com.gettingdressed.enums.PropertiesTemperatureValue;
import com.gettingdressed.exception.GettingDressedException;

public class GettingDressedWrapperImpl implements IGettingDressedWrapper {

	@Autowired
	private IGettingDressed dressed;

	@Autowired
	private IGettingDressedDTO dressedDTO;

	public void getDressed(String[] inputValues) {
		
		printInputValues(inputValues);
				
	    try {
	    	
			dressed.loadDressedDTO(inputValues);
			dressed.getDressed(inputValues);
			
		} catch (GettingDressedException ge) {
			switch (ge.getErrorsEnum()) {
			 case DUPLICATE_VALUE: {
				Map<Integer, String> loadedCommands = dressedDTO.getLoadedCommands();
				StringBuffer output = new StringBuffer();
				output.append(dressedDTO.getDressedResults());
				for (Integer i : dressedDTO.getInputCommands()) {
					output.append(loadedCommands.get(i));
					output.append(PropertiesTemperatureValue.INPUT_DELIMITER.toString() + " "); 
				}
				System.out.println(output.toString() + PropertiesTemperatureValue.FAIL.toString());
				break;
			}
			case RULES_VIOLATION: {
				Map<Integer, String> loadedCommands = dressedDTO.getLoadedCommands();
				StringBuffer output = new StringBuffer();
				output.append(dressedDTO.getDressedResults());
				if(loadedCommands == null) {
					   break;
	 		    }
				System.out.println(output.toString());
				break;
			}
			default: {
				System.out.println("OUTPUT: " + PropertiesTemperatureValue.FAIL.toString());
				break;	
			}
			}
		}
	}
	private void printInputValues(String[] input) {
		
		StringBuffer outputInput = new StringBuffer(
				PropertiesTemperatureValue.INPUT.toString() + input[0] + " ");
		
		for(int i = 1; i<input.length; i++) {
			outputInput.append(input[i]);
		}
		System.out.println(outputInput.toString());
	}

}
