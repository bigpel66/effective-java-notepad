package io.bigpel66.component.text;

import javax.swing.*;
import java.awt.*;

public final class ScrollableTextArea extends JScrollPane {

    private final JTextArea textArea;

    public static ScrollableTextArea newInstance(final Container container) {
        return new ScrollableTextArea(container, new JTextArea());
    }

    private ScrollableTextArea(final Container container, final JTextArea textArea) {
        super(textArea);
        this.textArea = textArea;
        container.add(this);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
