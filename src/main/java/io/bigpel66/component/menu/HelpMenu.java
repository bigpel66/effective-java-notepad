package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class HelpMenu extends JMenu {

    private static final String TITLE = "Help";

    private final MenuItem aboutItem;

    public static HelpMenu newInstance(final Notepad context) {
        return new HelpMenu(context);
    }

    private HelpMenu(final Notepad context) {
        super(TITLE);
        aboutItem = MenuItem.newInstance(context, "About");
        add(aboutItem);
    }

    public MenuItem getAboutItem() {
        return aboutItem;
    }

}
