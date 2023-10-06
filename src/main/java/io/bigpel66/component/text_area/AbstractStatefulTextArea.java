package io.bigpel66.component.text_area;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Objects;

public class AbstractStatefulTextArea extends JTextArea implements Component {

    private final Notepad context;

    public static AbstractStatefulTextArea newInstance(final Notepad context) {
        return new AbstractStatefulTextArea(context);
    }

    protected AbstractStatefulTextArea(final Notepad context) {
        super(context.getStateTracker().getContents());
        this.context = context;
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                StateTracker stateTracker = context.getStateTracker();
                int newHash = Objects.hash(getText());
                if (newHash != stateTracker.getHash()) {
                    stateTracker.setHash(newHash);
                    stateTracker.setContents(getText());
                }
            }

        });
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