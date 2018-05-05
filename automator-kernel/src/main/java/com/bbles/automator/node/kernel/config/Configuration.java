package com.bbles.automator.node.kernel.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration implements Config {

    /**
     * Return the default configuration for a given node.
     *
     * @param className
     * @return
     */
    public static Configuration getDefaultConfigurationByName(String className) {
        return (Configuration) ConfigFactory.load(className);
    }

    public static Configuration getInstance() {
        return (Configuration) ConfigFactory.defaultApplication();
    }

    public int get(String key, int defaultValue) {
        try {
            getInt(key);
        } finally {
            return defaultValue;
        }
    }

    public String get(String key, String defaultValue) {
        try {
            getString(key);
        } finally {
            return defaultValue;
        }
    }

    @Override
    public Config atPath(String s) {
        return null;
    }
}
