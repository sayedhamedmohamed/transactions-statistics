package com.n26;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class Application.
 * @author sayedhamed
 */
@SpringBootApplication(scanBasePackages = { "com.n26" })
public class Application {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */

	public static void main(String... args) {

		Logger logger = LogManager.getLogger(Application.class);

		try {

			SpringApplication.run(Application.class, args);

			logger.info("Application has started successfully");

		} catch (Exception e) {

			logger.error("Error occured while starting application", e);
		}  
	}
}
