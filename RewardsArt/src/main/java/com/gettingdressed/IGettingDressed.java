package com.gettingdressed;

import com.gettingdressed.exception.GettingDressedException;

public interface IGettingDressed {

	public void getDressed(String[] inputValues) throws GettingDressedException;
	public void loadDressedDTO(String[] inputValues) throws GettingDressedException;
	
}
