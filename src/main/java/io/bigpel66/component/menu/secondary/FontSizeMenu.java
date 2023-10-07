package io.bigpel66.component.menu.secondary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static io.bigpel66.component.menu.secondary.FormatMenuKey.FONT_SIZE;

public final class FontSizeMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new FontSizeMenu(context, parent);
    }

    private FontSizeMenu(final Notepad context, final Component parent) {
        super(context, parent, FONT_SIZE.getValue());
        for (int i = 3; i < 53; i += 5) {
            int copyIndex = i;
            AbstractMenuItem.builder()
                    .title(String.valueOf(i))
                    .context(context)
                    .parent(this)
                    .actionListener((e) -> {
                        JTextArea textArea = Objects.requireNonNull(context.getJTextArea());
                        textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, copyIndex));
                        context.getStateTracker().setFontSize(copyIndex);
                    })
                    .build();
        }
    }

}