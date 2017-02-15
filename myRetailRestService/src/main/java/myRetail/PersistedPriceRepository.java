package myRetail;

import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * Repository for easy linkage between the jvm and mongodb.
 * @author Robert Amundson
 *
 */
public interface PersistedPriceRepository extends MongoRepository<PersistedPrice,String> {

public PersistedPrice findByCurrencyCode(String currencyCode);
}
