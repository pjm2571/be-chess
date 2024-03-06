package chess;

import chess.pieces.Pawn;
import chess.pieces.Symbols;
import colors.Colors;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();
    private String[][] chessBoard = new String[8][8];


    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int pawnIndex) {
        return pawns.get(pawnIndex);
    }

    public void initialize() {
        setBlank(0);
        setPawn(1, Colors.BLACK);
        setBlank(2);
        setBlank(3);
        setBlank(4);
        setBlank(5);
        setPawn(6, Colors.WHITE);
        setBlank(7);
    }

    private void setBlank(int rowIndex) {
        for (int i = 0; i < 8; i++) {
            chessBoard[rowIndex][i] = ".";
        }
    }

    private void setPawn(int rowIndex, Colors pawnColor) {
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(pawnColor);
            add(pawn);
            chessBoard[rowIndex][i] = pawn.getPawnSymbol();
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(chessBoard)
                .forEach(row -> {
                    Arrays.stream(row).forEach(sb::append);
                    sb.append(StringUtils.appendNewLine());
                });

        return sb.toString();
    }

    public String getPawnSymbols(Colors pawnColor) {
        StringBuilder sb = new StringBuilder();
        pawns.stream()
                .filter(pawn -> pawn.getPawnColor().equals(pawnColor))
                .map(Pawn::getPawnSymbol) // 각 폰을 문자열로 변환합니다. 예시로 toString() 메서드를 사용했습니다.
                .forEach(sb::append); // StringBuilder에 추가합니다.

        return sb.toString();
    }


}
