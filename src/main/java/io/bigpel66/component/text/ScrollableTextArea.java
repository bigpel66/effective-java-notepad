package io.bigpel66.component.text;

import javax.swing.*;

public class ScrollableTextArea extends JScrollPane {

    private final JTextArea jTextArea;

    public static ScrollableTextArea newInstance() {
        return new ScrollableTextArea(new JTextArea());
    }

    private ScrollableTextArea(JTextArea v) {
        super(v);
        jTextArea = v;
    }

}
