package io.bigpel66.component;

import io.bigpel66.Notepad;

public interface Component {

    Notepad getContext();

    java.awt.Component getJComponent();

}