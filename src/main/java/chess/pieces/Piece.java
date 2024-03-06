package chess.pieces;

import chess.colors.Colors;

public final class Piece {
    private final Symbol pieceSymbol;

    private Piece(Symbol pieceSymbol) {
        this.pieceSymbol = pieceSymbol;
    }

    public static Piece createPiece(Symbol pieceSymbol) {
        return new Piece(pieceSymbol);
    }

    public Colors getPieceColor() {
        return pieceSymbol.getPieceColor();
    }

    public String getPieceShape() {
        return pieceSymbol.getPieceShape();
    }

    public boolean isWhite(){
        return pieceSymbol.getPieceColor().equals(Colors.WHITE);
    }

    public boolean isBlack(){
        return pieceSymbol.getPieceColor().equals(Colors.BLACK);
    }

}
