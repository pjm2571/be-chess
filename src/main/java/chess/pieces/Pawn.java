package chess.pieces;

import colors.Colors;

public class Pawn {
    private final Colors pawnColor;

    public Pawn() {
        this.pawnColor = Colors.WHITE;
    }

    public Pawn(Colors pawnColors) {
        this.pawnColor = pawnColors;
    }
}
