import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성")
    public void create() {
        Pawn whitePawn = new Pawn("white");
        assertThat(whitePawn.getColor()).isEqualTo("white");

        Pawn blackPawn = new Pawn("black");
        assertThat(blackPawn.getColor()).isEqualTo("black");
    }
}
