package io.bigpel66.component.menu.secondary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;

import static io.bigpel66.component.menu.secondary.FormatMenuKey.FONT_SIZE;

public final class FontSizeMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FontSizeMenu(context, parent);
    }

    private FontSizeMenu(final Notepad context, final Component parent) {
        super(context, parent, FONT_SIZE.getValue());
    }

}