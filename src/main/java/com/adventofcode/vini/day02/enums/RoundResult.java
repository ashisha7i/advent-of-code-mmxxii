package com.adventofcode.vini.day02.enums;

public enum RoundResult {
    LOST (0),
    DRAW (3),
    WIN (6);

    private Integer pointsValue;

    private RoundResult(Integer pointsValue) {
        this.pointsValue = pointsValue;
    }

    public Integer getPointsValue() {
        return this.pointsValue;
    }
}
