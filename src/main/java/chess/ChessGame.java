package chess;

import chess.board.Board;

import java.util.Scanner;

public class ChessGame {
    private final static String MOVE_COMMAND = "move";
    private final static String START_COMMAND = "start";
    private final static String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("시작 : start / 종료 : end");
            System.out.print("입력 > ");

            if (sc.nextLine().equals(START_COMMAND)) {
                Board board = new Board();
                ChessView chessView = new ChessView(board);

                board.initialize();

                while (true) {
                    System.out.println(chessView.showBoard());
                    System.out.print("체스판 명령 입력 > ");

                    String[] commands = sc.nextLine().split(" ");

                    if (commands[0].equals(END_COMMAND)) {
                        System.out.println("체스 게임 종료");
                        break;
                    }

                    if (commands[0].startsWith(MOVE_COMMAND)) {
                        board.movePiece(commands[1], commands[2]);
                    }

                }
                // 추가 구현
            } else if (sc.nextLine().equals(END_COMMAND)) {
                break;
            }
        }

        System.out.println("체스 게임 전체 종료");
        sc.close();

    }


}
