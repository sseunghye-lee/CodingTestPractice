package inflearn_introductory.section1;

import java.util.Scanner;

class Palindrome_ReplaceAll {
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // 대문자가 아닌 것들은 다 빈 문자로 변경해라.

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        Palindrome_ReplaceAll T = new Palindrome_ReplaceAll();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
