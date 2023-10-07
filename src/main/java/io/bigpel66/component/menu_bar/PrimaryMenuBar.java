package io.bigpel66.component.menu_bar;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu.primary.EditMenu;
import io.bigpel66.component.menu.primary.FileMenu;
import io.bigpel66.component.menu.primary.FormatMenu;
import io.bigpel66.component.menu.primary.HelpMenu;

public final class PrimaryMenuBar extends AbstractMenuBar {

    public static void registerTo(final Notepad context) {
        new PrimaryMenuBar(context);
    }

    private PrimaryMenuBar(final Notepad context) {
        super(context);
        FileMenu.registerTo(context, this);
        EditMenu.registerTo(context, this);
        FormatMenu.registerTo(context, this);
        HelpMenu.registerTo(context, this);
    }

    @Override
    public String toString() {
        return "Name : PrimaryMenuBar";
    }

}