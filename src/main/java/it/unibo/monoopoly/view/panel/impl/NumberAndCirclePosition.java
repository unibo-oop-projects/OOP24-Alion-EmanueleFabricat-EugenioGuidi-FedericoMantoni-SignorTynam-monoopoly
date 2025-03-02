package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;

public class NumberAndCirclePosition{

    private int x;
    private int y;
    private boolean isCircle;
    private Color color;
    private String number;

    private NumberAndCirclePosition(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.isCircle = builder.isCircle;
        this.color = builder.color;
        this.number = builder.number;
    }

    public int getX() {

    }

    public int getY() {

    }

    public boolean isCircle() {

    }

    public Color getColor() {

    }

    public String getNumber() {

    }

    public static class Builder {
        
    }

}
