package chess.pieces;

import chess.colors.Colors;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 체스 Piece들의 color 테스트")
    public void all_pieces_color_test() {
        verifyPieceColor(Piece.createPiece(Symbols.WHITE_PAWN), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_PAWN), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_KNIGHT), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_KNIGHT), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_BISHOP), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_BISHOP), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_ROOK), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_ROOK), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_QUEEN), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_QUEEN), Colors.BLACK);

        verifyPieceColor(Piece.createPiece(Symbols.WHITE_KING), Colors.WHITE);
        verifyPieceColor(Piece.createPiece(Symbols.BLACK_KING), Colors.BLACK);
    }

    private void verifyPieceColor(Piece piece, Colors color) {
        assertThat(piece.getPieceColor()).isEqualTo(color);
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

    @Test
    @DisplayName("흰색 piece에 대한 isWhite 메소드 테스트")
    public void whitePiece_isWhite_test(){
        Piece piece = Piece.createPiece(Symbols.WHITE_KNIGHT);
        assertThat(piece.isWhite()).isEqualTo(true);
    }

    @Test
    @DisplayName("검은색 piece에 대한 isWhite 메소드 테스트")
    public void blackPiece_isWhite_test(){
        Piece piece = Piece.createPiece(Symbols.BLACK_KNIGHT);
        assertThat(piece.isWhite()).isEqualTo(false);
    }
}
