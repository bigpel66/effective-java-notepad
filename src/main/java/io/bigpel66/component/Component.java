package io.bigpel66.component;

import io.bigpel66.Notepad;

import javax.swing.*;

public interface Component {

    Notepad getContext();

    JComponent getJComponent();

}