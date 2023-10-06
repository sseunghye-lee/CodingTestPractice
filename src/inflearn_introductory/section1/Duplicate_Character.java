package inflearn_introductory.section1;

import java.util.Scanner;

class Duplicate_Character {
    public String solution(String str) {
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Duplicate_Character T = new Duplicate_Character();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
