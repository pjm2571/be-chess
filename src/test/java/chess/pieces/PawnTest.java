package chess.pieces;

import colors.color;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성 테스트")
    public void create() {
        verifyPawn(color.WHITE);
        verifyPawn(color.BLACK);
    }

    private void verifyPawn(color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("매개변수 없는 폰의 생성 테스트")
    public void create_with_non_color() {
        Pawn pawn = new Pawn();
        assertEquals(color.WHITE, pawn.getColor());
    }


}
