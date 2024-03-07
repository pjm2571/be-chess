package chess.board;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final static int BOARD_LENGTH = 8;
    private final List<Rank> ranks = new ArrayList<>();

    public void initialize() {
        addWhitePieces();

        addNoPieces(4);

        addBlackPieces();
    }

    public void initializeEmpty(){
        addNoPieces(8);
    }

    public int getSize() {
        return ranks.size();
    }

    private void addNoPieces(int rowCount) {
        for (int row = 0; row < rowCount; row++) {
            ArrayList<Piece> noPieces = new ArrayList<>();
            for (int i = 0; i < BOARD_LENGTH; i++) {
                noPieces.add(Piece.createBlank());
            }
            ranks.add(new Rank(noPieces));
        }
    }

    private void addBlackPieces() {
        addBlackPawns();

        ArrayList<Piece> blackPieces = new ArrayList<>();

        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.QUEEN));
        blackPieces.add(Piece.createBlack(Piece.Type.KING));
        blackPieces.add(Piece.createBlack(Piece.Type.BISHOP));
        blackPieces.add(Piece.createBlack(Piece.Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Piece.Type.ROOK));
        ranks.add(new Rank(blackPieces));

    }

    private void addWhitePieces() {

        ArrayList<Piece> whitePieces = new ArrayList<>();

        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.QUEEN));
        whitePieces.add(Piece.createWhite(Piece.Type.KING));
        whitePieces.add(Piece.createWhite(Piece.Type.BISHOP));
        whitePieces.add(Piece.createWhite(Piece.Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Piece.Type.ROOK));

        ranks.add(new Rank(whitePieces));

        addWhitePawns();

    }

    private void addBlackPawns() {
        ArrayList<Piece> blackPawns = new ArrayList<>();

        addPawns(blackPawns, Piece.createBlack(Piece.Type.PAWN));

        ranks.add(new Rank(blackPawns));
    }

    private void addWhitePawns() {
        ArrayList<Piece> whitePieces = new ArrayList<>();

        addPawns(whitePieces, Piece.createWhite(Piece.Type.PAWN));

        ranks.add(new Rank(whitePieces));
    }

    private void addPawns(List<Piece> pawns, Piece pawn) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pawns.add(pawn);
        }
    }

    public Piece findPieceByPosition(String position) {
        int pieceIndex = position.charAt(0) - 'a';
        int rankIndex = position.charAt(1) - '1';
        Rank findRank = ranks.get(rankIndex);
        return findRank.getPieceByPieceIndex(pieceIndex);
    }


    public String showBoard() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = ranks.size() - 1; i >= 0; i--) {
            resultBuilder.append(ranks.get(i).getRankRepresentation());
        }
        return resultBuilder.toString();
    }

    public void move(String position, Piece piece) {
        int pieceIndex = position.charAt(0) - 'a';
        int rankIndex = position.charAt(1) - '1';
        Rank findRank = ranks.get(rankIndex);
        findRank.set(pieceIndex, piece);
    }
}
