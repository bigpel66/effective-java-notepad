package io.bigpel66.component.menu.primary;

import io.bigpel66.Notepad;
import io.bigpel66.component.Component;
import io.bigpel66.component.menu.AbstractMenu;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;

import static io.bigpel66.component.menu.primary.MenuKey.EDIT;
import static io.bigpel66.component.menu_item.primary.EditMenuItemKey.*;

public final class EditMenu extends AbstractMenu {

    public static void registerTo(final Notepad context, final Component parent) {
        new EditMenu(context, parent);
    }

    private EditMenu(final Notepad context, final Component parent) {
        super(context, parent, EDIT.getValue());
        AbstractMenuItem.builder()
                .title(CUT.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).cut())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(COPY.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).copy())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(PASTE.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).paste())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(SELECT_ALL.getValue())
                .context(context)
                .parent(this)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).selectAll())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_DOWN_MASK))
                .build();
    }

    @Override
    public String toString() {
        return "Name : EditMenu\n" +
                "Title : " + EDIT.getValue() + "\n" +
                "Index : " + EDIT.ordinal();
    }

}