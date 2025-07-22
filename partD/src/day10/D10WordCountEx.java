package day10;

import java.util.HashMap;
import java.util.Map;

public class D10WordCountEx {
    public static void main(String[] args) {
        String lyrics = "Longing for you\r\n" + //
                "Waiting for you\r\n" + //
                "Hold me\r\n" + //
                "Hold me in your eyes\r\n" + //
                "너라는 걸\r\n" + //
                "너뿐인 걸 모르겠니\r\n" + //
                "I will be your love\r\n" + //
                "\r\n" + //
                "오 빨간 운동화 짧은 청바지\r\n" + //
                "참 어째도 해결이 안 될 것 같은 곱슬머리\r\n" + //
                "하지만 왜일까 자꾸 끌리는 내 마음이\r\n" + //
                "어쩌면 사랑 아닐까\r\n" + //
                "\r\n" + //
                "Longing for you\r\n" + //
                "Waiting for you\r\n" + //
                "Hold me\r\n" + //
                "Hold me in your eyes\r\n" + //
                "너라는 걸\r\n" + //
                "너뿐인 걸 모르겠니\r\n" + //
                "I will be your love\r\n";
        // \s정규식 기호는 공백, 탭, 줄바꿈. 단어로 분리하는 기준
        String[] words = lyrics.split("\\s+");
        System.out.println("단어의 갯수 : " + words.length);

        // 앞의 getOrDefault 메소드를 사용해서 단어가 나온 횟수 Map으로 저장하기
        // 횟수의 합계(sum) = words.length (검증)
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int sum = 0;
        int maxCount = 0;
        StringBuilder sb = new StringBuilder(); // maxCount 단어들을 저장
        for (String key : countMap.keySet()) {
            int val = countMap.get(key);
            System.out.println(key + "(" + val + "회)");
            sum += countMap.get(key); // value(단어의 출현 횟수)
            // 출현 횟수 최대값 찾기
            if (val > maxCount) // 현재의 val와 최대 횟수 maxCount 비교
                maxCount = val;
        }
        // maxCount에 해당하는 단어를 sb에 추가
        for (String key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) { // value가 maxCount와 같은지 비교
                sb.append(key).append(","); // 단어 추가
            }
        }
        System.out.println("출현 단어의 갯수:" + countMap.size()); // 중복된 단어 없이
        System.out.println("단어의 총 출현 횟수:" + sum);
        System.out.println("최다 출현 단어 :" + sb.toString() + "횟수:" + maxCount);
    }
}
