public class Pawn {
    private final static String WHITE_COLOR = "white";
    private final static String BLACK_COLOR = "black";
    private String pawnColor;

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
