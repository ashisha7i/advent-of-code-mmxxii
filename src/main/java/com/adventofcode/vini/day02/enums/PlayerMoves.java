package com.adventofcode.vini.day02.enums;

public enum PlayerMoves {
    X ("Rock", 1),
    Y ("Paper", 2),
    Z ("Scissors", 3);

    private String moveName;
    private Integer pointValue;

    private PlayerMoves(String moveName, int pointValue){
        this.moveName = moveName;
        this.pointValue = pointValue;
    }

    public String getMoveName() {
        return this.moveName;
    }

    public Integer getPointValue() {
        return this.pointValue;
    }
}
