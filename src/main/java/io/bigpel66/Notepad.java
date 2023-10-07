package io.bigpel66;


import com.apple.eawt.Application;
import io.bigpel66.component.layout.AbstractScrollableLayout;
import io.bigpel66.component.menu_bar.PrimaryMenuBar;
import io.bigpel66.component.text_area.AbstractStatefulTextArea;
import io.bigpel66.config.Config;
import io.bigpel66.utility.ConfigLoader;
import io.bigpel66.utility.StateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static io.bigpel66.component.menu.MenuKey.FILE;
import static io.bigpel66.component.menu_item.FileMenuItemKey.SAVE;

public final class Notepad extends JFrame implements ActionListener {

    private final Config config;

    private final StateTracker tracker;

    private final Timer timer;

    public static void execute(final Config config) {
        new Notepad(config);
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
                .isContentsSaved(this.config.isContentsSaved())
                .isHelpOpened(false)
                .build();
        setContext();
        setVisible(true);
        setState();
        timer = new Timer(1000, e -> ConfigLoader.save(tracker));
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void setContext() {
        Image image = new ImageIcon(ClassLoader.getSystemResource("icon.png")).getImage();
        try {
            Application.getApplication().setDockIconImage(image);
        } catch (Throwable throwable) {
        }
        setIconImage(image);
        setSize(config.getSize());
        setLocation(config.getLocation());
        setTitle(config.getTitle());
        setMenuBarLayout();
        setTextAreaLayout();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void setMenuBarLayout() {
        PrimaryMenuBar.registerTo(this);
    }

    private void setTextAreaLayout() {
        AbstractScrollableLayout.registerTo(AbstractStatefulTextArea.newInstance(this));
    }

    private void setState() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timer.stop();
                if (tracker.isContentsSaved()) {
                    dispose();
                    return;
                }
                int option = JOptionPane.showConfirmDialog(
                        Notepad.this,
                        "Do you want to save the changes?",
                        "Save Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (option == JOptionPane.NO_OPTION) {
                    ConfigLoader.removeConfig();
                    dispose();
                } else if (option == JOptionPane.YES_NO_OPTION) {
                    getJMenuBar().getMenu(FILE.ordinal()).getItem(SAVE.ordinal()).doClick();
                    ConfigLoader.save(tracker);
                    dispose();
                } else {
                    timer.start();
                }
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

    public JTextArea getJTextArea() {
        for (Component component : getContentPane().getComponents()) {
            if (!(component instanceof JScrollPane)) {
                continue;
            }
            return (AbstractStatefulTextArea) ((JScrollPane) component).getViewport().getView();
        }
        return null;
    }

    public static void main(String[] args) {
        Notepad.execute(ConfigLoader.load(false));
    }

}