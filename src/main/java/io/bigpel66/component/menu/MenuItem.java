package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class MenuItem extends JMenuItem {

    private final String title;

    public static MenuItem newInstance(Notepad context, String title) {
        return new MenuItem(context, title);
    }

    private MenuItem(Notepad context, String title) {
        super(title);
        this.title = title;
        addActionListener(context);
    }

    public String getTitle() {
        return title;
    }

}
