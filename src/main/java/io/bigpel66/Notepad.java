package io.bigpel66;

import io.bigpel66.component.menu.MenuBar;
import io.bigpel66.component.text.ScrollableTextArea;
import io.bigpel66.config.Config;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        setMenuBarLayout();
        setTextAreaLayout();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setMenuBarLayout() {
        MenuBar.newInstance(this);
    }

    private void setTextAreaLayout() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        ScrollableTextArea.newInstance(contentPane);
    }

    private void setState() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO :: SAVE FILE QUESTION
                // TODO :: STATE TO CONFIG
                System.out.println("closing...");
            }
        });
        addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                // TODO :: CHANGE STATE
                System.out.println(Notepad.this.getSize());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // TODO :: CHANGE STATE
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
