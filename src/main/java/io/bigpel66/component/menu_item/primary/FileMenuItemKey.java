package io.bigpel66.component.menu_item.primary;

public enum FileMenuItemKey {

    NEW("New"),
    OPEN("Open"),
    SAVE("Save"),
    ;

    private final Object value;

    <T> FileMenuItemKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}