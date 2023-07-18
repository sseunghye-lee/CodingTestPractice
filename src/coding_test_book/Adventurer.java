package coding_test_book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Adventurer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int result = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            count += 1;

            if(count >= list.get(i)) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);

    }
}
