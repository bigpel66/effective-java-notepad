package io.bigpel66.config;

import java.awt.*;

public interface Config {

    Point getLocation();

    Dimension getSize();

    String getTitle();

    String getContents();

    int getHash();

    String getFontName();

    int getFontSize();

    Color getFontColor();

    Color getBackgroundColor();

    boolean isContentsSaved();

}