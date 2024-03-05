package chess;

import chess.pieces.Pawn;
import colors.color;
import org.junit.jupiter.api.*;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 생성 후, 폰을 추가하는 테스트")
    public void create() {
        Pawn white = new Pawn(color.WHITE);
        board.add(white);
        Assertions.assertEquals(1, board.size());
        Assertions.assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(color.BLACK);
        board.add(black);
        Assertions.assertEquals(2, board.size());
        Assertions.assertEquals(black, board.findPawn(1));
    }

}
