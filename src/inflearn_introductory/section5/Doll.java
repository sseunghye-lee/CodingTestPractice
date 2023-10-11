package inflearn_introductory.section5;

import java.util.Scanner;
import java.util.Stack;

class Doll {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves) {
            for(int i = 0; i < board.length; i++) { // 이차원 배열의 행크기 board[0].length -> 열크기
                if(board[i][pos -1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;

                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Doll T = new Doll();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) moves[i] = sc.nextInt();

        System.out.println(T.solution(board, moves));
    }
}
