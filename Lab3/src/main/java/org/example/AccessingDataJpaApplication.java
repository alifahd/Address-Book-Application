package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(BuddyInfoRepository repository) {
		return (args) -> {
			// save a few buddies to address book
			AddressBook book = new AddressBook();
			BuddyInfo buddy1 = new BuddyInfo("John Doe","123 Fake Street", 1234567890);
			BuddyInfo buddy2 = new BuddyInfo("Jane Doe","125 Other Street", 1876543212);
			book.addBuddy(buddy1);
			book.addBuddy(buddy2);

			repository.save(new BuddyInfo("John Doe","123 Fake Street", 1234567890));
			repository.save(new BuddyInfo("Jane Doe","125 Other Street", 1876543212));

			// fetch all buddies
			log.info("Buddies found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo buddy : repository.findAll()) {
				log.info(buddy.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			BuddyInfo buddy = repository.findById(1L);
			log.info("Buddies found with findById(1L):");
			log.info("--------------------------------");
			log.info(buddy.toString());
			log.info("");

			// fetch buddies by name
			log.info("Customer found with findByName('Jane Doe'):");
			log.info("--------------------------------------------");
			repository.findByName("Jane Doe").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}