package io.bigpel66.config;

import java.awt.*;

import static io.bigpel66.config.ConfigKey.*;

public class DefaultConfig implements Config {

    private static final DefaultConfig DEFAULT_CONFIG = new DefaultConfig();

    private final Point position;

    private final Dimension size;

    public static DefaultConfig getInstance() {
        return DEFAULT_CONFIG;
    }

    private DefaultConfig() {
        position = new Point(X_POS.getValue(), Y_POS.getValue());
        size = new Dimension(WIDTH.getValue(), HEIGHT.getValue());
    }

    @Override
    public Point getLocation() {
        return position;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

}
