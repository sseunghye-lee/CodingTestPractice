package inflearn_introductory.section5;

import java.util.Scanner;
import java.util.Stack;

class Remove_Parenthesis {
    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == ')') {
                while(stack.pop() != '('); // 여는 괄호 꺼내고 멈춤
            }
            else {
                stack.push(x);
            }
        }

        for(int i = 0; i < stack.size(); i++) answer += stack.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Remove_Parenthesis T = new Remove_Parenthesis();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
