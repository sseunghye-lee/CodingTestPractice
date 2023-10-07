package inflearn_introductory.section2;

import java.util.Scanner;

class Fibonacci {
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        /* 배열 쓰지 않고
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
         */

        return answer;
    }

    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int x : T.solution(n)) System.out.print(x + " ");
    }
}
