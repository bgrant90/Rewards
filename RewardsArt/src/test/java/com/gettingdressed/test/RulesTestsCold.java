package com.gettingdressed.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.LinkedHashSet;
import org.junit.Before;
import org.junit.Test;

import com.test.abstractClasses.AbstractTests;

public class RulesTestsCold extends AbstractTests {
	
      @Before
	  public void executedBeforeEach() {
			loadProperties();
 	  }
	
	@Test
	public void testCommandSuccessCOLD() {
		dto.setLoadedCommands(loadedCommandsCOLD());
		dto.setInputCommands(loadDataSuccessCOLD());
	
			assertTrue(cold.runRules());
	
	}
	@Test
	public void testCommandFAILURE_PJS_COLD() {
		dto.setLoadedCommands(loadedCommandsCOLD());
		dto.setInputCommands(loadDataFailureCOLD());
				System.out.println(cold.runRules());
			assertFalse(cold.runRules());
	
	}
	
	@Test
	public void testCommandFAILURE_LEAVE_HOUSE_COLD() {
		dto.setLoadedCommands(loadedCommandsCOLD());
		dto.setInputCommands(loadDataFailure_7_too_soon_COLD());
	
			assertFalse(cold.runRules());
	
	}
	
	
	
	private LinkedHashSet<Integer> loadDataSuccessCOLD() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(8);
		input.add(6);
		input.add(3);
		input.add(4);
		input.add(2);
		input.add(5);
		input.add(1);
		input.add(7);
		return input;
	}
	
		
	private LinkedHashSet<Integer> loadDataFailureCOLD() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(6);
		input.add(3);
		input.add(4);
		input.add(8);  // pjs in wrong place
		input.add(2);
		input.add(5);
		input.add(1);
		input.add(7);
		return input;
	}
	
	private LinkedHashSet<Integer> loadDataFailure_7_too_soon_COLD() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(8);  
		input.add(6);
		input.add(3);
		input.add(4);
		input.add(2);
		input.add(5);
		// 1 is missing
		input.add(7);
		return input;
	}
	

		
	private HashMap<Integer, String> loadedCommandsCOLD() {
		HashMap<Integer, String> loaded = new HashMap<Integer, String>();
		loaded.put(8, "Removing PJs");
		loaded.put(7, "leaving house");
		loaded.put(6, "shorts");
		loaded.put(5,  "socks");
		loaded.put(4, "shirt");
		loaded.put(3, "jacket");
		loaded.put(2, "sunglasses");
		loaded.put(1, "sandals");
	
		generalRules.setDressingMap(loaded);
		
		
		return loaded;
	}

}
