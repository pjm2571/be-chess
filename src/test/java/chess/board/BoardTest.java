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
    @DisplayName("보드에 위치한 Piece들의 개수가 정상적으로 64개가 되는 지 테스트")
    public void piece_size_test() {
        board.initialize();

        assertThat(board.getSize()).isEqualTo(64);
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
}
