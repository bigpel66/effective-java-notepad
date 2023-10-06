package io.bigpel66.component.menu_bar;

import io.bigpel66.Notepad;

import javax.swing.*;

public class AbstractMenuBar extends JMenuBar {

    protected AbstractMenuBar(final Notepad context) {
        context.add(this);
        context.setJMenuBar(this);
    }

}
