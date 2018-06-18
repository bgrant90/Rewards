package com.gettingdressed.rules;

import org.springframework.stereotype.Component;

import com.gettingdressed.enums.PropertiesTemperatureValue;

@Component
public class CommandRulesColdImpl extends CommandRulesImpl implements ICommandRulesCold {

	public boolean runRules() {

		this.generalRules.setDressingMap(dressedDTO.getLoadedCommands());
		this.generalRules.setTemperature(PropertiesTemperatureValue.COLD.toString());
		for (Integer entry : dressedDTO.getInputCommands()) {
			dressedDTO.setProcessingCommand(entry);
			this.generalRules.setEntry(entry);
			if (evaluateCommonRules(entry) == false || evaluateLocalRules() == false) {
				dressedDTO.addItemToDressedResults(PropertiesTemperatureValue.FAIL.toString(), entry);
				return false;
			}
			dressedDTO.addItemToDressedResults(dressedDTO.getLoadedCommands().get(entry).toString(), entry);
		}
		return true;
	}

	private boolean evaluateLocalRules() {

		if (this.generalRules.isValueFootWear()) {
			if (this.generalRules.isPantsOn() && this.generalRules.isSocksOn()) {
				return true;
			} else {
				return false;
			}
		}
		
		if (this.generalRules.isValueSocksOn()) { 
			this.generalRules.setSocksOn(true );
			return true;
		}
		if (this.generalRules.isValuePantsOn()) {
			this.generalRules.setPantsOn(true);
			return true;
		}

		

		return true;

	}
}
