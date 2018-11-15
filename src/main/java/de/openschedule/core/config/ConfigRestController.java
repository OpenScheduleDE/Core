package de.openschedule.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/config")
public class ConfigRestController {

    private final ConfigService service;

    @Autowired
    public ConfigRestController(final ConfigService service) {
        this.service = service;
    }

    @RequestMapping("/all")
    public List<ConfigEntry> listAllConfigEntries() {
        return service.getAllEntries();
    }

    @RequestMapping("/add")
    public ConfigEntry addEntry() {
        return service.setEntry(ConfigKey.SCHOOL_WEBSITE, "https://www.example.org/");
    }

    @RequestMapping("/address")
    public ConfigEntry getAddress() {
        return service.getEntry(ConfigKey.SCHOOL_ADDRESS);
    }

    @RequestMapping("/{key}")
    public ConfigEntry getConfigEntryByKey(@PathVariable ConfigKey key) {
        return service.getEntry(key);
    }
}
