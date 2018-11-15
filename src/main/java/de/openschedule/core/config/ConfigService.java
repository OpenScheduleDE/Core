package de.openschedule.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigService {

    private final ConfigRepository repository;

    @Autowired
    public ConfigService(ConfigRepository repository) {
        this.repository = repository;
    }

    List<ConfigEntry> listSomeEntries() {
        List<ConfigKey> list = new ArrayList<>();

        list.add(ConfigKey.SCHOOL_NAME);

        return repository.findByKeyIn(new Sort(Sort.Direction.ASC, "ordinal"), list);
    }

    List<ConfigEntry> getAllEntries() {
        return repository.findAll();
    }

    ConfigEntry getEntry(ConfigKey key) {
        return repository.findByKey(key).orElse(new ConfigEntry(key, key.defaultValue));
    }

    ConfigEntry setEntry(ConfigKey key, Object value) {
        return repository.save(this.getEntry(key).setValue(value));
    }
}
