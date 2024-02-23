package inflearn.section3;
import java.util.*;

class Dermatology {

    public int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        return h * 60 + m;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];

        for(int i = 0; i < n; i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }

        Queue<Integer> queue = new LinkedList<>(); // 피부과의 대기실
        queue.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for(int t = fT; t <= 1200; t++) { // 1200분 = 20:00
            if(pos < n && t == inList[pos][0]) {
                if(queue.isEmpty() && inList[pos][0] > fT) fT = inList[pos][0]; // 대기실, 레이저실 다 비어있을 때 고객은 바로 레이저실로 들어가야함
                queue.offer(inList[pos][1]);
                pos++;
            }
            if(t == fT && !queue.isEmpty()) {
                int idx = queue.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, queue.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Dermatology T = new Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
