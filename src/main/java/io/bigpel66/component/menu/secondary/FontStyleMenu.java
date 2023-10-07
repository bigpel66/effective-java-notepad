package io.bigpel66.component.menu.secondary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static io.bigpel66.component.menu_item.primary.FormatMenuItemKey.FONT_STYLE;

public final class FontStyleMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FontStyleMenu(context, parent);
    }

    private FontStyleMenu(final Notepad context, final Component parent) {
        super(context, parent, FONT_STYLE.getValue());
        AbstractMenuItem.builder()
                .title(UIManager.getFont("Label.font").getFontName())
                .context(context)
                .parent(this)
                .actionListener((e) -> {
                    JTextArea textArea = Objects.requireNonNull(context.getJTextArea());
                    textArea.setFont(new Font(UIManager.getFont("Label.font").getFontName(), Font.PLAIN, UIManager.getFont("Label.font").getSize()));
                })
                .build();
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) {
            if (i % 20 != 0) {
                continue;
            }
            int copyIndex = i;
            AbstractMenuItem.builder()
                    .title(fontNames[i])
                    .context(context)
                    .parent(this)
                    .actionListener((e) -> {
                        JTextArea textArea = Objects.requireNonNull(context.getJTextArea());
                        textArea.setFont(new Font(fontNames[copyIndex], Font.PLAIN, UIManager.getFont("Label.font").getSize()));
                    })
                    .build();
        }
    }

}