package inflearn.section5;

import java.util.*;
class Max_people {
    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;
        int sum[] = new int[n + 1];

        for(int[] t: trans) {
            sum[t[0]] += t[2];
            sum[t[1]] -= t[2];
        }

        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }

        int booking = bookings.length;
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]); // 승차역 오름차순 정렬
        LinkedList<Integer> train = new LinkedList<>();
        int search = 0;
        for(int i = 1; i <= n; i++) {
            while(!train.isEmpty() && train.peek() == i) { // peek 가장 앞
                answer++;
                train.pollFirst();
            }
            while(search < booking && bookings[search][0] == i) {
                train.add(bookings[search][1]); // 하차 옆 넣음
                search++;
            }
            Collections.sort(train); // 오름차순 정렬
            while(train.size() > sum[i]) {
                train.pollLast();
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Max_people T = new Max_people();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
