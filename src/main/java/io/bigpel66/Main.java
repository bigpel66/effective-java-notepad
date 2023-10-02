package io.bigpel66;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Notepad.newInstance(ConfigLoader.load());
    }

}