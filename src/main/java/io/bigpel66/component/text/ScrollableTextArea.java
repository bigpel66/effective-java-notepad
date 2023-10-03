package io.bigpel66.component.text;

import io.bigpel66.Notepad;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Objects;

public final class ScrollableTextArea extends JScrollPane {

    private final JTextArea textArea;

    public static ScrollableTextArea newInstance(final Notepad context) {
        return new ScrollableTextArea(context, new JTextArea(context.getStateTracker().getContents()));
    }

    private ScrollableTextArea(final Notepad context, final JTextArea textArea) {
        super(textArea);
        Container container = context.getContentPane();
        container.setLayout(new BorderLayout());
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(textArea.getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(textArea.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(textArea.getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(textArea.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(textArea.getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(textArea.getText());
                }
            }
        });
        this.textArea = textArea;
        container.add(this);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
