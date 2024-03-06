package chess.pieces;

import colors.Colors;

public class Pawn {
    private final Colors pawnColor;
    private Symbols pawnSymbol;

    public Pawn() {
        this.pawnColor = Colors.WHITE;
        setPawnSymbol();
    }

    public Pawn(Colors pawnColors) {
        this.pawnColor = pawnColors;
        setPawnSymbol();
    }

    private void setPawnSymbol(){
        this.pawnSymbol = Symbols.getPawnSymbol(pawnColor);
    }

    public String getPawnSymbol(){
        return pawnSymbol.getSymbolShape();
    }

    public Colors getPawnColor(){
        return pawnColor;
    }
}
