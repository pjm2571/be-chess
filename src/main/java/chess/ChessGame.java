package chess;

import chess.board.Board;
import chess.board.Rank;
import chess.pieces.Piece;

import java.util.ArrayList;

public class ChessGame {
    private final static int BOARD_LENGTH = 8;

    private Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void movePiece(String sourcePosition, String targetPosition) {
        Piece piece = board.findPieceByPosition(sourcePosition);

        validatePieceRange(piece, sourcePosition, targetPosition);

        board.setPiece(sourcePosition, Piece.createPiece(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE));
        board.setPiece(targetPosition, piece);

    }

    private void validatePieceRange(Piece piece, String sourcePosition, String targetPosition) {
        if (piece.getType().equals(Piece.Type.KING)) {

        }
    }

    public double calculatePoint(Piece.Color color) {
        double pointSum = board.getRanks().stream()
                .map(rank -> rank.getPiecesByColor(color))
                .flatMap(ArrayList::stream)
                .mapToDouble(Piece::getDefaultPoint)
                .sum();

        return pointSum - calculateDiffer(color);
    }

    private double calculateDiffer(Piece.Color color) {
        double pointDiffer = 0;
        for (int columnIndex = 0; columnIndex < BOARD_LENGTH; columnIndex++) {
            int pawnCount = countPawnsInColumn(color, columnIndex);
            pointDiffer += pawnCount >= 2 ? 0.5 * pawnCount : 0;
        }
        return pointDiffer;
    }

    private int countPawnsInColumn(Piece.Color color, int columnIndex) {
        ArrayList<Piece> pieces = new ArrayList<>();

        for (Rank rank : board.getRanks()) {
            pieces.add(board.findPieceByPieceIndex(rank, columnIndex));
        }

        return (int) pieces.stream()
                .filter(piece -> piece.getType().equals(Piece.Type.PAWN))
                .filter(piece -> piece.getColor().equals(color))
                .count();
    }


}
