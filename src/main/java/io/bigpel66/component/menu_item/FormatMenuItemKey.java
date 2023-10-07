package io.bigpel66.component.menu_item;

public enum FormatMenuItemKey {

    FONT_STYLE("Font Style"),
    FONT_SIZE("Font Size"),
    FONT_COLOR("Font Color"),
    BACKGROUND_COLOR("Background Color");

    private final Object value;

    <T> FormatMenuItemKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}