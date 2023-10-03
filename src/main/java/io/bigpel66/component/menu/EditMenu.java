package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;

public final class EditMenu extends JMenu {

    private static final String TITLE = "Edit";

    private final MenuItem cutItem;

    private final MenuItem copyItem;

    private final MenuItem pasteItem;

    private final MenuItem selectAllItem;

    public static EditMenu newInstance(final Notepad context) {
        return new EditMenu(context);
    }

    private EditMenu(final Notepad context) {
        super(TITLE);
        cutItem = MenuItem.newInstance(context, "Cut");
        copyItem = MenuItem.newInstance(context, "Copy");
        pasteItem = MenuItem.newInstance(context, "Paste");
        selectAllItem = MenuItem.newInstance(context, "Select All");
        add(cutItem);
        add(copyItem);
        add(pasteItem);
        add(selectAllItem);
    }

    public MenuItem getCutItem() {
        return cutItem;
    }

    public MenuItem getCopyItem() {
        return copyItem;
    }

    public MenuItem getPasteItem() {
        return pasteItem;
    }

    public MenuItem getSelectAllItem() {
        return selectAllItem;
    }

}
