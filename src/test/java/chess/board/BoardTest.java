package chess.board;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;
import utils.StringUtils;

import static chess.pieces.Piece.Type.*;

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

        assertThat(board.findPieceByPosition("a8")).isEqualTo(Piece.createBlack(ROOK));

        assertThat(board.findPieceByPosition("h1")).isEqualTo(Piece.createWhite(ROOK));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("좌표를 입력받아 좌표에 해당하는 기물을 find 오류 테스트")
    public void find_piece_at_board_error_test() {
        board.initialize();

        assertThat(board.findPieceByPosition("a8")).isNotEqualTo(Piece.createBlank());

        assertThat(board.findPieceByPosition("h1")).isNotEqualTo(Piece.createBlank());
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("빈 보드에서 A8 위치에 흰색 폰을 추가하는 테스트")
    public void create_emptyBoard_set_whitePawn_to_A8() {
        board.initializeEmpty();

        String position = "a8";
        Piece whitePawn = Piece.createWhite(PAWN);
        board.move(position, whitePawn);

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

        board.move("b8", Piece.createBlack(KING));
        board.move("c8", Piece.createBlack(ROOK));

        board.move("a7", Piece.createBlack(PAWN));
        board.move("c7", Piece.createBlack(PAWN));
        board.move("d7", Piece.createBlack(BISHOP));

        board.move("b6", Piece.createBlack(PAWN));
        board.move("e6", Piece.createBlack(QUEEN));

        assertThat(board.calculatePoint(Piece.Color.BLACK)).isEqualTo(20.0);

        board.move("f4", Piece.createWhite(KNIGHT));
        board.move("g4", Piece.createWhite(QUEEN));

        board.move("f3", Piece.createWhite(PAWN));
        board.move("h3", Piece.createWhite(PAWN));

        board.move("f2", Piece.createWhite(PAWN));
        board.move("g2", Piece.createWhite(PAWN));

        board.move("e1", Piece.createWhite(ROOK));
        board.move("f1", Piece.createWhite(KING));

        System.out.println(board.showBoard());

        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(19.5);

    }

    @Test
    @DisplayName("흰색 폰이 세로로 8개 있을 경우의 포인트 계산")
    public void calculate_point_all_pawn_in_one_column() {
        double expectedPoint = 0.5 * 8;
        board.initializeEmpty();

        board.move("a8", Piece.createWhite(PAWN));
        board.move("a7", Piece.createWhite(PAWN));
        board.move("a6", Piece.createWhite(PAWN));
        board.move("a5", Piece.createWhite(PAWN));
        board.move("a4", Piece.createWhite(PAWN));
        board.move("a3", Piece.createWhite(PAWN));
        board.move("a2", Piece.createWhite(PAWN));
        board.move("a1", Piece.createWhite(PAWN));

        assertThat(board.calculatePoint(Piece.Color.WHITE)).isEqualTo(expectedPoint);
    }


}
