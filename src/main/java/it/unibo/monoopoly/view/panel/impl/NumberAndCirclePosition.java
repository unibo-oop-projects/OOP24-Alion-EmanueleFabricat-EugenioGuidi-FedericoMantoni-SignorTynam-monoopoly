package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;

public class NumberAndCirclePosition{

    private final int x;
    private final int y;
    private final boolean isCircle;
    private final Color color;
    private final String number;

    private NumberAndCirclePosition(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.isCircle = builder.isCircle;
        this.color = builder.color;
        this.number = builder.number;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isCircle() {
        return this.isCircle;
    }

    public Color getColor() {
        return this.color;
    }

    public String getNumber() {
        return this.number;
    }

    public static class Builder {
        private int x;
        private int y;
        private boolean isCircle;
        private Color color;
        private String number;

        public Builder setX(final int x) {
            this.x = x;
            return this;
        }

        public Builder setY(final int y) {
            this.y = y;
            return this;
        }

        public Builder setIsCircle(final boolean isCircle) {
            this.isCircle = isCircle;
            return this;
        }

        public Builder setColor(final Color color) {
            this.color = color;
            return this;
        }

        public Builder setNumber(final String number) {
            this.number = number;
            return this;
        }

        public NumberAndCirclePosition build() {
            return new NumberAndCirclePosition(this);
        }
    }

}
