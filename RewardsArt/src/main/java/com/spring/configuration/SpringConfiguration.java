package com.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.gettingdressed.GettingDressedWrapperImpl;

@Configuration
@ComponentScan("com.gettingdressed")
public class SpringConfiguration {
	
	@Bean
	public GettingDressedWrapperImpl gettDressed() {
		return new GettingDressedWrapperImpl();
	}
	
	
}
