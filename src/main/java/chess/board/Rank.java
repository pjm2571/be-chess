package chess.board;

import chess.pieces.Piece;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static chess.pieces.Piece.*;

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

    public ArrayList<Piece> getPiecesByColor(Color color) {
        return pieces.stream()
                .filter(p -> !p.equals(Piece.createBlank())) // 빈 조각이 아닌 것만 필터링
                .filter(p -> p.getColor().equals(color))
                .collect(Collectors.toCollection(ArrayList::new)); // 필터링된 결과를 ArrayList로 변환하여 저장
    }

}
