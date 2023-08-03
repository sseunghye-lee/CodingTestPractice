package inflearn.section2;
import java.util.*;
class WarnMail {

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public String[] solution(String[] reports, int time){
        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();

        for(String x : reports) {
            String name = x.split(" ")[0];
            String t = x.split(" ")[1];
            String io = x.split(" ")[2];

            if(io.equals("in")) inT.put(name, getTime(t));
            else sumT.put(name, sumT.getOrDefault(name, 0) + (getTime(t) - inT.get(name))); // 시간 누적 (총 이용시간)
        }

        ArrayList<String> result = new ArrayList<>();
        for(String name : sumT.keySet()) {
            if(sumT.get(name) > time) result.add(name);
        }
        result.sort((a, b) -> a.compareTo(b)); // 이름 사전 순

        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        WarnMail T = new WarnMail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
