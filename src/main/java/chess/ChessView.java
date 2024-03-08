package chess;

import chess.board.*;

import java.util.List;

public class ChessView {
    private List<Rank> ranks;

    public ChessView(Board board) {
        this.ranks = board.getRanks();
    }

    public String showBoard() {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = ranks.size() - 1; i >= 0; i--) {
            resultBuilder.append(ranks.get(i).getRankRepresentation());
        }

        return resultBuilder.toString();
    }


}
