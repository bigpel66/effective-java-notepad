package io.bigpel66.config;

import java.util.HashSet;
import java.util.Set;

public enum ConfigKey {

    X_POS(0),
    Y_POS(0),
    WIDTH(300),
    HEIGHT(300),
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
