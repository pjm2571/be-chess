import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    @DisplayName("체스 보드 생성 후, 폰을 추가하는 테스트")
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.getSize());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.getSize());

        assertEquals(black, board.findPawn(1));
    }
}
