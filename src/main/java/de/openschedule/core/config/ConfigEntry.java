package de.openschedule.core.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigEntry {

    @Id
    public String id;

    public String key;
    public Object value;

    public ConfigEntry() {
    }

    public ConfigEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("ConfigEntry[id=%s, key='%s', value='%s']", this.id, this.key, this.value.toString());
    }

}
