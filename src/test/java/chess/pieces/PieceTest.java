package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("흰색 기물들의 정상 Type 테스트")
    public void whitePieces_type_test() {
        Piece.Type pieceType = Piece.Type.PAWN;
        assertThat(Piece.createWhite(Piece.Type.PAWN).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.ROOK;
        assertThat(Piece.createWhite(Piece.Type.ROOK).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.KNIGHT;
        assertThat(Piece.createWhite(Piece.Type.KNIGHT).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.BISHOP;
        assertThat(Piece.createWhite(Piece.Type.BISHOP).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.QUEEN;
        assertThat(Piece.createWhite(Piece.Type.QUEEN).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.KING;
        assertThat(Piece.createWhite(Piece.Type.KING).getType()).isEqualTo(pieceType);
    }

    @Test
    @DisplayName("검은색 기물들의 정상 Type 테스트")
    public void blackPieces_type_test() {
        Piece.Type pieceType = Piece.Type.PAWN;
        assertThat(Piece.createBlack(Piece.Type.PAWN).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.ROOK;
        assertThat(Piece.createBlack(Piece.Type.ROOK).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.KNIGHT;
        assertThat(Piece.createBlack(Piece.Type.KNIGHT).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.BISHOP;
        assertThat(Piece.createBlack(Piece.Type.BISHOP).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.QUEEN;
        assertThat(Piece.createBlack(Piece.Type.QUEEN).getType()).isEqualTo(pieceType);

        pieceType = Piece.Type.KING;
        assertThat(Piece.createBlack(Piece.Type.KING).getType()).isEqualTo(pieceType);
    }

    @Test
    @DisplayName("기물들의 비정상 Type 테스트")
    public void pieces_type_error_test() {
        Piece.Type pieceType = Piece.Type.PAWN;

        assertThat(Piece.createBlack(Piece.Type.ROOK).getType()).isNotEqualTo(pieceType);
        assertThat(Piece.createBlack(Piece.Type.KNIGHT).getType()).isNotEqualTo(pieceType);
        assertThat(Piece.createBlack(Piece.Type.BISHOP).getType()).isNotEqualTo(pieceType);
        assertThat(Piece.createBlack(Piece.Type.QUEEN).getType()).isNotEqualTo(pieceType);
        assertThat(Piece.createBlack(Piece.Type.KING).getType()).isNotEqualTo(pieceType);
        assertThat(Piece.createBlack(Piece.Type.NO_PIECE).getType()).isNotEqualTo(pieceType);
    }

    @Test
    @DisplayName("흰색 기물들의 정상 representation 테스트")
    public void whitePieces_representation_test() {
        char whitePieceRepresentation = 'p';
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);


        whitePieceRepresentation = 'r';
        assertThat(Piece.Type.ROOK.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);

        whitePieceRepresentation = 'n';
        assertThat(Piece.Type.KNIGHT.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);

        whitePieceRepresentation = 'b';
        assertThat(Piece.Type.BISHOP.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);

        whitePieceRepresentation = 'q';
        assertThat(Piece.Type.QUEEN.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);

        whitePieceRepresentation = 'k';
        assertThat(Piece.Type.KING.getWhiteRepresentation()).isEqualTo(whitePieceRepresentation);
    }

    @Test
    @DisplayName("검은색 기물들의 정상 representation 테스트")
    public void blackPieces_representation_test() {
        char blackPieceRepresentation = 'P';
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);

        blackPieceRepresentation = 'R';
        assertThat(Piece.Type.ROOK.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);

        blackPieceRepresentation = 'N';
        assertThat(Piece.Type.KNIGHT.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);

        blackPieceRepresentation = 'B';
        assertThat(Piece.Type.BISHOP.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);

        blackPieceRepresentation = 'Q';
        assertThat(Piece.Type.QUEEN.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);

        blackPieceRepresentation = 'K';
        assertThat(Piece.Type.KING.getBlackRepresentation()).isEqualTo(blackPieceRepresentation);
    }

    @Test
    @DisplayName("기물들의 비정상 representation 테스트")
    public void pieces_representation_error_test() {
        char whitePawnRepresentation = 'p';
        assertThat(Piece.Type.ROOK.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);
        assertThat(Piece.Type.KNIGHT.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);
        assertThat(Piece.Type.BISHOP.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);
        assertThat(Piece.Type.QUEEN.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);
        assertThat(Piece.Type.KING.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);
        assertThat(Piece.Type.NO_PIECE.getWhiteRepresentation()).isNotEqualTo(whitePawnRepresentation);


        char blackPawnRepresentation = 'P';
        assertThat(Piece.Type.ROOK.getBlackRepresentation()).isNotEqualTo(blackPawnRepresentation);
        assertThat(Piece.Type.KNIGHT.getBlackRepresentation()).isNotEqualTo(blackPawnRepresentation);
        assertThat(Piece.Type.BISHOP.getBlackRepresentation()).isNotEqualTo(blackPawnRepresentation);
        assertThat(Piece.Type.QUEEN.getBlackRepresentation()).isNotEqualTo(blackPawnRepresentation);
        assertThat(Piece.Type.KING.getBlackRepresentation()).isNotEqualTo(blackPawnRepresentation);
        assertThat(Piece.Type.NO_PIECE.getBlackRepresentation()).isNotEqualTo(whitePawnRepresentation);
    }

    @Test
    @DisplayName("흰색 기물들의 정상 Color 테스트")
    public void whitePieces_color_test() {
        Piece.Color whiteColor = Piece.Color.WHITE;

        verifyPieceColor(Piece.createWhite(Piece.Type.PAWN), whiteColor);
        verifyPieceColor(Piece.createWhite(Piece.Type.ROOK), whiteColor);
        verifyPieceColor(Piece.createWhite(Piece.Type.KNIGHT), whiteColor);
        verifyPieceColor(Piece.createWhite(Piece.Type.BISHOP), whiteColor);
        verifyPieceColor(Piece.createWhite(Piece.Type.QUEEN), whiteColor);
        verifyPieceColor(Piece.createWhite(Piece.Type.KING), whiteColor);
    }

    @Test
    @DisplayName("검색 기물들의 정상 Color 테스트")
    public void blackPieces_color_test() {
        Piece.Color blackColor = Piece.Color.BLACK;

        verifyPieceColor(Piece.createBlack(Piece.Type.PAWN), blackColor);
        verifyPieceColor(Piece.createBlack(Piece.Type.ROOK), blackColor);
        verifyPieceColor(Piece.createBlack(Piece.Type.KNIGHT), blackColor);
        verifyPieceColor(Piece.createBlack(Piece.Type.BISHOP), blackColor);
        verifyPieceColor(Piece.createBlack(Piece.Type.QUEEN), blackColor);
        verifyPieceColor(Piece.createBlack(Piece.Type.KING), blackColor);
    }

    private void verifyPieceColor(Piece piece, Piece.Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기물들의 비정상 color 테스트")
    public void pieces_color_error_test() {
        Piece.Color whiteColor = Piece.Color.WHITE;
        verifyPieceColorError(Piece.createBlack(Piece.Type.PAWN), whiteColor);
        verifyPieceColorError(Piece.createBlack(Piece.Type.ROOK), whiteColor);
        verifyPieceColorError(Piece.createBlack(Piece.Type.KNIGHT), whiteColor);
        verifyPieceColorError(Piece.createBlack(Piece.Type.BISHOP), whiteColor);
        verifyPieceColorError(Piece.createBlack(Piece.Type.QUEEN), whiteColor);
        verifyPieceColorError(Piece.createBlack(Piece.Type.KING), whiteColor);

        Piece.Color blackColor = Piece.Color.BLACK;
        verifyPieceColorError(Piece.createWhite(Piece.Type.PAWN), blackColor);
        verifyPieceColorError(Piece.createWhite(Piece.Type.ROOK), blackColor);
        verifyPieceColorError(Piece.createWhite(Piece.Type.KNIGHT), blackColor);
        verifyPieceColorError(Piece.createWhite(Piece.Type.BISHOP), blackColor);
        verifyPieceColorError(Piece.createWhite(Piece.Type.QUEEN), blackColor);
        verifyPieceColorError(Piece.createWhite(Piece.Type.KING), blackColor);

    }

    private void verifyPieceColorError(Piece piece, Piece.Color color) {
        assertThat(piece.getColor()).isNotEqualTo(color);
    }

    @Test
    @DisplayName("아무 기물도 없는 Piece의 Color 테스트")
    public void noPiece_color_test() {
        Piece blankPiece = Piece.createBlank();

        assertThat(blankPiece.getColor()).isEqualTo(Piece.Color.NOCOLOR);
    }

    @Test
    @DisplayName("아무 기물도 없는 Piece의 Type 테스트")
    public void noPiece_type_test() {
        Piece blankPiece = Piece.createBlank();

        assertThat(blankPiece.getType()).isEqualTo(Piece.Type.NO_PIECE);
    }

    @Test
    @DisplayName("아무 기물도 없는 Piece의 representation 테스트")
    public void noPiece_representation_test() {
        Piece blankPiece = Piece.createBlank();

        assertThat(blankPiece.getType().getWhiteRepresentation()).isEqualTo(Piece.Type.NO_PIECE.getWhiteRepresentation());
    }


}
