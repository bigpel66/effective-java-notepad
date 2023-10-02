package io.bigpel66;

import io.bigpel66.config.Config;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public final class Notepad extends JFrame implements ActionListener {

    private final Config config;

    private final StateTracker tracker;

    public static Notepad newInstance(Config givenConfig) {
        return new Notepad(givenConfig);
    }

    private Notepad(Config givenConfig) {
        config = givenConfig;
        tracker = StateTracker
                .builder()
                .location(config.getLocation())
                .size(config.getSize())
                .title(config.getTitle())
                .build();
        setContext();
        setVisible(true);
        setState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void setContext() {
        setSize(config.getSize());
        setLocation(config.getLocation());
        setTitle(config.getTitle());
    }

    private void setState() {
        this.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(Notepad.this.getSize());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                System.out.println(Notepad.this.getLocationOnScreen());
            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }

        });
    }

}
