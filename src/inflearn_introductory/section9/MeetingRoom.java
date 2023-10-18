package inflearn_introductory.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    public int start, end;
    Time(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}
class MeetingRoom {
    public int solution(ArrayList<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0;
        for(Time o : arr) {
            if(o.start >= et) {
                cnt++;
                et = o.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MeetingRoom T = new MeetingRoom();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }
        System.out.println(T.solution(arr, n));
    }
}
