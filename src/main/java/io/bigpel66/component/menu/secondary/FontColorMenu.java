package io.bigpel66.component.menu.secondary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;

import static io.bigpel66.component.menu_item.primary.FormatMenuItemKey.FONT_COLOR;

public class FontColorMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FontColorMenu(context, parent);
    }

    private FontColorMenu(final Notepad context, final Component parent) {
        super(context, parent, FONT_COLOR.getValue());
    }

}