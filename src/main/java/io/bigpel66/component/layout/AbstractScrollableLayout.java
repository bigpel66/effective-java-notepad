package io.bigpel66.component.layout;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;
import java.awt.*;

public class AbstractScrollableLayout extends JScrollPane implements Component {

    private final Notepad context;

    public static void registerTo(final Notepad context, final Component child) {
        new AbstractScrollableLayout(context, child);
    }

    protected AbstractScrollableLayout(final Notepad context, final Component child) {
        super(child.getJComponent());
        this.context = context;
        Container container = context.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(this);
    }

    @Override
    public Notepad getContext() {
        return context;
    }

    @Override
    public JComponent getJComponent() {
        return this;
    }

}