package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

import javax.swing.*;
import java.awt.*;

public final class FormatMenu extends JMenu {

    private static final String TITLE = "Format";

    private final MenuItem fontStyleItem;

    private final MenuItem fontSizeItem;

    private final MenuItem fontColorItem;

    private final MenuItem backgroundColorItem;


    public static FormatMenu newInstance(final Notepad context) {
        return new FormatMenu(context);
    }

    private FormatMenu(final Notepad context) {
        super(TITLE);
        fontStyleItem = MenuItem.newInstance(context, "Font Style");
        fontSizeItem = MenuItem.newInstance(context, "Font Size");
        fontColorItem = MenuItem.newInstance(context, "Font Color");
        backgroundColorItem = MenuItem.newInstance(context, "Background Color");
        add(fontStyleItem);
        add(fontSizeItem);
        add(fontColorItem);
        add(backgroundColorItem);
    }

    public MenuItem getFontStyleItem() {
        return fontStyleItem;
    }

    public MenuItem getFontSizeItem() {
        return fontSizeItem;
    }

    public MenuItem getFontColorItem() {
        return fontColorItem;
    }

    public MenuItem getBackgroundColorItem() {
        return backgroundColorItem;
    }

}
