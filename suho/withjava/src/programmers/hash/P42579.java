package programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class P42579 {
    public static void main(String[] args) {

    }

    static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Integer>> genreMap = new HashMap<>(); // key: 장르, value: 해당 장르 인덱스 리스트
        HashMap<String, Integer> count = new HashMap<>(); // key: 장르, value: 해당 장르 음악 총 시간

        // 1. map에 넣기
        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            if (genreMap.containsKey(genres[i])) {
                genreMap.get(genres[i]).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                genreMap.put(genres[i], temp);
            }
        }

        // 2. genre 플레이 시간 내림차순 정렬
        ArrayList<String> sortedGenre = new ArrayList<>(count.keySet());
        sortedGenre.sort(((o1, o2) -> count.get(o2) - count.get(o1)));

        // 3. 정답 리스트 길이 찾기
        int size = 0;
        for (String g : genreMap.keySet()) {
            size += Math.min(genreMap.get(g).size(), 2);
        }
        int[] answer = new int[size];
        int idx = 0;

        // 4. 앨범에 들어갈 음악 2개 찾기
        for (String g : sortedGenre) {
            ArrayList<Integer> values = genreMap.get(g);
            // 5. 고유번호를 플레이 시간 내림차순, 고유번호 오름차순으로 정렬
            values.sort((o1, o2) -> {
                if (plays[o1] == plays[o2]) {
                    return o1 - o2;
                }
                return plays[o2] - plays[o1];
            });
            // 6. 1번, 2번 뽑아내기
            if (values.size() <= 1) {
                answer[idx++] = values.get(0);
            } else {
                answer[idx++] = values.get(0);
                answer[idx++] = values.get(1);
            }
        }
        return answer;
    }
}
