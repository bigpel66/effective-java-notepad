package io.bigpel66.utility;

import java.awt.*;

public final class StateTracker {

    private Point location;

    private Dimension size;

    private String title;

    public static Builder builder() {
        return new Builder();
    }

    private StateTracker(Builder builder) {
        location = builder.location;
        size = builder.size;
        title = builder.title;
    }

    public static class Builder {

        private Point location;

        private Dimension size;

        private String title;

        private Builder() {
        }

        public Builder location(Point v) {
            location = v;
            return this;
        }

        public Builder size(Dimension v) {
            size = v;
            return this;
        }

        public Builder title(String v) {
            title = v;
            return this;
        }

        public StateTracker build() {
            return new StateTracker(this);
        }

    }

    public void setLocation(Point v) {
        location = v;
    }

    public void setSize(Dimension v) {
        size = v;
    }

    public void setTitle(String v) {
        title = v;
    }

}