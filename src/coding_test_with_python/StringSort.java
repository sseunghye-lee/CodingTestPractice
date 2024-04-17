package coding_test_with_python;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Character> result = new ArrayList<>();
        int value = 0;

        for(int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            } else {
                value += str.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

        if(value != 0) System.out.println(value);
    }
}
