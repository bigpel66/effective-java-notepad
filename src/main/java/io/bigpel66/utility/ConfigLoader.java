package io.bigpel66.utility;

import io.bigpel66.config.AbstractConfig;
import io.bigpel66.config.Config;
import io.bigpel66.config.ConfigKey;
import io.bigpel66.config.DefaultConfig;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class ConfigLoader {

    private static final String homeDirectoryName = System.getProperty("user.home");

    private static final String configDirectoryName = "Desktop";

    private static final String configFileName = ".notepad.config";

    private static final Path configDirectoryPath = Paths.get(homeDirectoryName, configDirectoryName);

    private static final Path configFilePath = Paths.get(homeDirectoryName, configDirectoryName, configFileName);

    public static Config load(boolean isForcedDefault) {
        if (!isForcedDefault && configExists()) {
            Map<ConfigKey, Object> configMap = parseConfig();
            return AbstractConfig.of(configMap);
        }
        createConfig();
        fillDefaultConfig();
        return DefaultConfig.getInstance();
    }

    public static void save(final StateTracker tracker) {
        String replaced = tracker.getContents()
                .replaceAll("\\n", "\\\\n")
                .replaceAll("\\f", "\\\\f");
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(configFilePath.toString(), false))) {
            sb.append(ConfigKey.X_POS.name()).append(" : ").append(tracker.getLocation().getX()).append("\n");
            sb.append(ConfigKey.Y_POS.name()).append(" : ").append(tracker.getLocation().getY()).append("\n");
            sb.append(ConfigKey.WIDTH.name()).append(" : ").append(tracker.getSize().getWidth()).append("\n");
            sb.append(ConfigKey.HEIGHT.name()).append(" : ").append(tracker.getSize().getHeight()).append("\n");
            sb.append(ConfigKey.TITLE.name()).append(" : ").append(tracker.getTitle()).append("\n");
            sb.append(ConfigKey.CONTENTS.name()).append(" : ").append(replaced).append("\n");
            sb.append(ConfigKey.HASH.name()).append(" : ").append(tracker.getHash()).append("\n");
            sb.append(ConfigKey.IS_CONTENTS_SAVED.name()).append(" : ").append(tracker.isContentsSaved()).append("\n");
            bw.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("default config field cannot be written");
        }
    }

    private static boolean configExists() {
        File configFile = new File(configFilePath.toString());
        return configFile.exists();
    }

    private static Map<ConfigKey, Object> parseConfig() {
        Map<ConfigKey, Object> configMap = new HashMap<>();
        File configFile = new File(configFilePath.toString());
        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(":");
                if (isConfigFieldInvalid(tokens)) {
                    continue;
                }
                tokens[0] = tokens[0].trim();
                tokens[1] = tokens[1]
                        .trim()
                        .replaceAll("\\\\n", "\n")
                        .replaceAll("\\\\f", "\f");
                configMap.put(ConfigKey.valueOf(tokens[0]), DynamicTypeParser.parse(tokens[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException("config file cannot be read");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("config field cannot be interpreted");
        }
        return configMap;
    }

    private static boolean isConfigFieldInvalid(final String[] tokens) {
        return tokens == null || tokens.length != 2;
    }

    private static void createConfig() {
        File configDirectory = new File(configDirectoryPath.toString());
        if (!configDirectory.exists() && configDirectory.mkdirs()) {
            throw new RuntimeException("config directory cannot be created");
        }
        File configFile = new File(configFilePath.toString());
        try {
            configFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("config file cannot be created");
        }
    }

    private static void fillDefaultConfig() {
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(configFilePath.toString()))) {
            ConfigKey[] values = ConfigKey.values();
            for (ConfigKey value : values) {
                sb.append(value.name()).append(" : ").append(value.getValue().toString());
                sb.append("\n");
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException("default config field cannot be written");
        }
    }

}
