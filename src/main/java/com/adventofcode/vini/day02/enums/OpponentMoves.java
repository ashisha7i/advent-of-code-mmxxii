package com.adventofcode.vini.day02.enums;

public enum OpponentMoves
 {
     A ("Rock"),
     B ("Paper"),
    C ("Scissors");

    private String moveName;

    private OpponentMoves(String moveName){
        this.moveName = moveName;
    }

    public String getMoveName(){
        return this.moveName;
    }
}
