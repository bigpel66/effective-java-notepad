package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class FileMenu extends JMenu {
    private static final String TITLE = "File";

    private final MenuItem newItem;

    private final MenuItem openItem;

    private final MenuItem saveItem;

    public static FileMenu newInstance(final Notepad context) {
        return new FileMenu(context);
    }

    private FileMenu(final Notepad context) {
        super(TITLE);
        newItem = MenuItem.newInstance(context, "New");
        openItem = MenuItem.newInstance(context, "Open");
        saveItem = MenuItem.newInstance(context, "Save");
        add(newItem);
        add(openItem);
        add(saveItem);
    }

    public MenuItem getNewItem() {
        return newItem;
    }

    public MenuItem getOpenItem() {
        return openItem;
    }

    public MenuItem getSaveItem() {
        return saveItem;
    }

}
