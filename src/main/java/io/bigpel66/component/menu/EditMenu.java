package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public final class EditMenu extends AbstractMenu {

    private static final String TITLE = "Edit";

    private static final int INDEX = 1;

    public static void registerTo(final Notepad context) {
        new EditMenu(context);
    }

    private EditMenu(final Notepad context) {
        super(context, TITLE);
        AbstractMenuItem.builder()
                .title("Cut")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("cut"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Copy")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("copy"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Paste")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("paste"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Select All")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("select all"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_DOWN_MASK))
                .build();
    }

    @Override
    public String toString() {
        return "Name : EditMenu\n" +
                "Title : " + TITLE + "\n" +
                "Index : " + INDEX;
    }

}