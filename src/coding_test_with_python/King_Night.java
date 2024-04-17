package coding_test_with_python;

import java.util.Scanner;

public class King_Night {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String place = sc.nextLine();
        int row = place.charAt(1) - '0';
        int column = place.charAt(0) - 'a' + 1;

        int[] dx = {-2, -2, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int result = 0;

        for(int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];

            if(nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
