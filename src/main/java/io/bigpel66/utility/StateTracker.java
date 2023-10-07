package io.bigpel66.utility;

import java.awt.*;

public final class StateTracker {

    private Point location;

    private Dimension size;

    private String title;

    private String contents;

    private int hash;

    private String fontName;

    private int fontSize;

    private Color fontColor;

    private Color backgroundColor;

    private boolean isContentsSaved;

    private boolean isHelpOpened;

    public static Builder builder() {
        return new Builder();
    }

    private StateTracker(final Builder builder) {
        location = builder.location;
        size = builder.size;
        title = builder.title;
        contents = builder.contents;
        hash = builder.hash;
        isContentsSaved = builder.isContentsSaved;
        isHelpOpened = builder.isHelpOpened;
        fontName = builder.fontName;
        fontSize = builder.fontSize;
        fontColor = builder.fontColor;
        backgroundColor = builder.backgroundColor;
    }

    public static class Builder {

        private Point location;

        private Dimension size;

        private String title;

        private String contents;

        private int hash;

        private String fontName;

        private int fontSize;

        private Color fontColor;

        private Color backgroundColor;

        private boolean isContentsSaved;

        private boolean isHelpOpened;

        private Builder() {
        }

        public Builder location(final Point v) {
            location = v;
            return this;
        }

        public Builder size(final Dimension v) {
            size = v;
            return this;
        }

        public Builder title(final String v) {
            title = v;
            return this;
        }

        public Builder contents(final String v) {
            contents = v;
            return this;
        }

        public Builder hash(final int v) {
            hash = v;
            return this;
        }

        public Builder fontName(final String v) {
            fontName = v;
            return this;
        }

        public Builder fontSize(final int v) {
            fontSize = v;
            return this;
        }

        public Builder fontColor(final Color v) {
            fontColor = v;
            return this;
        }

        public Builder backgroundColor(final Color v) {
            backgroundColor = v;
            return this;
        }

        public Builder isContentsSaved(final boolean v) {
            isContentsSaved = v;
            return this;
        }

        public Builder isHelpOpened(final boolean v) {
            isHelpOpened = v;
            return this;
        }

        public StateTracker build() {
            return new StateTracker(this);
        }

    }

    public void setLocation(final Point v) {
        location = v;
    }

    public void setSize(final Dimension v) {
        size = v;
    }

    public void setTitle(final String v) {
        title = v;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setContentsSaved(boolean contentsSaved) {
        isContentsSaved = contentsSaved;
    }

    public void setHelpOpened(boolean helpOpened) {
        isHelpOpened = helpOpened;
    }

    public Point getLocation() {
        return location;
    }

    public Dimension getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public int getHash() {
        return hash;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public boolean isContentsSaved() {
        return isContentsSaved;
    }

    public boolean isHelpOpened() {
        return isHelpOpened;
    }

}