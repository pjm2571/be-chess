package chess.pieces;

import colors.Colors;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    @DisplayName("흰색 폰과 검정색 폰의 생성 테스트")
    public void create() throws Exception {
        verifyPawn(Colors.WHITE);
        verifyPawn(Colors.BLACK);
    }

    private void verifyPawn(Colors Colors) throws Exception {
        Pawn pawn = new Pawn(Colors);

        Object pawnColor = getPawnColor(pawn);

        assertEquals(Colors, pawnColor);
    }

    private Object getPawnColor(Pawn pawn) throws Exception {
        /* chess/pieces/Pawn.java 클래스를 찾는다 */
        Class<?> pawnClass = Class.forName("chess.pieces.Pawn");

        /* pawnClass의 pawnColor field를 찾아온다 */
        Field field = pawnClass.getDeclaredField("pawnColor");

        /* field의 접근 제한자가 private이기 때문에, setAccessible을 true로 설정한다. 하지 않으면 오류! */
        field.setAccessible(true);

        /* field의 color 값을 가져온다. color enum 타입이므로 Object로 받아온다. */
        return field.get(pawn);
    }

    @Test
    @DisplayName("매개변수 없는 폰의 생성 테스트")
    public void create_with_non_color() throws Exception {
        Pawn pawn = new Pawn();

        Object pawnColor = getPawnColor(pawn);

        assertEquals(Colors.WHITE, pawnColor);
    }


}
