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
		if(args.length>0 && args[0].equalsIgnoreCase("sampleData")){
		//For testing purposes a clean repository
		log.info("Clearing existing data.");
		repository.deleteAll();
		//Initial test data
		log.info("Populating with sample data.");
		repository.save(new PersistedPrice("13860428", 29.99, "USD"));//lebowski
		repository.save(new PersistedPrice("16696652", 149.99, "USD"));//beats solo
		repository.save(new PersistedPrice("13860421", 2000.0, "YEN")); //Revolutionary girl utena
		log.info("Sample Data Created for: \n  13860428\n  16696652\n  13860421");
		log.info("Population finished.");
		
		
		}
	}
}