package chess.pieces;

import chess.colors.Colors;

import java.util.Arrays;

public enum Symbol {
    WHITE_PAWN(Colors.WHITE, "♙"),
    BLACK_PAWN(Colors.BLACK, "♟"),
    WHITE_KNIGHT(Colors.WHITE, "♘"),
    BLACK_KNIGHT(Colors.BLACK, "♞"),
    WHITE_ROOK(Colors.WHITE, "♖"),
    BLACK_ROOK(Colors.BLACK, "♜"),
    WHITE_BISHOP(Colors.WHITE, "♗"),
    BLACK_BISHOP(Colors.BLACK, "♝"),
    WHITE_QUEEN(Colors.WHITE, "♕"),
    BLACK_QUEEN(Colors.BLACK, "♛"),
    WHITE_KING(Colors.WHITE, "♔"),
    BLACK_KING(Colors.BLACK, "♚");

    private Colors symbolColor;
    private String symbolShape;

    Symbol(Colors symbolColor, String symbolShape) {
        this.symbolColor = symbolColor;
        this.symbolShape = symbolShape;
    }

    public Colors getPieceColor() {
        return symbolColor;
    }

    public String getPieceShape() {
        return symbolShape;
    }
}
