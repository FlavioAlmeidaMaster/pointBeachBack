package br.com.pointBeach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.pointBeach" })
public class PointBeachApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointBeachApplication.class, args);
	}
}
