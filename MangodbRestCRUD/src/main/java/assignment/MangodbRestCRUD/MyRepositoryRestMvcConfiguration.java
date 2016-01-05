package assignment.MangodbRestCRUD;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {
	 private static final String MY_BASE_URI = "/restAPI";

	 @Override
	 protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	     config.setBasePath(MY_BASE_URI);
	 }
}
