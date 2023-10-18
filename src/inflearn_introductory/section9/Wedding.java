package inflearn_introductory.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Visit implements Comparable<Visit> {
    public int time;
    public char state;

    Visit(int time, char state) {
        this.time = time;
        this.state = state;
    }


    @Override
    public int compareTo(Visit o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
class Wedding {
    public int solution(ArrayList<Visit> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for(Visit o : arr) {
            if(o.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Wedding T = new Wedding();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Visit> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Visit(s, 's'));
            arr.add(new Visit(e, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}
