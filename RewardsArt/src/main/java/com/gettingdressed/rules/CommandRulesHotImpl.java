package com.gettingdressed.rules;

import org.springframework.stereotype.Component;
import com.gettingdressed.enums.PropertiesTemperatureValue;

@Component
public class CommandRulesHotImpl extends CommandRulesImpl implements ICommandRulesHot {
		
	public boolean runRules() {
		
		this.generalRules.setDressingMap(dressedDTO.getLoadedCommands());
	
		for (Integer entry : dressedDTO.getInputCommands()) {
			this.generalRules.setEntry(entry);
			this.generalRules.setTemperature(PropertiesTemperatureValue.HOT.toString());
			this.generalRules.setEntry(entry);
			 if(evaluateCommonRules(entry) == false) {
				 dressedDTO.addItemToDressedResults(
						 PropertiesTemperatureValue.FAIL.toString(), entry); 
				 return false;
			 }
			 dressedDTO.addItemToDressedResults(
						       dressedDTO.getLoadedCommands().get(entry).toString(), entry); 
	    }
		 return true;
	}
}
