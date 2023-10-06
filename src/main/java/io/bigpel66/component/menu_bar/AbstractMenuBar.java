package io.bigpel66.component.menu_bar;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;

public class AbstractMenuBar extends JMenuBar implements Component {

    private final Notepad context;

    protected AbstractMenuBar(final Notepad context) {
        this.context = context;
        context.add(this);
        context.setJMenuBar(this);
    }

    @Override
    public Notepad getContext() {
        return context;
    }

    @Override
    public java.awt.Component getJComponent() {
        return this;
    }

}