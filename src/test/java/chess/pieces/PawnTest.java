package chess.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    private final static String ERROR = "[ERROR]";

    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성 테스트")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("파란색 폰의 생성 시 예외 테스트")
    public void create_with_blue_color() {
        String color = "blue";

        assertThatThrownBy(() -> new Pawn(color))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("공백을 입력한 폰의 생성 테스트")
    public void create_with_blank() {
        String color = "";

        assertThatThrownBy(() -> new Pawn(color))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("색상에 대소문자가 섞여있는 흰색 폰과 검정색 폰의 생성 테스트")
    public void create_with_up_and_low_case() {
        String pawnColor = "wHiTE";

        String expectedColor = "white";

        Pawn pawn = new Pawn(pawnColor);
        assertThat(pawn.getColor()).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("색상에 공백이 섞여있는 폰의 생성 테스트")
    public void create_with_mixed_blank_color() {
        String pawnColor = "    B L A C K   ";

        String expectedColor = "black";

        Pawn pawn = new Pawn(pawnColor);
        assertThat(pawn.getColor()).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("매개변수 없는 폰의 생성 테스트")
    public void create_with_non_color() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

}
