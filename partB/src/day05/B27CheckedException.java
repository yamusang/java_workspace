package day05;

import java.io.IOException;

public class B27CheckedException {
    public static void main(String[] args) {
        Score s1 = new Score();
        // s1.setScore(-9); // score값 오류 IOException 발생시켰으므로 예외처리 필수

        try {
            s1.setScore(-9); // score값 오류

        } catch (Exception e) {

        }

    }
}

class Score {
    private int score;

    public int getScore() {
        return score;
    }

    // 여기서 직접 try~catch 안하면 사용하는 쪽으로 main으로 위임
    public void setScore(int score) throws IOException {
        if (score >= 0 && score <= 100) {
            this.score = score;

        } else {
            // 잘못된 값 -> 예외 발생 처리
            // throw new IllegalArgumentException("score값 오류!!");//checked예외 X
            throw new IOException("score값 오류");
        }

    }
}