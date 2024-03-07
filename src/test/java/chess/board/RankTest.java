package chess.board;

import chess.pieces.Piece;
import org.junit.jupiter.api.*;
import utils.StringUtils;

import java.util.ArrayList;

import static chess.pieces.Piece.Type.*;

import static org.assertj.core.api.Assertions.*;

public class RankTest {
    @Test
    @DisplayName("체스 보드의 빈 칸 한 줄 출력 테스트 테스트")
    public void rank_blank_representation_test() {
        Rank rank = new Rank(set8pieces(Piece.createBlank()));

        assertThat(rank.getRankRepresentation()).isEqualTo(StringUtils.appendNewLine("........"));
    }

    @Test
    @DisplayName("체스 보드의 흰색 폰 한 줄 출력 테스트")
    public void rank_representation_test() {
        Rank rank = new Rank(set8pieces(Piece.createWhite(PAWN)));

        assertThat(rank.getRankRepresentation()).isEqualTo(StringUtils.appendNewLine("pppppppp"));
    }

    private ArrayList<Piece> set8pieces(Piece piece) {
        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);
        pieces.add(piece);

        return pieces;
    }


    @Test
    @DisplayName("하나의 Rank에서 Pawn Piece의 개수 테스트")
    public void rank_count_test() {

        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());

        Rank rank = new Rank(pieces);

        Piece pawn = Piece.createWhite(PAWN);

        assertThat(rank.findPieceCount(pawn)).isEqualTo(2);
    }

    @Test
    @DisplayName("주어진 위치의 기물 조회 성공 테스트")
    public void piece_find_success_test() {
        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());

        Rank rank = new Rank(pieces);

        assertThat(Piece.createWhite(PAWN)).isEqualTo(rank.getPieceByPieceIndex(2));

        assertThat(Piece.createWhite(PAWN)).isEqualTo(rank.getPieceByPieceIndex(5));
    }

    @Test
    @DisplayName("주어진 위치의 기물 조회 실패 테스트")
    public void piece_find_fail_est() {
        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());

        Rank rank = new Rank(pieces);

        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(1));

        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(3));
        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(4));

        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(6));
        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(7));
        assertThat(Piece.createWhite(PAWN)).isNotEqualTo(rank.getPieceByPieceIndex(8));
    }

    @Test
    @DisplayName("Rank에 존재하는 blank가 아닌 Piece들의 집합 가져오기 성공 테스트")
    public void get_validPieces(){
        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());

        Rank rank = new Rank(pieces);

        ArrayList<Piece> expectedResult = new ArrayList<>();
        expectedResult.add(Piece.createWhite(PAWN));
        expectedResult.add(Piece.createWhite(PAWN));

        assertThat(expectedResult).isEqualTo(rank.getPieces());
    }

    @Test
    @DisplayName("Rank에 존재하는 blank가 아닌 Piece들의 집합을 가져오기실패 테스트")
    public void get_validPieces_fail(){
        ArrayList<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createWhite(PAWN));
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());
        pieces.add(Piece.createBlank());

        Rank rank = new Rank(pieces);

        ArrayList<Piece> expectedResult = new ArrayList<>();
        expectedResult.add(Piece.createWhite(PAWN));
        expectedResult.add(Piece.createWhite(PAWN));

        assertThat(expectedResult).isNotEqualTo(rank.getPieces());
    }


}
