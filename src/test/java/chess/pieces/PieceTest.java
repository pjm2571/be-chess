package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 체스 Piece들의 color 테스트")
    public void all_pieces_color_test() {
        verifyPieceColor(Piece.createPiece(Symbols.WHITE_PAWN), Symbols.WHITE_PAWN);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_PAWN), Symbols.BLACK_PAWN);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_KNIGHT), Symbols.WHITE_KNIGHT);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_KNIGHT), Symbols.BLACK_KNIGHT);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_BISHOP), Symbols.WHITE_BISHOP);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_BISHOP), Symbols.BLACK_BISHOP);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_ROOK), Symbols.WHITE_ROOK);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_ROOK), Symbols.BLACK_ROOK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_QUEEN), Symbols.WHITE_QUEEN);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_QUEEN), Symbols.BLACK_QUEEN);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_KING), Symbols.WHITE_KING);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_KING), Symbols.BLACK_KING);
    }

    private void verifyPieceColor(Piece piece, Symbols symbol) {
        assertThat(piece.getPieceColor()).isEqualTo(symbol.getPieceColor());
    }

    @Test
    @DisplayName("모든 체스 Piece들의 shape 테스트")
    public void all_pieces_shape_test() {
        verifyPieceShape(Piece.createPiece(Symbols.WHITE_PAWN), Symbols.WHITE_PAWN);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_PAWN), Symbols.BLACK_PAWN);

        verifyPieceShape(Piece.createPiece(Symbols.WHITE_KNIGHT), Symbols.WHITE_KNIGHT);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_KNIGHT), Symbols.BLACK_KNIGHT);

        verifyPieceShape(Piece.createPiece(Symbols.WHITE_BISHOP), Symbols.WHITE_BISHOP);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_BISHOP), Symbols.BLACK_BISHOP);

        verifyPieceShape(Piece.createPiece(Symbols.WHITE_ROOK), Symbols.WHITE_ROOK);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_ROOK), Symbols.BLACK_ROOK);

        verifyPieceShape(Piece.createPiece(Symbols.WHITE_QUEEN), Symbols.WHITE_QUEEN);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_QUEEN), Symbols.BLACK_QUEEN);

        verifyPieceShape(Piece.createPiece(Symbols.WHITE_KING), Symbols.WHITE_KING);
        verifyPieceShape(Piece.createPiece(Symbols.BLACK_KING), Symbols.BLACK_KING);
    }

    private void verifyPieceShape(Piece piece, Symbols symbol) {
        assertThat(piece.getPieceShape()).isEqualTo(symbol.getPieceShape());
    }



}
