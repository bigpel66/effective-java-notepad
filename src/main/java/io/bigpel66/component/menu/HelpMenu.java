package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.bigpel66.component.menu.MenuKey.HELP;
import static io.bigpel66.component.menu_item.HelpMenuItemKey.*;

public final class HelpMenu extends AbstractMenu {

    private final ActionListener helpConsumer = (e) -> {
        if (getContext().getStateTracker().isHelpOpened()) {
            return;
        }
        JDialog dialog = new JDialog(getContext(), HELP.getValue(), false);
        Point location = getContext().getStateTracker().getLocation();
        Dimension size = getContext().getStateTracker().getSize();
        int dialogWidth = 250;
        int dialogHeight = 150;
        int dialogX = (int) (location.getX() + (size.getWidth() - dialogWidth) / 2);
        int dialogY = (int) (location.getY() + (size.getHeight() - dialogHeight) / 2);
        dialog.setLocation(dialogX, dialogY);
        dialog.setSize(dialogWidth, dialogHeight);
        JLabel label = new JLabel("<html>Author : BIGPEL66<br/>E-mail : bigpel66@icloud.com</html>");
        label.setHorizontalAlignment(JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                getContext().getStateTracker().setHelpOpened(false);
            }
        });
        getContext().getStateTracker().setHelpOpened(true);
        dialog.setVisible(true);
    };

    public static void registerTo(final Notepad context) {
        new HelpMenu(context);
    }

    private HelpMenu(final Notepad context) {
        super(context, HELP.getValue());
        AbstractMenuItem.builder()
                .title(ABOUT.getValue())
                .index(HELP.ordinal())
                .context(context)
                .actionListener(helpConsumer)
                .build();
    }

    @Override
    public String toString() {
        return "Name : HelpMenu\n" +
                "Title : " + HELP.getValue() + "\n" +
                "Index : " + HELP.ordinal();
    }

}