package io.bigpel66;

import io.bigpel66.config.AbstractConfig;
import io.bigpel66.config.Config;
import io.bigpel66.config.ConfigKey;
import io.bigpel66.config.DefaultConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;
import java.util.Objects;

public class ConfigLoader {

    private static final String homeDirectoryName = System.getProperty("user.home");

    private static final String configDirectoryName = "Desktop";

    private static final String configFileName = ".notepad.config";

    private static final Path configDirectoryPath = Paths.get(homeDirectoryName, configDirectoryName);

    private static final Path configFilePath = Paths.get(homeDirectoryName, configDirectoryName, configFileName);

    public static Config load() {
        if (configExists()) {
            Map<ConfigKey, Object> configMap = parseConfig(configFilePath);
            return AbstractConfig.of(configMap);
        }
        createConfig();
        return DefaultConfig.newInstance();
    }

    private static boolean configExists() {
        File configFile = new File(configFilePath.toString());
        return configFile.exists();
    }

    private static Map<ConfigKey, Object> parseConfig(Path path) throws IllegalFormatException {
        Objects.requireNonNull(path);
        Map<ConfigKey, Object> configMap = new HashMap<>();
        File configFile = new File(path.toString());
        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            // TODO
        } catch (IOException e) {
            throw new RuntimeException("config file cannot be read");
        }
        return configMap;
    }

    private static void createConfig() {
        File configDirectory = new File(configDirectoryPath.toString());
        if (!configDirectory.exists() && configDirectory.mkdirs()) {
            throw new RuntimeException("config directory cannot be created");
        }
        File configFile = new File(configFilePath.toString());
        try {
            if (!configFile.createNewFile()) {
                throw new RuntimeException("config file cannot be created");
            }
        } catch (IOException e) {
            throw new RuntimeException("config file cannot be created");
        }
    }

}
