package com.gettingdressed.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.LinkedHashSet;
import org.junit.Before;
import org.junit.Test;
import com.test.abstractClasses.AbstractTests;

public class RulesTestsHot extends AbstractTests {

		
	 @Before
	  public void executedBeforeEach() {
    	 loadProperties();
    	 
	  }
	
	@Test
	public void testCommandSuccessHot() {
		dto.setLoadedCommands(loadedCommandsHOT());
		dto.setInputCommands(loadDataSuccessHOT());

			assertTrue(hot.runRules());
    }
	@Test
	public void testCommandSuccess_sel_fail_Hot() {
		dto.setLoadedCommands(loadedCommandsHOT());
		dto.setInputCommands(loadDataSelectFailed_sel_fail_HOT());

			assertFalse(hot.runRules());
    }
	@Test
	public void testCommandSuccess_incomplete_Hot() {
		dto.setLoadedCommands(loadedCommandsHOT());
		dto.setInputCommands(loadDataFailureHOT_incomplete());

			assertFalse(hot.runRules());
    }

	
	private LinkedHashSet<Integer> loadDataSuccessHOT() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(8);
		input.add(6);
		input.add(4);
		input.add(2);
		input.add(1);
		input.add(7);
		return input;
	}
	private LinkedHashSet<Integer> loadDataSelectFailed_sel_fail_HOT() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(8);
		input.add(6);
		input.add(3);
		input.add(4);
		input.add(2);
		input.add(1);
		input.add(7);
		return input;
	}
	
	
	private LinkedHashSet<Integer> loadDataFailureHOT_incomplete() {
		LinkedHashSet<Integer> input = new LinkedHashSet<Integer>(); 
		input.add(8);
		input.add(6);
		input.add(3);
		return input;
	}
	
	private HashMap<Integer, String> loadedCommandsHOT() {
		
		HashMap<Integer, String> loaded = new HashMap<Integer, String>();
		loaded.put(8, "Removing PJs");
		loaded.put(7, "leaving house");
		loaded.put(6, "shorts");
		loaded.put(5,  "fail");
		loaded.put(4, "shirt");
		loaded.put(3, "fail");
		loaded.put(2, "sunglasses");
		loaded.put(1, "sandals");
	
		generalRules.setDressingMap(loaded);
		
		return loaded;
	}
}
