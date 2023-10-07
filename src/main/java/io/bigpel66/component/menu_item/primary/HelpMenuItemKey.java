package io.bigpel66.component.menu_item.primary;

public enum HelpMenuItemKey {

    ABOUT("About");

    private final Object value;

    <T> HelpMenuItemKey(final T v) {
        value = v;
    }

    public <T> T getValue() {
        @SuppressWarnings("unchecked")
        T v = (T) value;
        return v;
    }

}