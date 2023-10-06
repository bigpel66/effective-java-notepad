package io.bigpel66.component.menu_bar;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu.EditMenu;
import io.bigpel66.component.menu.FileMenu;
import io.bigpel66.component.menu.FormatMenu;
import io.bigpel66.component.menu.HelpMenu;

public final class PrimaryMenuBar extends AbstractMenuBar {

    public static void registerTo(final Notepad context) {
        new PrimaryMenuBar(context);
    }

    private PrimaryMenuBar(final Notepad context) {
        super(context);
        FileMenu.registerTo(context);
        EditMenu.registerTo(context);
        FormatMenu.registerTo(context);
        HelpMenu.registerTo(context);
    }

    @Override
    public String toString() {
        return "Name : PrimaryMenuBar";
    }

}
