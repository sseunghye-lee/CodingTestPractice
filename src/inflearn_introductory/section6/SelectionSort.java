package inflearn_introductory.section6;

import java.util.Scanner;

class SelectionSort {
    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) { // 마지막은 가장 큰 값으로 굳이 찾지 않아도 됨
            int idx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort T = new SelectionSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
