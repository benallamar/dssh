package com.bbles.automator.node.kernel.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    private Config config;

    private Configuration(Config config) {
        this.config = config;
    }

    public Configuration(String path) {
        this(ConfigFactory.load(path));
    }

    public Configuration() {
        this(ConfigFactory.load());
    }

    public <T> T get(String key, T defaultValue) {
        try {
            if (defaultValue.toString().matches("\\d+")) {
                config.getInt(key);
            } else if (defaultValue instanceof String) {
                config.getString(key);
            } else {
                throw new IllegalArgumentException("Undefined type of : " + defaultValue.getClass().getCanonicalName());
            }
        } finally {
            return defaultValue;
        }
    }


}
