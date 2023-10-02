package io.bigpel66;

import io.bigpel66.utility.ConfigLoader;

public class Main {

    public static void main(String[] args) throws Exception {
        Notepad.newInstance(ConfigLoader.load());
        Notepad.newInstance(ConfigLoader.load());
        Notepad.newInstance(ConfigLoader.load());
    }

}