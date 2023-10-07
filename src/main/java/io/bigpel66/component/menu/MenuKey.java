package io.bigpel66.component.menu;

public enum MenuKey {

    FILE("File"),
    EDIT("Edit"),
    FORMAT("Format"),
    HELP("Help"),
    ;

    private final Object value;

    <T> MenuKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}