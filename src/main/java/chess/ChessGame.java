package chess;

import chess.Board;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Board board = new Board();

        StringBuilder inputCommand;

        while (true) {
            System.out.println("시작 : start / 종료 : end");
            System.out.print("입력 > ");
            inputCommand = new StringBuilder(sc.nextLine());
            if (inputCommand.toString().equals("start")) {
                board.initialize();
                System.out.println(board.showBoard());
                // 추가 구현

            } else if (inputCommand.toString().equals("end")) {
                break;
            }
        }

        System.out.println("체스 게임 종료");
    }
}
