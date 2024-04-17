package coding_test_with_python;

import java.util.Scanner;

public class Multi_Or_Plus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        long result = str.charAt(0) - '0';
        for(int i = 1; i < str.length(); i++) {
            int num = str.charAt(i) - '0';

            if(num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }
        System.out.println(result);

    }
}
