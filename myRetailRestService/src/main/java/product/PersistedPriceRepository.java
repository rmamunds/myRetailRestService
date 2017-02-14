package product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersistedPriceRepository extends MongoRepository<PersistedPrice,String> {

	public PersistedPrice findByCurrencyCode(String currencyCode);
}
