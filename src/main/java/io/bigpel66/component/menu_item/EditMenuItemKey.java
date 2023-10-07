package io.bigpel66.component.menu_item;

public enum EditMenuItemKey {

    CUT("Cut"),
    COPY("Copy"),
    PASTE("Paste"),
    SELECT_ALL("Select All"),
    ;

    private final Object value;


    <T> EditMenuItemKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}