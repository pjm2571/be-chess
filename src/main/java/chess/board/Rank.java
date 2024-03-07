package chess.board;

import chess.pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;

public class Rank {
    private ArrayList<Piece> pieces;

    public Rank(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public int findPieceCount(Piece findPiece) {
        return (int) pieces.stream()
                .filter(piece -> piece.equals(findPiece))
                .count();
    }

    public String getRankRepresentation() {
        StringBuilder sb = new StringBuilder();
        pieces.stream().map(Piece::getRepresentation)
                .forEach(sb::append);
        return StringUtils.appendNewLine(sb.toString());
    }

    public Piece getPieceByPieceIndex(int pieceIndex) {
        return pieces.get(pieceIndex);
    }

    public void set(int pieceIndex, Piece piece) {
        pieces.set(pieceIndex, piece);
    }

}
