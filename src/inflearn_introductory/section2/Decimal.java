package inflearn_introductory.section2;

import java.util.Scanner;

class Decimal {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1]; // 인덱스 번호 n+1까지 해야함. n번 인덱스를 만들기 위함
        for(int i = 2; i <= n; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= n; j = j + i) { // j는 i의 배수로 돌아야함
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Decimal T = new Decimal();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
