/**
 * 
 */
package com.mazhar.urlshortner.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mazhar
 *
 * Mar 29, 2021
 */
@Configuration
public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      modelMapper.getConfiguration().setAmbiguityIgnored(true);
	      return modelMapper;
	   }
}
