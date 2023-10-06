package io.bigpel66.component.menu;

import io.bigpel66.Notepad;

public final class FormatMenu extends AbstractMenu {

    private static final String TITLE = "Format";

    private static final int INDEX = 2;


    public static FormatMenu registerTo(final Notepad context) {
        return new FormatMenu(context);
    }

    private FormatMenu(final Notepad context) {
        super(context, TITLE);
        AbstractMenuItem.builder()
                .title("Font Style")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("font style"))
                .build();
        AbstractMenuItem.builder()
                .title("Font Size")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("font size"))
                .build();
        AbstractMenuItem.builder()
                .title("Font Color")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("font color"))
                .build();
        AbstractMenuItem.builder()
                .title("Background Color")
                .index(INDEX)
                .context(context)
                .actionListener((e) -> System.out.println("background color"))
                .build();
    }

}
