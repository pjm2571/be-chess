package chess.pieces;

import chess.colors.Colors;

import java.util.Objects;

public final class Piece {

    private Color color;
    private Type type;


    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

    }

    /* 빈 칸을 생성 */
    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    /* 흰색 폰을 생성 */
    public static Piece createWhite(Type pieceType) {
        return new Piece(Color.WHITE, pieceType);
    }

    /* 검은색 폰을 생성 */
    public static Piece createBlack(Type pieceType) {
        return new Piece(Color.BLACK, pieceType);
    }

    /* 피스의 색을 반환 */
    public Color getColor() {
        return color;
    }

    /* 피스의 타입을 반환 */
    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        if (color.equals(Color.BLACK)) {
            return type.getBlackRepresentation();
        }
        return type.getWhiteRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Piece piece))
            return false;
        return color == piece.color &&
                type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

}
