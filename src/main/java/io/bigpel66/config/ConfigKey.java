package io.bigpel66.config;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public enum ConfigKey {

    X_POS(0),
    Y_POS(0),
    WIDTH(300),
    HEIGHT(300),
    TITLE("New File"),
    CONTENTS(""),
    HASH(Objects.hash("")),
    FONT_NAME(UIManager.getFont("Label.font").getFontName()),
    FONT_SIZE(UIManager.getFont("Label.font").getSize()),
    FONT_COLOR(Color.BLACK.getRGB()),
    BACKGROUND_COLOR(Color.WHITE.getRGB()),
    IS_CONTENTS_SAVED("true"),
    ;

    private final Object value;

    public static final Set<String> CONFIG = new HashSet<>() {{
        ConfigKey[] values = ConfigKey.values();
        for (ConfigKey value : values) {
            add(value.name());
        }
    }};

    <T> ConfigKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}