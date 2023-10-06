package inflearn_introductory.section1;

import java.util.Scanner;

class Palindrome {
    public String solution(String str) {
        String answer = "YES";

        /* 1번째 방법
        str = str.toUpperCase();

        int len = str.length();

        for(int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len - i - 1)) return "NO";
        }
         */

        // 2번째 방법
        String tmp = new StringBuilder(str).reverse().toString();
        if(!str.equalsIgnoreCase(tmp)) return "NO";

        return answer;
    }

    public static void main(String[] args) {
        Palindrome T = new Palindrome();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
