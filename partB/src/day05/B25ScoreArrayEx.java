package day05;

import java.util.Arrays;

public class B25ScoreArrayEx {
    public static void main(String[] args) {
        StudentScore sana = new StudentScore();
        StudentScore momo = new StudentScore("김모모", 78, 100, 88);

        sana.updateScores(99, 90, 89);
        momo.setKor(92);
        System.out.println();
        System.out.println(
                "sana성적" + Arrays.toString(sana.getScores()) + "avg:" + sana.getAverage() + "," + sana.getGrade()
                        + "최고점수:" + sana.getMaxScore() + "최저점수:" + sana.getMinScore());
        System.out.println(
                "momo성적" + Arrays.toString(momo.getScores()) + "avg:" + momo.getAverage() + "," + momo.getGrade()
                        + "최고점수:" + momo.getMaxScore() + "최저점수" + momo.getMinScore());

    }
}

class StudentScore {
    private String name;
    private int[] scores;

    // final 키워드는 변수의 값을 변경할 수 없도록 설정합니다.
    private static final int KOR = 0;
    private static final int ENG = 1;
    private static final int MATH = 2;

    public StudentScore() {
        this.scores = new int[3];
    }

    public StudentScore(String name, int kor, int eng, int math) {
        // 자신의 기본 생성자 호출. this가 생성된 객체 자신. 첫줄에 작성
        this();
        this.name = name;
        // this.scores = new int[3];
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return scores[KOR];
    }

    public void setKor(int kor) {
        this.scores[KOR] = kor;
    }

    public int getEng() {
        return scores[ENG];
    }

    public void setEng(int eng) {
        this.scores[ENG] = eng;
    }

    public int getMath() {
        return scores[MATH];
    }

    public void setMath(int math) {
        this.scores[MATH] = math;
    }

    public int[] getScores() {
        return scores.clone(); // 외부에서 배열 요소를 변경할 수 없도록 새로운 배열 리턴
        // return this.scores; 참조값 리턴
    }

    public int getTotal() {
        int total = 0;
        for (int score : scores) { // score = scores[i]
            total += score;
        }
        return total;
    }

    // 평균 계산 - 소수점 이하 둘째자리로 리턴
    public double getAverage() {
        return Math.floor((double) getTotal() / scores.length * 100) / 100;
    }

    public String getGrade() {
        int avg = (int) getAverage();
        return switch (avg / 10) { // 몫
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    public void updateScores(int kor, int eng, int math) {
        this.scores[KOR] = kor;
        this.scores[ENG] = eng;
        this.scores[MATH] = math;
    }

    public int getMaxScore() {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public int getMinScore() {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }
}