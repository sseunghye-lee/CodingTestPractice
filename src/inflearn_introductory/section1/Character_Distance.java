package inflearn_introductory.section1;

import java.util.Scanner;

class Character_Distance {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        int p = 1000;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Character_Distance T = new Character_Distance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        for(int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}
