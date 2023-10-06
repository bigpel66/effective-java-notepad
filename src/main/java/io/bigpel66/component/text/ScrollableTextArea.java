package io.bigpel66.component.text;

import io.bigpel66.Notepad;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Objects;

public final class ScrollableTextArea extends JScrollPane {

    public static void registerTo(final Notepad context) {
        new ScrollableTextArea(context);
    }

    private ScrollableTextArea(final Notepad context) {
        super(new JTextArea(context.getStateTracker().getContents()));
        Container container = context.getContentPane();
        container.setLayout(new BorderLayout());
        JTextArea textArea = (JTextArea) getViewport().getView();
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
        container.add(this);
    }

}
