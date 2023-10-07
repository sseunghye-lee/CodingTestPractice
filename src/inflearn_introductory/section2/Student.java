package inflearn_introductory.section2;

import java.util.Scanner;

class Student {
    public int solution(int n, int[] arr) {
        int answer = 1; // 첫번째 사람은 무조건 보임
        int max = arr[0];

        for(int i = 1; i < n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Student T = new Student();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
