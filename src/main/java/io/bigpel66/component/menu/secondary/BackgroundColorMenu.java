package io.bigpel66.component.menu.secondary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;

import static io.bigpel66.component.menu_item.primary.FormatMenuItemKey.BACKGROUND_COLOR;

public class BackgroundColorMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new BackgroundColorMenu(context, parent);
    }

    private BackgroundColorMenu(final Notepad context, final Component parent) {
        super(context, parent, BACKGROUND_COLOR.getValue());
    }

}