package chess.pieces;

import chess.colors.Colors;

public class Pawn {
    private final Symbols pawnSymbol;

    public Pawn() {
        this.pawnSymbol = Symbols.WHITE_PAWN;
    }

    public Pawn(Colors pawnColors) {
        this.pawnSymbol = Symbols.getPawnSymbol(pawnColors);
    }

    public String getPawnSymbol() {
        return pawnSymbol.getSymbolShape();
    }

    public Colors getPawnColor() {
        return pawnSymbol.getPawnColor();
    }
}
