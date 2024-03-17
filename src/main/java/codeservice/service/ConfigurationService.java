package codeservice.service;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationService {
    private Map<String, String> configuration;

    public ConfigurationService() {
        this.configuration = new HashMap<>();
    }

    public void loadConfiguration() {
        configuration.put("filePath", "/path/to/files");
    }

    public void updateConfiguration(String key, String value) {
        configuration.put(key, value);
    }

    public String getConfigurationValue(String key) {
        return configuration.get(key);
    }
}
