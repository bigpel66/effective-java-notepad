package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

import static io.bigpel66.component.menu.MenuKey.FORMAT;
import static io.bigpel66.component.menu_item.FormatMenuItemKey.*;

public final class FormatMenu extends AbstractMenu {

    public static void registerTo(final Notepad context) {
        new FormatMenu(context);
    }

    private FormatMenu(final Notepad context) {
        super(context, FORMAT.getValue());
        AbstractMenuItem.builder()
                .title(FONT_STYLE.getValue())
                .index(FORMAT.ordinal())
                .context(context)
                .actionListener((e) -> System.out.println("font style"))
                .build();
        AbstractMenuItem.builder()
                .title(FONT_SIZE.getValue())
                .index(FORMAT.ordinal())
                .context(context)
                .actionListener((e) -> System.out.println("font size"))
                .build();
        AbstractMenuItem.builder()
                .title(FONT_COLOR.getValue())
                .index(FORMAT.ordinal())
                .context(context)
                .actionListener((e) -> System.out.println("font color"))
                .build();
        AbstractMenuItem.builder()
                .title(BACKGROUND_COLOR.getValue())
                .index(FORMAT.ordinal())
                .context(context)
                .actionListener((e) -> System.out.println("background color"))
                .build();
    }

    @Override
    public String toString() {
        return "Name : FormatMenu\n" +
                "Title : " + FORMAT.getValue() + "\n" +
                "Index : " + FORMAT.ordinal();
    }

}