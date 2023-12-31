package io.bigpel66.component.menu_item;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Optional;

public class AbstractMenuItem extends JMenuItem implements Component {

    private final Notepad context;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String title;

        private Notepad context;

        private Component parent;

        private ActionListener actionListener;

        private KeyStroke keyStroke;

        private Builder() {
        }

        public Builder title(final String v) {
            title = v;
            return this;
        }

        public Builder context(final Notepad v) {
            context = v;
            return this;
        }

        public Builder parent(final Component v) {
            parent = v;
            return this;
        }

        public Builder actionListener(final ActionListener v) {
            actionListener = v;
            return this;
        }

        public Builder keyStroke(final KeyStroke v) {
            keyStroke = v;
            return this;
        }

        public void build() {
            new AbstractMenuItem(this);
        }

    }

    private AbstractMenuItem(final Builder builder) {
        super(Optional.of(builder.title).orElse("?"));
        this.context = builder.context;
        Optional.ofNullable(builder.parent).ifPresent(e -> e.getJComponent().add(this));
        Optional.ofNullable(builder.context).ifPresent(this::addActionListener);
        Optional.ofNullable(builder.actionListener).ifPresent(this::addActionListener);
        Optional.ofNullable(builder.keyStroke).ifPresent(this::setAccelerator);
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