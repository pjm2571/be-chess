package chess;

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
    @DisplayName("보드에 위치한 Piece들의 정상 개수 테스트")
    public void piece_size_test() {
        board.initialize();

        assertThat(board.getSize()).isEqualTo(32);
    }

    @Test
    @DisplayName("Board의 showBoard 정상 출력 테스트")
    public void showBoard_test() {
        board.initialize();

        String blankRank = "........" + StringUtils.NEWLINE;
        assertThat(board.showBoard()).isEqualTo("♜♞♝♛♚♝♞♜" + StringUtils.NEWLINE +
                "♟♟♟♟♟♟♟♟" + StringUtils.NEWLINE +
                blankRank +
                blankRank +
                blankRank +
                blankRank +
                "♙♙♙♙♙♙♙♙" + StringUtils.NEWLINE +
                "♖♘♗♕♔♗♘♖");
    }

}
