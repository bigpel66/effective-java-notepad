package io.bigpel66.component.menu.primary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.*;
import io.bigpel66.component.menu.secondary.BackgroundColorMenu;
import io.bigpel66.component.menu.secondary.FontColorMenu;
import io.bigpel66.component.menu.secondary.FontSizeMenu;
import io.bigpel66.component.menu.secondary.FontStyleMenu;

import static io.bigpel66.component.menu.primary.MenuKey.FORMAT;

public final class FormatMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FormatMenu(context, parent);
    }

    private FormatMenu(final Notepad context, final Component parent) {
        super(context, parent, FORMAT.getValue());
        FontStyleMenu.registerTo(context, this);
        FontSizeMenu.registerTo(context, this);
        FontColorMenu.registerTo(context, this);
        BackgroundColorMenu.registerTo(context, this);
    }

    @Override
    public String toString() {
        return "Name : FormatMenu\n" +
                "Title : " + FORMAT.getValue() + "\n" +
                "Index : " + FORMAT.ordinal();
    }

}