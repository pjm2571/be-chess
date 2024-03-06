package chess;

import chess.pieces.Piece;
import chess.pieces.Symbols;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private List<List<Piece>> pieces = new ArrayList<>();

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
        blackPieces.add(Piece.createPiece(Symbols.BLACK_ROOK));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_KNIGHT));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_BISHOP));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_QUEEN));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_KING));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_BISHOP));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_KNIGHT));
        blackPieces.add(Piece.createPiece(Symbols.BLACK_ROOK));

        addPawns(blackPieces, Symbols.BLACK_PAWN);

        pieces.add(blackPieces);
    }

    private void addWhitePieces() {
        List<Piece> whitePieces = new ArrayList<>();

        addPawns(whitePieces, Symbols.WHITE_PAWN);

        whitePieces.add(Piece.createPiece(Symbols.WHITE_ROOK));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_KNIGHT));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_BISHOP));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_QUEEN));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_KING));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_BISHOP));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_KNIGHT));
        whitePieces.add(Piece.createPiece(Symbols.WHITE_ROOK));

        pieces.add(whitePieces);
    }

    private void addPawns(List<Piece> colorPieces, Symbols symbol) {
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
