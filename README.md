# spring-boot-features-1

This repo contains code that laverages Spring boot fetaures to perform common tasks

Things it contains
1. Working with property files
2. Actuators
3. Create a docker image of springboot app

## Working with Property files
We can read props from property files using SPEL. But this aproach is not very clean and we can not use type checking. 
The better way would be to use Class and map the props from property file to the attributes of the class. This way we
can use getters to get the props from property file.

```
@Data
@ConfigurationProperties(prefix = "aircraft")
 class AircraftProperties {
	 private String reg, type;
}
```

## Create a docker image of springboot app
We can create a docker image out of the spring-boot by using Spring-boot:build-image plugin

```
<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>
							hecklerm/${project.artifactId}
						</name>

					</image>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
 ```
