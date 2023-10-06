package inflearn_introductory.section1;

import java.util.Scanner;

class Get_Number {
    public int solution(String str) {
        /* 1번째 방법
        int answer = 0;
        for(char x : str.toCharArray()) {
            if(x >= 48 && x <= 57) answer = answer * 10 + (x - 48); // 아스키번호 48은 '0'임
        }
         */

        // 2번째 방법
        String answer = "";

        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) answer += x;
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Get_Number T = new Get_Number();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
