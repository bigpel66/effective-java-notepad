package io.bigpel66.component.menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public static MenuBar newInstance() {
        return new MenuBar();
    }

    private MenuBar() {
        add(FileMenu.newInstance());
        add(EditMenu.newInstance());
        add(FormatMenu.newInstance());
        add(HelpMenu.newInstance());
    }

}
