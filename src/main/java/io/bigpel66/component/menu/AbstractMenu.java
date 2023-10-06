package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public class AbstractMenu extends JMenu {

    protected AbstractMenu(final Notepad context, final String title) {
        super(title);
        context.getJMenuBar().add(this);
    }

}
