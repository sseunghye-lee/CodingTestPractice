package baekjoon;
import java.util.Scanner;

public class Alarm_Clock {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        if (m < 45) {
            h -= 1;
            if (h < 0) {
                h = 23;
            }
            m = 60 - (45 - m);
        } else {
            m -= 45;
        }

        System.out.println(h + " " + m);
    }
}
