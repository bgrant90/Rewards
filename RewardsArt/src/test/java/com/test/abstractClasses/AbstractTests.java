package com.test.abstractClasses;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.gettingdressed.dto.IGettingDressedDTO;
import com.gettingdressed.loadmap.LoadConfiguartionValuesMap;
import com.gettingdressed.rules.ICommandRulesCold;
import com.gettingdressed.rules.ICommandRulesHot;
import com.gettingdressed.rules.IRuleValues;
import com.spring.configuration.test.SpringConfigurationTests;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigurationTests.class, loader = AnnotationConfigContextLoader.class)
public class AbstractTests {
	
	@Autowired
	public ICommandRulesHot hot;
	
	@Autowired
	public ICommandRulesCold cold;
	
	@Autowired
	public IRuleValues generalRules;
	
	@Autowired
	public IGettingDressedDTO dto;
	
	public void loadProperties() {
		LoadConfiguartionValuesMap.loadConfigurationValues();
	}
 

}
