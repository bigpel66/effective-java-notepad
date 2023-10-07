package io.bigpel66.config;

import java.awt.*;
import java.util.Optional;

import static io.bigpel66.config.ConfigKey.*;

public final class DefaultConfig implements Config {

    private static final DefaultConfig DEFAULT_CONFIG = new DefaultConfig();

    private final Point position;

    private final Dimension size;

    private final String title;

    private final String contents;

    private final int hash;

    private final String fontName;

    private final int fontSize;

    private final Color fontColor;

    private final Color backgroundColor;

    private final boolean isContentsSaved;

    public static DefaultConfig getInstance() {
        return DEFAULT_CONFIG;
    }

    private DefaultConfig() {
        position = new Point(X_POS.getValue(), Y_POS.getValue());
        size = new Dimension(WIDTH.getValue(), HEIGHT.getValue());
        title = TITLE.getValue();
        contents = CONTENTS.getValue();
        hash = HASH.getValue();
        fontName = FONT_NAME.getValue();
        fontSize = FONT_SIZE.getValue();
        fontColor = Color.getColor(null, (int) FONT_COLOR.getValue());
        backgroundColor = Color.getColor(null, (int) BACKGROUND_COLOR.getValue());
        isContentsSaved = Boolean.parseBoolean(IS_CONTENTS_SAVED.getValue());
    }

    @Override
    public Point getLocation() {
        return position;
    }

    @Override
    public Dimension getSize() {
        return size;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContents() {
        return contents;
    }

    @Override
    public int getHash() {
        return hash;
    }

    @Override
    public String getFontName() {
        return fontName;
    }

    @Override
    public int getFontSize() {
        return fontSize;
    }

    @Override
    public Color getFontColor() {
        return fontColor;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public boolean isContentsSaved() {
        return isContentsSaved;
    }

}