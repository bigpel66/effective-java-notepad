package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;
import java.util.Optional;

public class AbstractMenu extends JMenu implements Component {

    private final Notepad context;

    protected AbstractMenu(final Notepad context, final Component parent, final String title) {
        super(title);
        this.context = context;
        Optional.ofNullable(parent).ifPresent(e -> e.getJComponent().add(this));
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