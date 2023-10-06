package io.bigpel66;

import io.bigpel66.component.menu.AbstractMenuBar;
import io.bigpel66.component.text.ScrollableTextArea;
import io.bigpel66.config.Config;
import io.bigpel66.utility.ConfigLoader;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import java.awt.event.*;

public final class Notepad extends JFrame implements ActionListener {

    private final Config config;

    private final StateTracker tracker;

    public static Notepad newInstance(final Config config) {
        return new Notepad(config);
    }

    private Notepad(final Config config) {
        this.config = config;
        tracker = StateTracker
                .builder()
                .location(this.config.getLocation())
                .size(this.config.getSize())
                .title(this.config.getTitle())
                .contents(this.config.getContents())
                .hash(this.config.getHash())
                .build();
        setContext();
        setVisible(true);
        setState();
        new Timer(1000, e -> ConfigLoader.save(tracker)).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO :: EVENT AND KEY STROKE
    }

    private void setContext() {
        setSize(config.getSize());
        setLocation(config.getLocation());
        setTitle(config.getTitle());
        setMenuBarLayout();
        setTextAreaLayout();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setMenuBarLayout() {
        AbstractMenuBar.newInstance(this);
    }

    private void setTextAreaLayout() {
        ScrollableTextArea.newInstance(this);
    }

    private void setState() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConfigLoader.save(tracker);
                // TODO :: SAVE FILE QUESTION -> Non Saved Dialog or Close
            }
        });
        addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                tracker.setSize(Notepad.this.getSize());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                tracker.setLocation(Notepad.this.getLocation());
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }

        });
    }

    public StateTracker getStateTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Notepad.newInstance(ConfigLoader.load());
    }

}