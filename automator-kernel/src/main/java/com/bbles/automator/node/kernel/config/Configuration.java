package com.bbles.automator.node.kernel.config;

import com.typesafe.config.Config;

public class Configuration extends Config {
    @Override
    public Configuration getInstance() {
        new Configuration()
    }


    public <T> T get(String key, T defaultValue) {
        try {
            if (defaultValue instanceof int) {
                getInt(key);
            } else if (defaultValue instanceof String) {
                getString(key);
            } else {
                throw IllegalArgumentException;
            }
        } finally {
            return defaultValue;
        }
    }


}
