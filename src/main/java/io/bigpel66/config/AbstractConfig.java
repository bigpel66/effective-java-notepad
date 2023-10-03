package io.bigpel66.config;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

import static io.bigpel66.utility.DynamicTypeParser.toInt;
import static io.bigpel66.config.ConfigKey.*;

public class AbstractConfig implements Config {

    private final Point location;

    private final Dimension size;

    private final String title;

    public static AbstractConfig of(final Map<ConfigKey, Object> configMap) {
        Objects.requireNonNull(configMap);
        return new AbstractConfig(configMap);
    }

    protected AbstractConfig(final Map<ConfigKey, Object> configMap) {
        location = new Point(toInt(configMap.getOrDefault(X_POS, X_POS.getValue())), toInt(configMap.getOrDefault(Y_POS, Y_POS.getValue())));
        size = new Dimension(toInt(configMap.getOrDefault(WIDTH, WIDTH.getValue())), toInt(configMap.getOrDefault(HEIGHT, HEIGHT.getValue())));
        title = configMap.getOrDefault(TITLE, TITLE.getValue()).toString();
    }

    @Override
    public Point getLocation() {
        return location;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
