package chess;

import chess.pieces.Piece;
import chess.pieces.Symbol;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private final List<List<Piece>> pieces = new ArrayList<>();

    public void initialize() {
        addBlackPieces();
        addWhitePieces();
    }

    public int getSize() {
        return pieces.stream()
                .mapToInt(List::size)
                .sum();
    }

    private void addBlackPieces() {
        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(Piece.createPiece(Symbol.BLACK_ROOK));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_KNIGHT));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_BISHOP));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_QUEEN));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_KING));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_BISHOP));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_KNIGHT));
        blackPieces.add(Piece.createPiece(Symbol.BLACK_ROOK));

        addPawns(blackPieces, Symbol.BLACK_PAWN);

        pieces.add(blackPieces);
    }

    private void addWhitePieces() {
        List<Piece> whitePieces = new ArrayList<>();

        addPawns(whitePieces, Symbol.WHITE_PAWN);

        whitePieces.add(Piece.createPiece(Symbol.WHITE_ROOK));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_KNIGHT));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_BISHOP));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_QUEEN));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_KING));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_BISHOP));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_KNIGHT));
        whitePieces.add(Piece.createPiece(Symbol.WHITE_ROOK));

        pieces.add(whitePieces);
    }

    private void addPawns(List<Piece> colorPieces, Symbol symbol) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            colorPieces.add(Piece.createPiece(symbol));
        }
    }


    public String showBoard() {
        String pieceShapes = pieces.stream()
                .flatMap(List::stream)
                .map(Piece::getPieceShape)
                .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder(pieceShapes);

        sb.insert(BOARD_LENGTH + BOARD_LENGTH, StringUtils.NEWLINE + "........" + StringUtils.NEWLINE + "........" + StringUtils.NEWLINE + "........" + StringUtils.NEWLINE + "........" + StringUtils.NEWLINE);

        sb.insert(BOARD_LENGTH, StringUtils.NEWLINE);

        sb.insert(sb.length() - BOARD_LENGTH, StringUtils.NEWLINE);

        return sb.toString();

    }


}
