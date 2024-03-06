package chess;

import utils.StringUtils;

import chess.pieces.Pawn;
import chess.colors.Colors;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 size가 0이 되는 테스트")
    public void board_size_0() {
        assertThat(0).isEqualTo(board.size());
    }

    @Test
    @DisplayName("체스 보드 size가 100이 되는 테스트")
    public void board_size_100() {
        int size = 100;
        for (int i = 0; i < size; i++) {
            board.add(new Pawn());
        }
        assertThat(size).isEqualTo(board.size());
    }

    @Test
    @DisplayName("체스 보드 print() 테스트")
    public void board_print() {
        board.initialize();

        String expectedResult =
                "........" + StringUtils.NEWLINE +
                        "♟♟♟♟♟♟♟♟" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE +
                        "♙♙♙♙♙♙♙♙" + StringUtils.NEWLINE +
                        "........" + StringUtils.NEWLINE;

        assertThat(expectedResult).isEqualTo(board.print());
    }

    @Test
    @DisplayName("initialize 직후, 흰색, 검은색 폰들의 Symbol 테스트")
    public void find_pawnSymbols() {
        board.initialize();
        assertThat("♙♙♙♙♙♙♙♙").isEqualTo(board.getPawnSymbols(Colors.WHITE));
        assertThat("♟♟♟♟♟♟♟♟").isEqualTo(board.getPawnSymbols(Colors.BLACK));
    }



}
