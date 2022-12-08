package com.adventofcode.vini.day02;

import java.util.List;

import com.adventofcode.vini.day02.enums.OpponentMoves;
import com.adventofcode.vini.day02.enums.PlayerMoves;
import com.adventofcode.vini.day02.enums.RoundResult;
import com.adventofcode.vini.util.FileReader;

public class Puzzle02 {
    public static void main(String[] args) {
        List<String> allLines = FileReader.allLines("day02/input.txt");
        
        int totalScore = 0;
        
        for(String line: allLines) {
            String[] roundMoves = line.split(" ");
            OpponentMoves opponentMove = OpponentMoves.valueOf(roundMoves[0]);
            
            String guide = roundMoves[1];

            PlayerMoves playerMove   = getPlayerMove(opponentMove, guide);

            Integer score = getRoundScore(opponentMove, playerMove);

            System.out.printf("Opponent Moved %-10s /  Player Moved  %-10s /  Score %d%n%n", opponentMove.getMoveName(), playerMove.getMoveName(), 
                            score);
            totalScore += score;
        }

        System.out.println("TOTAL SCORE : " + totalScore);

    } // main



    private static RoundResult getRoundResult(OpponentMoves opponentMove, PlayerMoves playerMove) {
        if(playerMove.ordinal() == opponentMove.ordinal()) {
            return RoundResult.DRAW;
        } 
        
        if(playerMove.equals(PlayerMoves.X)) {
            if(opponentMove.equals(OpponentMoves.C)){
                return RoundResult.WIN;
            }
        } else if(playerMove.equals(PlayerMoves.Y)) {
            if(opponentMove.equals(OpponentMoves.A)) {
                return RoundResult.WIN;
            }
        } else if(playerMove.equals(PlayerMoves.Z)) {
            if(opponentMove.equals(OpponentMoves.B)) {
                return RoundResult.WIN;
            }
        }

        return RoundResult.LOST;
    }

    private static PlayerMoves getPlayerMove(OpponentMoves opponentMove, String guide) {
        if ("X".equals(guide)) { // Lose
            if(opponentMove.equals(OpponentMoves.A)) { // Opponent moves 'ROCK'
                return PlayerMoves.Z; // Return Scissors
            } else if (opponentMove.equals(OpponentMoves.B)) { // Opponent moves PAPER
                return PlayerMoves.X; // Return ROCK
            } 
            return PlayerMoves.Y;
        } else if ("Y".equals(guide)) {
            if (opponentMove.equals(OpponentMoves.A)) {
                return PlayerMoves.X;
            } else if (opponentMove.equals(OpponentMoves.B)) {
                return PlayerMoves.Y;
            } 
            return PlayerMoves.Z;
        } else if("Z".equals(guide)) { // Find a Winning Hand
            if(opponentMove.equals(OpponentMoves.A)) { // Opponent moves 'ROCK'
                return PlayerMoves.Y; // Return Paper
            } else if (opponentMove.equals(OpponentMoves.B)) { // Opponent moves PAPER
                return PlayerMoves.Z; // Return Scissors
            } 
            return PlayerMoves.X;            
        }
        return null;
    }

    private  static Integer getRoundScore(OpponentMoves opponentMove, PlayerMoves playerMove) {
        RoundResult roundResult = getRoundResult(opponentMove, playerMove);
        System.out.println("Round Result : " + roundResult.name());
        return playerMove.getPointValue() + roundResult.getPointsValue();
    }
}
