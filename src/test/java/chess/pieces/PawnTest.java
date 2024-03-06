package chess.pieces;

import chess.colors.Colors;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성 테스트")
    public void create(){
        verifyPawn(Colors.WHITE);
        verifyPawn(Colors.BLACK);
    }

    private void verifyPawn(Colors pawnColor) {
        Pawn pawn = new Pawn(pawnColor);

        assertThat(pawnColor).isEqualTo(pawn.getPawnColor());
    }

    @Test
    @DisplayName("매개변수 없는 폰의 생성 테스트")
    public void create_with_non_color() {
        Pawn pawn = new Pawn();

        assertThat(Colors.WHITE).isEqualTo(pawn.getPawnColor());
    }

    @Test
    @DisplayName("흰색 폰의 Shape 일치 테스트")
    public void create_pawn_check_shape() {
        Pawn pawn = new Pawn();

        String expectedShape = Symbols.WHITE_PAWN.getSymbolShape();

        assertThat(expectedShape).isEqualTo(pawn.getPawnSymbol());
    }


}
