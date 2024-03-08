package chess.board;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;

import static chess.pieces.Piece.*;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("Board의 showBoard 정상 출력 테스트")
    public void showBoard_test() {
        board.initialize();

        String blankRank = StringUtils.appendNewLine("........");

        assertThat(board.showBoard()).isEqualTo(
                StringUtils.appendNewLine("RNBQKBNR") +
                        StringUtils.appendNewLine("PPPPPPPP") +
                        blankRank +
                        blankRank +
                        blankRank +
                        blankRank +
                        StringUtils.appendNewLine("pppppppp") +
                        StringUtils.appendNewLine("rnbqkbnr"));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("좌표를 입력받아 좌표에 해당하는 기물을 찾는 테스트")
    public void find_piece_at_board_test() {
        board.initialize();

        assertThat(board.findPieceByPosition("a8")).isEqualTo(Piece.createPiece(Color.BLACK, Type.ROOK));

        assertThat(board.findPieceByPosition("h1")).isEqualTo(Piece.createPiece(Color.WHITE, Type.ROOK));

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("좌표를 입력받아 좌표에 해당하는 기물을 find 오류 테스트")
    public void find_piece_at_board_error_test() {
        board.initialize();

        assertThat(board.findPieceByPosition("a8")).isNotEqualTo(Piece.createPiece(Color.NOCOLOR, Type.NO_PIECE));

        assertThat(board.findPieceByPosition("h1")).isNotEqualTo(Piece.createPiece(Color.NOCOLOR, Type.NO_PIECE));

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("빈 보드에서 A8 위치에 흰색 폰을 추가하는 테스트")
    public void create_emptyBoard_set_whitePawn_to_A8() {
        board.initializeEmpty();

        String position = "a8";
        Piece whitePawn = Piece.createPiece(Color.WHITE, Type.PAWN);
        board.setPiece(position, whitePawn);

        assertThat(board.findPieceByPosition(position)).isEqualTo(whitePawn);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("모든 흰색 기물들이 가로로 포인트 계산")
    public void calculate_point() {
        board.initialize();
        double expectedResult = 1.0 * 8 // 폰 8개
                + 2.5 * 2   // 나이트 2개
                + 5.0 * 2   // 룩 2개
                + 3.0 * 2   // 비숍 2개
                + 9.0       // 퀸 1개
                + 0.0;      // 킹 1개

        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(expectedResult);
        System.out.println(board.calculatePoint(Piece.Color.WHITE));
    }

    @Test
    @DisplayName("폰이 세로로 있을 경우의 포인트 계산")
    public void calculate_point_pawn_within_column() {
        board.initializeEmpty();

        //.KR.....  8
        //P.PB....  7
        //.P..Q...  6
        //........  5
        //.....nq.  4
        //.....p.p  3
        //.....pp.  2
        //....rk.. 1
        //abcdefgh

        board.setPiece("b8", Piece.createPiece(Piece.Color.BLACK, Piece.Type.KING));
        board.setPiece("c8", Piece.createPiece(Piece.Color.BLACK, Piece.Type.ROOK));

        board.setPiece("a7", Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN));
        board.setPiece("c7", Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN));
        board.setPiece("d7", Piece.createPiece(Piece.Color.BLACK, Piece.Type.BISHOP));

        board.setPiece("b6", Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN));
        board.setPiece("e6", Piece.createPiece(Piece.Color.BLACK, Piece.Type.QUEEN));

        assertThat(board.calculatePoint(Piece.Color.BLACK)).isEqualTo(20.0);

        board.setPiece("f4", Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        board.setPiece("g4", Piece.createPiece(Piece.Color.WHITE, Piece.Type.QUEEN));

        board.setPiece("f3", Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        board.setPiece("h3", Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));

        board.setPiece("f2", Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        board.setPiece("g2", Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));

        board.setPiece("e1", Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));
        board.setPiece("f1", Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING));


        System.out.println(board.showBoard());

        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(19.5);

    }

    @Test
    @DisplayName("흰색 폰이 세로로 8개 있을 경우의 포인트 계산")
    public void calculate_point_all_pawn_in_one_column() {
        double expectedPoint = 0.5 * 8;
        board.initializeEmpty();

        for (int row = 8; row >= 1; row--) {
            board.setPiece("a" + row, Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        }

        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(expectedPoint);
    }

    @Test
    @DisplayName("흰색 기물들의 점수 내림차순 정렬 테스트")
    public void board_descending_sort_test() {
        board.initialize();

        ArrayList<Piece> expectedResult = new ArrayList<>();
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.QUEEN));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));

        for (int i = 0; i < 8; i++) {
            expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        }

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING));


        ArrayList<Piece> whitePieces = board.getPiecesInAscendingPoint(Piece.Color.WHITE);

        assertThat(whitePieces).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("흰색 기물들의 점수 오름차순 정렬 테스트")
    public void board_ascending_sort_test() {
        board.initialize();

        ArrayList<Piece> expectedResult = new ArrayList<>();
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.QUEEN));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));

        for (int i = 0; i < 8; i++) {
            expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        }

        expectedResult.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING));

        ArrayList<Piece> whitePieces = board.getPiecesInAscendingPoint(Piece.Color.WHITE);

        Collections.reverse(expectedResult);

        assertThat(whitePieces).isNotEqualTo(expectedResult);
    }

    @Test
    @DisplayName("b2 기물을 b3 위치로 옮기는 테스트")
    public void move_b2_to_b3(){
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";

        board.movePiece(sourcePosition, targetPosition);

        assertThat(Piece.createPiece(Color.NOCOLOR, Type.NO_PIECE)).isEqualTo(board.findPieceByPosition(sourcePosition));
        assertThat(Piece.createPiece(Color.WHITE, Type.PAWN)).isEqualTo(board.findPieceByPosition(targetPosition));
    }

}
