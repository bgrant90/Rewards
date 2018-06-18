package com.gettingdressed.dto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public interface IGettingDressedDTO {
	
	public void addItemToDressedResults (String item, Integer entry);

	public Integer getProcessingCommand();

	public void setProcessingCommand(Integer failedCommand);

	public void addInputCommand(Integer input);
	
	public void setInputCommands (LinkedHashSet<Integer> input);
	
	public StringBuilder getDressedResults();
	
	public void setDressedResults(StringBuilder dressedResults);
	
	public Map<Integer, String> getLoadedCommands();
	
	public void setLoadedCommands(Map<Integer, String> loadedCommands);
	
	public HashSet<Integer> getInputCommands();
	
	public void setInputCommands(HashSet<Integer> inputCommands);
	
	

}
