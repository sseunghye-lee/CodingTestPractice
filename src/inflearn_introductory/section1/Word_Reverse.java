package inflearn_introductory.section1;

import java.util.ArrayList;
import java.util.Scanner;

class Word_Reverse {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        /* 1번째 방법
        for(String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
         */

        // 2번째 방법
        for(String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;

            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }

            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Word_Reverse T = new Word_Reverse();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for(String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
