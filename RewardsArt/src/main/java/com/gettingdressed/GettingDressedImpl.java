package com.gettingdressed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gettingdressed.dto.IGettingDressedDTO;
import com.gettingdressed.enums.DressingMaps;
import com.gettingdressed.enums.ERRORS;
import com.gettingdressed.enums.PropertiesTemperatureValue;
import com.gettingdressed.exception.GettingDressedException;
import com.gettingdressed.rules.ICommandRulesCold;
import com.gettingdressed.rules.ICommandRulesHot;

@Component
public class GettingDressedImpl implements IGettingDressed {

	@Autowired
	private ICommandRulesHot commandHot;

	@Autowired
	private ICommandRulesCold commandCold;

	@Autowired
	private IGettingDressedDTO dressedDTO;
	
	public void loadDressedDTO(String[] inputValues) throws GettingDressedException {

		// checks if input values are properly formated.
		if(inputValues == null || inputValues.length < 2 || 
				inputValues[0] == null || 
				   inputValues[1] == null) {
			throw new GettingDressedException("Input Values Null");
		}
		int length = inputValues.length;
		String temperature = inputValues[0].trim();
		dressedDTO.setLoadedCommands(DressingMaps.DressingValues.getDressingMap(temperature.trim()));
		dressedDTO.getDressedResults().append(PropertiesTemperatureValue.OUTPUT.toString());
		
	  
	try {	
		// start at 1 because 'HOT' or 'COLD' is in first position.
		// remove all ',' and check for duplicate values. Throw exception 
		// Rules exception if duplicate is found or entry is not a number.
		for (int i = 1; i < length; i++) {
			inputValues[i] = inputValues[i].replace(',',' ').trim();
			dressedDTO.setProcessingCommand(new Integer(inputValues[i]));
			if (dressedDTO.getInputCommands().contains(dressedDTO.getProcessingCommand())) {
				throw new GettingDressedException(ERRORS.DUPLICATE_VALUE);
			} 
			dressedDTO.addInputCommand(dressedDTO.getProcessingCommand());
        }
	}catch (NumberFormatException ne) {
		throw new GettingDressedException(ERRORS.RUNTIME_EXCEPTION);
	}
	}
	// Run Commands 
	public void getDressed(String[] inputValues) throws GettingDressedException {
	    boolean success = false;
		switch (inputValues[0].trim()) {
			case "HOT": {
				success = commandHot.runRules(); 
				break;
			}
			case "COLD": {
				success = commandCold.runRules();
				break;
			}
			default: {
				throw new GettingDressedException(ERRORS.RUNTIME_EXCEPTION);
			}
		}
		if(!success) {
			throw new GettingDressedException(ERRORS.RULES_VIOLATION);
		}
		
	// ***** Print Output Values *****
		System.out.println(dressedDTO.getDressedResults().toString());
	}
}
