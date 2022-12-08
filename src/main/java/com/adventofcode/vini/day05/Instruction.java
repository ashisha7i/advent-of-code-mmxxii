package com.adventofcode.vini.day05;

public class Instruction {
    private Integer stackCount;
    private Integer stackFrom;
    private Integer stackTo;
    
    public Integer getStackCount() {
        return stackCount;
    }
    
    public void setStackCount(Integer stackCount) {
        this.stackCount = stackCount;
    }
    
    public Integer getStackFrom() {
        return stackFrom;
    }
    
    public void setStackFrom(Integer stackFrom) {
        this.stackFrom = stackFrom;
    }
    
    public Integer getStackTo() {
        return stackTo;
    }
    
    public void setStackTo(Integer stackTo) {
        this.stackTo = stackTo;
    }

    public Instruction(Integer stackCount, Integer stackFrom, Integer stackTo) {
        this.stackCount = stackCount;
        this.stackFrom = stackFrom;
        this.stackTo = stackTo;
    }

}
