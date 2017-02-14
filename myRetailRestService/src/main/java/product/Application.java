package product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Uses an Application class to provide an easy bind for @SpringBootApplication
 * @author Robert Amundson

 */
		
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersistedPriceRepository repository;
	
	private final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
	@Override
	public void run(String... args) throws Exception {
		//For testing purposes a clean repository
		repository.deleteAll();
		//Initial test data
		repository.save(new PersistedPrice("13860428", 29.99, "USD"));
		repository.save(new PersistedPrice("15117729", 49.99, "USD"));
		
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (PersistedPrice persistedPrice : repository.findAll()) {
			System.out.println(persistedPrice);
		}
		log.info("********************************");
		log.info(repository.findOne("13860428").toString());
		log.info("********************************");
		
	}
}