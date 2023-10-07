package io.bigpel66.config;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

import static io.bigpel66.config.ConfigKey.*;
import static io.bigpel66.utility.DynamicTypeParser.toInt;

public class AbstractConfig implements Config {

    private final Point location;

    private final Dimension size;

    private final String title;

    private final String contents;

    private final int hash;

    private final String fontName;

    private final int fontSize;

    private final Color fontColor;

    private final Color backgroundColor;

    private final boolean isContentsSaved;

    public static AbstractConfig of(final Map<ConfigKey, Object> configMap) {
        Objects.requireNonNull(configMap);
        return new AbstractConfig(configMap);
    }

    protected AbstractConfig(final Map<ConfigKey, Object> configMap) {
        location = new Point(toInt(configMap.getOrDefault(X_POS, X_POS.getValue())), toInt(configMap.getOrDefault(Y_POS, Y_POS.getValue())));
        size = new Dimension(toInt(configMap.getOrDefault(WIDTH, WIDTH.getValue())), toInt(configMap.getOrDefault(HEIGHT, HEIGHT.getValue())));
        title = configMap.getOrDefault(TITLE, TITLE.getValue()).toString();
        contents = configMap.getOrDefault(CONTENTS, CONTENTS.getValue()).toString();
        hash = toInt(configMap.getOrDefault(HASH, HASH.getValue()));
        fontName = configMap.getOrDefault(FONT_NAME, FONT_NAME.getValue()).toString();
        fontSize = toInt(configMap.getOrDefault(FONT_SIZE, FONT_SIZE.getValue()));
        fontColor = Color.getColor(null, toInt(configMap.getOrDefault(FONT_COLOR, FONT_COLOR.getValue())));
        backgroundColor = Color.getColor(null, toInt(configMap.getOrDefault(BACKGROUND_COLOR, BACKGROUND_COLOR.getValue())));
        isContentsSaved = Boolean.parseBoolean(configMap.getOrDefault(IS_CONTENTS_SAVED, IS_CONTENTS_SAVED.getValue()).toString());
    }

    @Override
    public Point getLocation() {
        return location;
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