package de.openschedule.core.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigEntry {

    @Id
    public String id;

    @Indexed(unique = true)
    public ConfigKey key;
    public Object value;
    public int ordinal;

    public ConfigEntry(ConfigKey key, Object value) {
        this.key = key;
        this.value = value;
        this.ordinal = key.ordinal();
    }

    public ConfigEntry setValue(Object value) {
        this.value = value;

        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "ConfigEntry[id=%s, key='%s', value='%s', ordinal=%d]",
                this.id, this.key, this.value.toString(), this.ordinal
        );
    }
}
