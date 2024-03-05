package chess;

import chess.pieces.Pawn;
import colors.color;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    private Board board;

    @BeforeEach
    public void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드 size 테스트")
    public void addPawn_to_Board() {
        Pawn white = new Pawn(color.WHITE);
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
    }

    @Test
    @DisplayName("체스 보드 findPawn 테스트")
    public void addPawn_and_findPawn() {
        Pawn white = new Pawn(color.WHITE);
        board.add(white);
        assertEquals(white, board.findPawn(0));
    }

}
