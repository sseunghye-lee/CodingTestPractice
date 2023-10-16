package inflearn_introductory.section8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Coin {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if(sum > m) return; // 무한 안돌기 위함
        if(L >= answer) return; // 더 깊은 레벨의 값은 볼 필요가 없음

        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Coin T = new Coin();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순으로 큰 동전부터 내려가게 해야함 (타임 리미트) - Arrays.sort는 객체형으로 해야하므로 int가 아닌 Integer로 선언

        m = sc.nextInt();

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
