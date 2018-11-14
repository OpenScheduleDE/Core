package de.openschedule.core.config;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepository extends MongoRepository<ConfigEntry, String> {

    ConfigEntry findByKey(String key);

}
