package br.com.geoged.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:geoged.properties")
public class PropertiesUtil implements EnvironmentAware
{
	private Environment environment = null;

	@Override
   public void setEnvironment(final Environment environment) {
       this.environment = environment;
   }

   public  String load(String propertyName)
   {
       return environment.getRequiredProperty(propertyName);
   }


}
