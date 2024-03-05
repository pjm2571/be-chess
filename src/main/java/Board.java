import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> pawns;
    private int size;

    Board() {
        pawns = new ArrayList<>();
        size = 0;
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
        size += 1;
    }

    public int getSize() {
        return size;
    }

    public Pawn findPawn(int pawnIndex) {
        return pawns.get(pawnIndex);
    }
}
