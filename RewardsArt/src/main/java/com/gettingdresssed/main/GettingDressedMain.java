package com.gettingdresssed.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gettingdressed.GettingDressedWrapperImpl;
import com.gettingdressed.IGettingDressedWrapper;
import com.gettingdressed.enums.DressingMaps;
import com.gettingdressed.enums.ERRORS;
import com.gettingdressed.enums.PropertiesTemperatureValue;
import com.gettingdressed.exception.GettingDressedException;
import com.spring.configuration.SpringConfiguration;


public class GettingDressedMain {

	private AnnotationConfigApplicationContext ctx;
	
	public GettingDressedMain(String[] args) {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(SpringConfiguration.class);
		ctx.refresh();
		
	 try {	
		 
		 if (DressingMaps.DressingValues.getMap() == null) {
			 throw new GettingDressedException(ERRORS.RUNTIME_EXCEPTION);
		 }
		 
		IGettingDressedWrapper gettingDressed = ctx.getBean(GettingDressedWrapperImpl.class);
		gettingDressed.getDressed(args);
	 }catch (Exception ge) {
	   System.out.println(PropertiesTemperatureValue.FAIL.toString());	 
	   System.out.println(ge.getMessage());
	 }
	}

	public static void main(String[] args) {
		new GettingDressedMain(args);
	}
}
