public class Pawn {
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    private String pawnColor;

    Pawn() {
        this.pawnColor = WHITE_COLOR;
    }
    Pawn(String pawnColor) {
        setPawnColor(pawnColor);
    }


    private void setPawnColor(String pawnColor) {
        String inputPawnColor = pawnColor.toLowerCase().replace(" ", "");

        if (!inputPawnColor.equals(WHITE_COLOR) && !inputPawnColor.equals(BLACK_COLOR)) {
            throw new IllegalArgumentException("[ERROR] 폰의 색은 white, black 색상만 가능합니다");
        }
        this.pawnColor = inputPawnColor;
    }

    public String getColor() {
        return pawnColor;
    }
}
