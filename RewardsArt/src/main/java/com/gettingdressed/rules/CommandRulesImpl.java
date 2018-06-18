package com.gettingdressed.rules;

import org.springframework.beans.factory.annotation.Autowired;
import com.gettingdressed.dto.IGettingDressedDTO;

public abstract class CommandRulesImpl implements ICommandRules {

	@Autowired
	IRuleValues generalRules;
	
	@Autowired
	IGettingDressedDTO dressedDTO;
	
	public boolean evaluateCommonRules(Integer entry) {
		
		if (generalRules.isEntryFound() == false) {
			return false;
		}

		if (generalRules.isPropertyFailStatus() == true) {
			return false;
		}

		if (!generalRules.isPajamasAlreadyOff()) {
			if (generalRules.isValuePJsOff()) {
				generalRules.setPajamasOff(true);
			} else {
				return false;
			}
		}
		
		if (generalRules.isValueShirtOn()) {
			generalRules.setShirtOn(true);
		} else {
			if (generalRules.isHeadWear()) {
				if (generalRules.isShirtOn() == false) {
					return false;
				}
			}
		}
		
		if (generalRules.isValueLeavingHouse()) {
			if (generalRules.isLeavingHouse(dressedDTO.getInputCommands().size()) == false) {
				return false;
			}
		}

		return true;

	}
 }
