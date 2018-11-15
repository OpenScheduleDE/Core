package de.openschedule.core.config;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository extends MongoRepository<ConfigEntry, String> {

    Optional<ConfigEntry> findByKey(ConfigKey key);

    List<ConfigEntry> findByKeyIn(Sort sort, List<ConfigKey> key);
}
