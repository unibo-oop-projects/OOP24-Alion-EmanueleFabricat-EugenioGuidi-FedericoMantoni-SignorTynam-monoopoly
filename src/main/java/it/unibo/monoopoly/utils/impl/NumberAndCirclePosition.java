package it.unibo.monoopoly.utils.impl;

import java.awt.Color;

/**
 * This class create a Builder of position of circle and number in the game
 * board.
 */
public final class NumberAndCirclePosition {

    private final int x;
    private final int y;
    private final boolean isCircle;
    private final Color color;
    private final String number;

    private NumberAndCirclePosition(final Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.isCircle = builder.isCircle;
        this.color = builder.color;
        this.number = builder.number;
    }

    /**
     * @return the x of position.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return return the y of position.
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return if is a circle or a number.
     */
    public boolean isCircle() {
        return this.isCircle;
    }

    /**
     * @return the color of the circle.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return return the number of house to show.
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Builder of class NumberAndCirclePosition.
     */
    public static class Builder {
        private int x;
        private int y;
        private boolean isCircle;
        private Color color;
        private String number;

        /**
         * @param x to set in Builder.
         * @return the actual Builder.
         */
        public Builder x(final int x) {
            this.x = x;
            return this;
        }

        /**
         * @param y to set in Builder.
         * @return the actual Builder.
         */
        public Builder y(final int y) {
            this.y = y;
            return this;
        }

        /**
         * @param isCircle to set in Builder.
         * @return the actual Builder.
         */
        public Builder circle(final boolean isCircle) {
            this.isCircle = isCircle;
            return this;
        }

        /**
         * @param color to set in Builder.
         * @return the actual Builder.
         */
        public Builder color(final Color color) {
            this.color = color;
            return this;
        }

        /**
         * @param number to set in Builder.
         * @return the actual Builder.
         */
        public Builder number(final String number) {
            this.number = number;
            return this;
        }

        /**
         * create the effective object whit data setted.
         * 
         * @return the object created with builder.
         */
        public NumberAndCirclePosition build() {
            return new NumberAndCirclePosition(this);
        }
    }

}
