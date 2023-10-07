package io.bigpel66.component.menu.primary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;
import io.bigpel66.component.menu.secondary.FontSizeMenu;
import io.bigpel66.component.menu.secondary.FontStyleMenu;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static io.bigpel66.component.menu.primary.MenuKey.FORMAT;
import static io.bigpel66.component.menu.secondary.FormatMenuKey.BACKGROUND_COLOR;
import static io.bigpel66.component.menu.secondary.FormatMenuKey.FONT_COLOR;

public final class FormatMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FormatMenu(context, parent);
    }

    private FormatMenu(final Notepad context, final Component parent) {
        super(context, parent, FORMAT.getValue());
        FontStyleMenu.registerTo(context, this);
        FontSizeMenu.registerTo(context, this);
        AbstractMenuItem.builder()
                .title(FONT_COLOR.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> {
                    Color color = JColorChooser.showDialog(this, "Select a color", Color.BLACK);
                    JTextArea textArea = Objects.requireNonNull(context.getJTextArea());
                    textArea.setForeground(color);
                    context.getStateTracker().setFontColor(color);
                })
                .build();
        AbstractMenuItem.builder()
                .title(BACKGROUND_COLOR.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> {
                    Color color = JColorChooser.showDialog(this, "Select a color", Color.WHITE);
                    JTextArea textArea = Objects.requireNonNull(context.getJTextArea());
                    textArea.setBackground(color);
                    context.getStateTracker().setBackgroundColor(color);
                })
                .build();
    }

    @Override
    public String toString() {
        return "Name : FormatMenu\n" +
                "Title : " + FORMAT.getValue() + "\n" +
                "Index : " + FORMAT.ordinal();
    }

}