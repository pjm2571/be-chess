package chess;

import chess.pieces.Pawn;
import chess.pieces.Symbols;
import colors.Colors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();
    private String[][] chessBoard = new String[8][8];

    Board() {
        initialize();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int pawnIndex) {
        return pawns.get(pawnIndex);
    }

    private void initialize() {
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

            chessBoard[rowIndex][i] = pawn.getPawnSymbol();
        }
    }

    public String[][] getChessBoard() {
        return chessBoard;
    }
}
