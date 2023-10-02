package io.bigpel66;

import io.bigpel66.config.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public final class Notepad extends JFrame implements ActionListener {

    private final Config config;


    public static Notepad newInstance(Config givenConfig) {
        return new Notepad(givenConfig);
    }

    private Notepad(Config givenConfig) {
        config = givenConfig;
        setSize(config.getSize());
        setLocation(config.getLocation());
        setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
