package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public final class FileMenu extends AbstractMenu {
    private static final String TITLE = "File";

    private static final int INDEX = 0;

    public static void registerTo(final Notepad context) {
        new FileMenu(context);
    }

    private FileMenu(final Notepad context) {
        super(context, TITLE);
        AbstractMenuItem.builder()
                .title("New")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("new"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Open")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("open"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_DOWN_MASK))
                .build();
        AbstractMenuItem.builder()
                .title("Save")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("save"))
                .keyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_DOWN_MASK))
                .build();
    }

    @Override
    public String toString() {
        return "Name : FileMenu\n" +
                "Title : " + TITLE + "\n" +
                "Index : " + INDEX;
    }

}