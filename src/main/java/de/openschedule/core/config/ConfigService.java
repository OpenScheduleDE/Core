package de.openschedule.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    private final ConfigRepository repository;

    @Autowired
    public ConfigService(ConfigRepository repository) {
        this.repository = repository;
    }

    List<ConfigEntry> getAllEntries() {
        return repository.findAll();
    }

    ConfigEntry getEntry(String key) {
        return repository.findByKey(key);
    }

    ConfigEntry addEntry(ConfigKey key, Object value) {
        return repository.save(new ConfigEntry(key.toString(), value));
    }

    ConfigEntry addEntry(ConfigEntry entry) {
        return repository.save(entry);
    }
}
