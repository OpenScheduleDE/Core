package de.openschedule.core.config;

public enum ConfigKey {

    SCHOOL_NAME("Musterschule"),
    SCHOOL_ADDRESS,
    SCHOOL_WEBSITE;

    public Object defaultValue;

    ConfigKey() {
    }

    ConfigKey(Object defaultValue) {
        this.defaultValue = defaultValue;
    }
}
