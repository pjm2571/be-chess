package chess.pieces;

import chess.colors.Colors;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 체스 Piece들의 color 테스트")
    public void all_pieces_color_test() {
        verifyPieceColor(Piece.createPiece(Symbol.WHITE_PAWN), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_PAWN), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbol.WHITE_KNIGHT), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_KNIGHT), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbol.WHITE_BISHOP), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_BISHOP), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbol.WHITE_ROOK), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_ROOK), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbol.WHITE_QUEEN), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_QUEEN), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbol.WHITE_KING), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbol.BLACK_KING), Colors.BLACK);
    }

    private void verifyPieceColor(Piece piece, Colors color) {
        assertThat(piece.getPieceColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("모든 체스 Piece들의 shape 테스트")
    public void all_pieces_shape_test() {
        verifyPieceShape(Piece.createPiece(Symbol.WHITE_PAWN), Symbol.WHITE_PAWN);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_PAWN), Symbol.BLACK_PAWN);

        verifyPieceShape(Piece.createPiece(Symbol.WHITE_KNIGHT), Symbol.WHITE_KNIGHT);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_KNIGHT), Symbol.BLACK_KNIGHT);

        verifyPieceShape(Piece.createPiece(Symbol.WHITE_BISHOP), Symbol.WHITE_BISHOP);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_BISHOP), Symbol.BLACK_BISHOP);

        verifyPieceShape(Piece.createPiece(Symbol.WHITE_ROOK), Symbol.WHITE_ROOK);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_ROOK), Symbol.BLACK_ROOK);

        verifyPieceShape(Piece.createPiece(Symbol.WHITE_QUEEN), Symbol.WHITE_QUEEN);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_QUEEN), Symbol.BLACK_QUEEN);

        verifyPieceShape(Piece.createPiece(Symbol.WHITE_KING), Symbol.WHITE_KING);
        verifyPieceShape(Piece.createPiece(Symbol.BLACK_KING), Symbol.BLACK_KING);
    }

    private void verifyPieceShape(Piece piece, Symbol symbol) {
        assertThat(piece.getPieceShape()).isEqualTo(symbol.getPieceShape());
    }

    @Test
    @DisplayName("흰색 piece에 대한 isWhite 메소드 테스트")
    public void whitePiece_isWhite_test(){
        Piece piece = Piece.createPiece(Symbol.WHITE_KNIGHT);
        assertThat(piece.isWhite()).isEqualTo(true);
    }

    @Test
    @DisplayName("검은색 piece에 대한 isWhite 메소드 테스트")
    public void blackPiece_isWhite_test(){
        Piece piece = Piece.createPiece(Symbol.BLACK_KNIGHT);
        assertThat(piece.isWhite()).isEqualTo(false);
    }
}
