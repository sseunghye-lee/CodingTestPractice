package inflearn_introductory.section1;

import java.util.Scanner;

class Upper_Lowercase {
    public String solution(String str) {
        String answer = "";

        for(char x : str.toCharArray()) {
//            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//            else answer += Character.toLowerCase(x);

            if(x >= 65 && x <= 90) answer += (char) (x + 32);
            if(x >= 97 && x <= 122) answer += (char) (x - 32);
        }

        return answer;
    }

    public static void main(String[] args) {
        Upper_Lowercase T = new Upper_Lowercase();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
