package chess.pieces;

import colors.color;

public class Pawn {
    private final color pawnColor;

    public Pawn() {
        this.pawnColor = color.WHITE;
    }

    public Pawn(color pawnColor) {
        this.pawnColor = pawnColor;
    }

    public color getColor() {
        return pawnColor;
    }
}
