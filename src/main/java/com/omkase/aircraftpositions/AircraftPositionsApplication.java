package com.omkase.aircraftpositions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;


@SpringBootApplication
@ConfigurationPropertiesScan
public class AircraftPositionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AircraftPositionsApplication.class, args);

	
	}
	@Bean
	@ConfigurationProperties(prefix =  "airport")
	AirportProperties airportProperties()
	{
		return new AirportProperties();
	}

}

@RestController
@RequestMapping("/aircraft")
@AllArgsConstructor
class AircraftController {
/* 
	@Value("${aircraft.reg:N99999}")
	private String reg;

	@Value("${aircraft.reg}")
	private String type;
 */
	private final AircraftProperties acProperties;
	private final AirportProperties apProperties;
	

	@GetMapping("/reg")
	public String getRegistration()
	{
		return acProperties.getReg();
		
	}

	@GetMapping("/type")
	public String getType()
	{
		return acProperties.getType();

	}

	@GetMapping(value="/airport")
	public String getMethodName() {
		return apProperties.getIacoCode() + " " + apProperties.getName();
	}
	

	
	
}




@Data
class AirportProperties {
	private String iacoCode,name;


}

@Data
@ConfigurationProperties(prefix = "aircraft")
 class AircraftProperties {
	 private String reg, type;
}
