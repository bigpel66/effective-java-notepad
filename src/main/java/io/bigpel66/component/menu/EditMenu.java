package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;

import static io.bigpel66.component.menu.MenuKey.EDIT;
import static io.bigpel66.component.menu_item.EditMenuItemKey.*;

public final class EditMenu extends AbstractMenu {

    public static void registerTo(final Notepad context) {
        new EditMenu(context);
    }

    private EditMenu(final Notepad context) {
        super(context, EDIT.getValue());
        AbstractMenuItem.builder()
                .title(CUT.getValue())
                .index(EDIT.ordinal())
                .context(context)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).cut())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(COPY.getValue())
                .index(EDIT.ordinal())
                .context(context)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).copy())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(PASTE.getValue())
                .index(EDIT.ordinal())
                .context(context)
                .actionListener((e) -> Objects.requireNonNull(context.getJTextArea()).paste())
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()))
                .build();
        AbstractMenuItem.builder()
                .title(SELECT_ALL.getValue())
                .index(EDIT.ordinal())
                .context(context)
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