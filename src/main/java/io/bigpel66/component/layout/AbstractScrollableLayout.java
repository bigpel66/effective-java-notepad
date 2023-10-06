package io.bigpel66.component.layout;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;
import java.awt.*;

public class AbstractScrollableLayout extends JScrollPane implements Component {

    private final Notepad context;

    public static void registerTo(final Component component) {
        new AbstractScrollableLayout(component);
    }

    protected AbstractScrollableLayout(final Component component) {
        super(component.getJComponent());
        context = component.getContext();
        Container container = context.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(this);
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