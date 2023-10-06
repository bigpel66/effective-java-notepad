package io.bigpel66.component.menu;

import io.bigpel66.Notepad;
import io.bigpel66.component.menu_item.AbstractMenuItem;

public final class HelpMenu extends AbstractMenu {

    private static final String TITLE = "Help";

    private static final int INDEX = 3;


    public static void registerTo(final Notepad context) {
        new HelpMenu(context);
    }

    private HelpMenu(final Notepad context) {
        super(context, TITLE);
        AbstractMenuItem.builder()
                .title("About")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("about"))
                .build();
    }

    @Override
    public String toString() {
        return "Name : HelpMenu\n" +
                "Title : " + TITLE + "\n" +
                "Index : " + INDEX;
    }

}
