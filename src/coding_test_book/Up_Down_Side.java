package coding_test_book;

import java.util.Scanner;

public class Up_Down_Side {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        String[] travel = sc.nextLine().split(" ");

        int x = 1;
        int y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] move = {'L', 'R', 'U', 'D'};

        for(int i = 0; i < travel.length; i++) {
            char go = travel[i].charAt(0);

            int nx = -1;
            int ny = -1;

            for(int j = 0; j < 4; j++) {
                if(go == move[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }

            }

            if(nx < 1 || ny < 1 || nx > n || ny > n) continue;

            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }

}
