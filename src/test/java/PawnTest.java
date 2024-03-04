import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PawnTest {
    private final static String BLACK = "black";
    private final static String WHITE = "white";

    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성")
    public void create() {
        StringBuilder pawnColor = new StringBuilder("white");

        Pawn whitePawn = new Pawn(pawnColor.toString());
        assertThat(whitePawn.getColor()).isEqualTo(WHITE);

        pawnColor.setLength(0);

        pawnColor.append("black");
        Pawn blackPawn = new Pawn(pawnColor.toString());
        assertThat(blackPawn.getColor()).isEqualTo(BLACK);
    }

}
