package coding_test_book;

import java.util.Scanner;

public class Last_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while(true) {
            int target = (n / k) * k; // n이 k로 나누어 떨어지는 수
            result += (n - target);

            n = target;

            if(n < k)
                break;

            result += 1;
            n /= k;
        }
        result += (n - 1);
        System.out.println(result);
    }
}
