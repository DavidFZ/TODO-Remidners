package edu.square.utils;

import java.awt.*;

public class HeightPercentageHelper {
    Dimension totalDimension;

    private double total = 1;

    public HeightPercentageHelper(Dimension totalDimension) {
        this.totalDimension = totalDimension;
    }

    public Dimension getPercantageDimension(double percentage) {
        assert percentage <= total && percentage >= 0;
        total -= percentage;
        return new Dimension((int) totalDimension.getWidth(), (int) (totalDimension.height * percentage));
    }

    public Dimension getRestDimension() {
        return new Dimension((int) totalDimension.getWidth(), (int) (totalDimension.height * total));
    }
}
