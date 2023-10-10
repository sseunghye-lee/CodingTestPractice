package inflearn_introductory.section4;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

class BigNumber {
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    treeSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;

        for(int x : treeSet) {
            cnt++;
            if(cnt == k) return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        BigNumber T = new BigNumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr= new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }
}
