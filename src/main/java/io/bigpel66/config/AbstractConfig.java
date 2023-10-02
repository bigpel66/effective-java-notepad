package io.bigpel66.config;

import io.bigpel66.DynamicTypeParser;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

import static io.bigpel66.DynamicTypeParser.*;
import static io.bigpel66.config.ConfigKey.*;

public class AbstractConfig implements Config {

    private final Point position;

    private final Dimension size;

    public static AbstractConfig of(Map<ConfigKey, Object> configMap) {
        Objects.requireNonNull(configMap);
        return new AbstractConfig(configMap);
    }

    protected AbstractConfig(Map<ConfigKey, Object> configMap) {
        position = new Point(toInt(configMap.getOrDefault(X_POS, X_POS.getValue())), toInt(configMap.getOrDefault(Y_POS, Y_POS.getValue())));
        size = new Dimension(toInt(configMap.getOrDefault(WIDTH, WIDTH.getValue())), toInt(configMap.getOrDefault(HEIGHT, HEIGHT.getValue())));
    }

    @Override
    public Point getPoint() {
        return position;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

}
