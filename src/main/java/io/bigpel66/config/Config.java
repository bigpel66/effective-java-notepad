package io.bigpel66.config;

import java.awt.*;

public interface Config {

    Point getLocation();

    Dimension getSize();

    String getTitle();

    String getContents();

    int getHash();

    boolean isContentsSaved();

}