package inflearn_introductory.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Education {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char x : need.toCharArray()) queue.offer(x);

        for(char x : plan.toCharArray()) {
            if(queue.contains(x)) {
                if(x != queue.poll()) return "NO";
            }
        }

        if(!queue.isEmpty()) return "NO"; // 필수과목 이수 안함

        return answer;
    }

    public static void main(String[] args) {
        Education T = new Education();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.solution(a, b));
    }
}
