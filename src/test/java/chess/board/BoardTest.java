package chess.board;

import org.junit.jupiter.api.*;
import utils.StringUtils;

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

    }

}
