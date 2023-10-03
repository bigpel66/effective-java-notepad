package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class MenuBar extends JMenuBar {

    private final FileMenu fileMenu;

    private final EditMenu editMenu;

    private final FormatMenu formatMenu;

    private final HelpMenu helpMenu;

    public static MenuBar newInstance(final Notepad context) {
        return new MenuBar(context);
    }

    private MenuBar(final Notepad context) {
        context.add(this);
        context.setJMenuBar(this);
        fileMenu = FileMenu.newInstance(context);
        editMenu = EditMenu.newInstance(context);
        formatMenu = FormatMenu.newInstance(context);
        helpMenu = HelpMenu.newInstance(context);
        add(fileMenu);
        add(editMenu);
        add(formatMenu);
        add(helpMenu);
    }

}
