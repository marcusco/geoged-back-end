package br.com.geoged;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
public class GeogedApplication extends SpringBootServletInitializer implements WebApplicationInitializer
{
	public static void main(String[] args)
	{
		SpringApplication.run(GeogedApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(GeogedApplication.class);
	}
}
