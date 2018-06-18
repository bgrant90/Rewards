package com.gettingdressed.dto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.gettingdressed.enums.PropertiesTemperatureValue;

@Component
public class GettingDressedDTO implements IGettingDressedDTO {

	private Map<Integer, String> loadedCommands;
	private Set<Integer> inputCommands = new LinkedHashSet<>();
	private StringBuilder dressedResults = new StringBuilder();
	private Integer processingCommand;
	
	
	public void addItemToDressedResults (String item, Integer entry) {
		
		dressedResults.append(item);
		if (!item.equals(PropertiesTemperatureValue.FAIL.toString()) ) {
		 if (entry != 7) { 
			dressedResults.append(PropertiesTemperatureValue.INPUT_DELIMITER.toString() + " "); 
		 }
		}
	}

	public Integer getProcessingCommand() {
		return processingCommand;
	}

	public void setProcessingCommand(Integer failedCommand) {
		this.processingCommand = failedCommand;
	}

	public void addInputCommand(Integer input) {
		this.inputCommands.add(input);
	}
	
	public void setInputCommands (LinkedHashSet<Integer> input) {
		this.inputCommands = input;
	}
	public StringBuilder getDressedResults() {
		return dressedResults;
	}
	public void setDressedResults(StringBuilder dressedResults) {
		this.dressedResults = dressedResults;
	}	
	public Map<Integer, String> getLoadedCommands() {
		return loadedCommands;
	}
	public void setLoadedCommands(Map<Integer, String> loadedCommands) {
		this.loadedCommands = loadedCommands;
	}
	public HashSet<Integer> getInputCommands() {
		return (HashSet<Integer>)inputCommands;
	}
	public void setInputCommands(HashSet<Integer> inputCommands) {
		this.inputCommands = inputCommands;
	}
}
