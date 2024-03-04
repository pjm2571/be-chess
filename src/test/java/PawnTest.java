import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    private final static String BLACK = "black";
    private final static String WHITE = "white";

    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성 테스트")
    public void create() {
        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    private void verifyPawn(String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}
