package chess;

import chess.pieces.Pawn;
import colors.Colors;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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
        Pawn white = new Pawn(Colors.WHITE);
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(Colors.BLACK);
        board.add(black);
        assertEquals(2, board.size());
    }

    @Test
    @DisplayName("체스 보드 findPawn 테스트")
    public void addPawn_and_findPawn() {
        Pawn white = new Pawn(Colors.WHITE);
        board.add(white);
        assertEquals(white, board.findPawn(0));
    }

    @Test
    @DisplayName("체스 보드 initialize 테스트")
    public void board_initialize() {
        String expectedResult =
                "........\n" +
                "♟♟♟♟♟♟♟♟\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "♙♙♙♙♙♙♙♙\n" +
                "........\n";

        StringBuilder sb = new StringBuilder();

        Arrays.stream(board.getChessBoard())
                .forEach(row -> {
                    Arrays.stream(row).forEach(sb::append);
                    sb.append("\n");
                });

        assertEquals(expectedResult, sb.toString());
    }


}
