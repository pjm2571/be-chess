package chess;

import chess.pieces.Piece;
import chess.pieces.Symbol;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private final List<List<Piece>> pieces = new ArrayList<>();

    public void initialize() {
        addBlackPieces();
        addNoPieces();
        addWhitePieces();
    }

    public int getSize() {
        return pieces.stream()
                .mapToInt(List::size)
                .sum();
    }

    private void addNoPieces() {
        for (int row = 0; row < 4; row++) {
            List<Piece> noPieces = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                noPieces.add(Piece.createBlank());
            }
            pieces.add(noPieces);
        }
    }

    private void addBlackPieces() {
        List<Piece> blackPieces = new ArrayList<>();

        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.QUEEN));
        blackPieces.add(Piece.createBlack(Piece.Type.KING));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        pieces.add(blackPieces);

        addBlackPawns();
    }

    private void addWhitePieces() {
        addWhitePawns();

        List<Piece> whitePieces = new ArrayList<>();

        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.QUEEN));
        whitePieces.add(Piece.createWhite(Piece.Type.KING));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));

        pieces.add(whitePieces);

    }

    private void addBlackPawns() {
        List<Piece> blackPawns = new ArrayList<>();

        addPawns(blackPawns, Piece.createBlack(Piece.Type.PAWN));

        pieces.add(blackPawns);
    }

    private void addWhitePawns() {
        List<Piece> whitePieces = new ArrayList<>();

        addPawns(whitePieces, Piece.createWhite(Piece.Type.PAWN));

        pieces.add(whitePieces);
    }

    private void addPawns(List<Piece> pawns, Piece pawn) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pawns.add(pawn);
        }
    }


    public String showBoard() {
        return pieces.stream()
                .map(row -> row.stream()
                        .map(Piece::getRepresentation)
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString())
                .map(StringUtils::appendNewLine)
                .collect(Collectors.joining());
    }
}
