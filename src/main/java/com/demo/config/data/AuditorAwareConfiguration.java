package com.demo.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class AuditorAwareConfiguration {

	@Bean
	public AuditorAwareData auditorAwareData() throws Exception {
		return new AuditorAwareData();
	}

}
