package chess.board;

import chess.pieces.Piece;

import java.util.*;
import java.util.stream.*;

import static chess.pieces.Piece.*;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private final static Type[] PAWN_TYPES = {Type.PAWN, Type.PAWN, Type.PAWN, Type.PAWN, Type.PAWN, Type.PAWN, Type.PAWN, Type.PAWN};
    private final static Type[] PIECE_TYPES = {Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN, Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK};
    private final static Type[] BLANK_TYPES = {Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE, Type.NO_PIECE};

    private final List<Rank> ranks = new ArrayList<>();

    public void initializeEmpty() {
        addBlank(BOARD_LENGTH);
    }

    public void initialize() {
        addRank(PIECE_TYPES, Color.WHITE);
        addRank(PAWN_TYPES, Color.WHITE);

        addBlank(BOARD_LENGTH / 2);

        addRank(PAWN_TYPES, Color.BLACK);
        addRank(PIECE_TYPES, Color.BLACK);
    }

    private void addBlank(int blankRankAmount) {
        for (int rankIndex = 0; rankIndex < blankRankAmount; rankIndex++) {
            addRank(BLANK_TYPES, Color.NOCOLOR);
        }
    }

    private void addRank(Type[] types, Color color) {
        ranks.add(new Rank(getPieces(types, color)));
    }

    private ArrayList<Piece> getPieces(Type[] types, Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int pieceIndex = 0; pieceIndex < BOARD_LENGTH; pieceIndex++) {
            pieces.add(Piece.createPiece(color, types[pieceIndex]));
        }
        return pieces;
    }

    private Rank findRankByPosition(Position position) {
        return ranks.get(position.getRankIndex());
    }

    public Piece findPieceByPieceIndex(Rank targetRank, int pieceIndex) {
        return targetRank.getPieceByPieceIndex(pieceIndex);
    }

    public Piece findPieceByPosition(String position) {
        Position piecePosition = new Position(position);

        Rank targetRank = findRankByPosition(piecePosition);

        return findPieceByPieceIndex(targetRank, piecePosition.getPieceIndex());
    }

    public void setPiece(String position, Piece piece) {
        Position piecePosition = new Position(position);

        Rank targetRank = findRankByPosition(piecePosition);

        targetRank.set(piecePosition.getPieceIndex(), piece);
    }
    public List<Rank> getRanks(){
        return ranks;
    }

}
