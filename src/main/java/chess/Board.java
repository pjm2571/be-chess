package chess;

import chess.pieces.Piece;
import chess.pieces.Symbol;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private final List<Rank> pieces = new ArrayList<>();

    public void initialize() {
        addBlackPieces();
        addNoPieces();
        addWhitePieces();
    }

    public int getSize() {
        return pieces.size();
    }

    private void addNoPieces() {
        for (int row = 0; row < 4; row++) {
            ArrayList<Piece> noPieces = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                noPieces.add(Piece.createBlank());
            }
            pieces.add(new Rank(noPieces));
        }
    }

    private void addBlackPieces() {
        ArrayList<Piece> blackPieces = new ArrayList<>();

        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.QUEEN));
        blackPieces.add(Piece.createBlack(Piece.Type.KING));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        pieces.add(new Rank(blackPieces));

        addBlackPawns();
    }

    private void addWhitePieces() {
        addWhitePawns();

        ArrayList<Piece> whitePieces = new ArrayList<>();

        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.QUEEN));
        whitePieces.add(Piece.createWhite(Piece.Type.KING));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));

        pieces.add(new Rank(whitePieces));

    }

    private void addBlackPawns() {
        ArrayList<Piece> blackPawns = new ArrayList<>();

        addPawns(blackPawns, Piece.createBlack(Piece.Type.PAWN));

        pieces.add(new Rank(blackPawns));
    }

    private void addWhitePawns() {
        ArrayList<Piece> whitePieces = new ArrayList<>();

        addPawns(whitePieces, Piece.createWhite(Piece.Type.PAWN));

        pieces.add(new Rank(whitePieces));
    }

    private void addPawns(List<Piece> pawns, Piece pawn) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pawns.add(pawn);
        }
    }


    public String showBoard() {
        return "";
    }
}
