package io.bigpel66.utility;

import java.awt.*;

public final class StateTracker {

    private Point location;

    private Dimension size;

    private String title;

    private String contents;

    private int hash;

    public static Builder builder() {
        return new Builder();
    }

    private StateTracker(final Builder builder) {
        location = builder.location;
        size = builder.size;
        title = builder.title;
        contents = builder.contents;
        hash = builder.hash;
    }

    public static class Builder {

        private Point location;

        private Dimension size;

        private String title;

        private String contents;

        private int hash;

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

}