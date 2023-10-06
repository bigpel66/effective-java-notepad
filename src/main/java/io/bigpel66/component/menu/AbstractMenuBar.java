package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class AbstractMenuBar extends JMenuBar {

    public static AbstractMenuBar newInstance(final Notepad context) {
        return new AbstractMenuBar(context);
    }

    private AbstractMenuBar(final Notepad context) {
        context.add(this);
        context.setJMenuBar(this);
        FileMenu.registerTo(context);
        EditMenu.registerTo(context);
        FormatMenu.registerTo(context);
        HelpMenu.registerTo(context);
    }

}
