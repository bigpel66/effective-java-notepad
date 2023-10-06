package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Optional;

public final class AbstractMenuItem extends JMenuItem {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String title;

        private Integer index;

        private Notepad context;

        private ActionListener actionListener;

        private KeyStroke keyStroke;

        private Builder() {
        }

        public Builder title(final String v) {
            title = v;
            return this;
        }

        public Builder index(final Integer v) {
            index = v;
            return this;
        }

        public Builder context(final Notepad v) {
            context = v;
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
        Optional.ofNullable(builder.index).ifPresent(e -> builder.context.getJMenuBar().getMenu(e).add(this));
        Optional.ofNullable(builder.context).ifPresent(this::addActionListener);
        Optional.ofNullable(builder.actionListener).ifPresent(this::addActionListener);
        Optional.ofNullable(builder.keyStroke).ifPresent(this::setAccelerator);
    }

}
