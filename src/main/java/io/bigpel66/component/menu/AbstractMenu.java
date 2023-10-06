package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;

public class AbstractMenu extends JMenu implements Component {

    private final Notepad context;

    protected AbstractMenu(final Notepad context, final String title) {
        super(title);
        this.context = context;
        context.getJMenuBar().add(this);
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