package chess.pieces;

import chess.colors.Colors;

import java.util.Arrays;

public enum Symbols {
    WHITE_PAWN(Colors.WHITE, "♙"),
    BLACK_PAWN(Colors.BLACK, "♟");

    private Colors symbolColor;
    private String symbolShape;

    Symbols(Colors symbolColor, String symbolShape) {
        this.symbolColor = symbolColor;
        this.symbolShape = symbolShape;
    }

    public static Symbols getPawnSymbol(Colors pawnColor) {
        return Arrays.stream(Symbols.values())
                .filter(symbol -> symbol.symbolColor == pawnColor)
                .findFirst()
                .orElse(null);
    }

    public Colors getPawnColor() {
        return symbolColor;
    }

    public String getSymbolShape() {
        return symbolShape;
    }
}
