package inflearn_introductory.section3;

import java.util.Scanner;

class SumNumber_2 {
    public int solution(int n) {
        int answer = 0, cnt = 1; // cnt는 연속된 자연수의 개수
        n--;
        while(n > 0) {
            cnt++;
            n = n - cnt;

            if(n % cnt == 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        SumNumber_2 T = new SumNumber_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
