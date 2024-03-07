package chess.board;

public class Position {
    private int pieceIndex;
    private int rankIndex;

    Position(String position) {
        setIndex(position);
        indexRangeCheck();
    }

    private void setIndex(String position) {
        setPieceIndex(position.charAt(0));
        setRankIndex(position.charAt(1));
    }

    private void setPieceIndex(char pieceIndexValue) {
        this.pieceIndex = pieceIndexValue - 'a';
    }

    private void setRankIndex(char rankIndexValue) {
        this.rankIndex = rankIndexValue - '1';
    }

    /* 예외 처리!? */
    private void indexRangeCheck() {
        if (pieceIndex < 0 || pieceIndex > 7 || rankIndex < 0 || rankIndex > 7) {
            System.out.println(pieceIndex + "/ " + rankIndex);
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPieceIndex(){
        return pieceIndex;
    }

    public int getRankIndex(){
        return rankIndex;
    }

}
