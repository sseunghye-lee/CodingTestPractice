package inflearn_introductory.section2;

import java.util.Scanner;

class Rank {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n]; // 0으로 초기화 되어 있음
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Rank T = new Rank();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
