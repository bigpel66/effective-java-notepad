package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

public final class HelpMenu extends AbstractMenu {

    private static final String TITLE = "Help";

    private static final int INDEX = 3;


    public static HelpMenu registerTo(final Notepad context) {
        return new HelpMenu(context);
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

}
