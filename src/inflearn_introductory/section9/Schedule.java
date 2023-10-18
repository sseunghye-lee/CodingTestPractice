package inflearn_introductory.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int date;
    Lecture(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}
class Schedule {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < n; j++) {
                if(arr.get(j).date < i) break;
                priorityQueue.offer(arr.get(j).money);
            }
            if(!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Schedule T = new Schedule();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }
        System.out.println(T.solution(arr));
    }
}
