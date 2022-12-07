package com.adventofcode.vini.day02;

import com.adventofcode.vini.day02.enums.OpponentMoves;
import com.adventofcode.vini.day02.enums.PlayerMoves;
import com.adventofcode.vini.day02.enums.RoundResult;

public class ScoreKeeper {
    private static boolean isWinningMove(OpponentMoves opponentMove, PlayerMoves playerMove) {
        return playerMove.ordinal() > opponentMove.ordinal();
    }

    private static Integer getRoundScore(OpponentMoves opponentMove, PlayerMoves playerMove) {
        if (playerMove.ordinal() > opponentMove.ordinal()) {
            return playerMove.getPointValue() + RoundResult.WIN.getPointsValue();
        } else if (playerMove.ordinal() == opponentMove.ordinal()) {
            return playerMove.getPointValue() + RoundResult.DRAW.getPointsValue();
        } 
        
        return playerMove.getPointValue() + RoundResult.LOST.getPointsValue();
    }
}
