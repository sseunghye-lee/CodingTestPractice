package inflearn_introductory.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class EmergencyRoom {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for(Person x : queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        EmergencyRoom T = new EmergencyRoom();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
