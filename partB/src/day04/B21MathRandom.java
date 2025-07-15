package day04;

import java.util.Arrays;

public class B21MathRandom {
    public static void main(String[] args) {
        int[] result = new int[6];
        int[] balls = new int[45];

        for (int i = 0; i < 45; i++) {
            balls[i] = i + 1; // 명령문이 하나만 반복할 때는 {} 생략
        }

        for (int i = 0; i < 6; i++) {
            // 간단 테스트
            // System.out.println(Math.random());// 0보다 크고 1보다 작은 실수
            double rndNum = Math.random();

            // 1) 공을 뽑을 index 랜덤 만들기
            int range = 45 - i; // 0보다 크고 (45-i)보다 작은 랜덤값으로 범위 줄여나감
            // System.out.print((rndNum * range) + "\t");// 0보다 크고 45보다 작은 실수
            // System.out.println((int) (rndNum * range));
            int ballIndex = (int) (rndNum * range);

            // 2) 랜덤 인덱스로 공 뽑기 -> result 배열에 저장
            result[i] = balls[ballIndex];
            // 3) ballIndex위치의 값은 빼고 복사하여 새로운 배열로 계속하기
            balls = newBalls(balls, ballIndex);
            // (1) 리턴 저장 ball 주소 (2) 인자의 balls 주소 : 배열 이름은 동일. 주소는 다름
            // (2)번은 newBalls 실행하고 나면 참조되지 않는다. => JVM이 GC(Garbage Collection)한다.
            // 🔥메모리 누수 : 참조는 되고 있으나 사용하지 않는다.
            System.out.println((ballIndex));
            System.out.println(Arrays.toString(result));
            System.out.println(Arrays.toString(balls));
        }

    }

    // 선생님 코드

    private static int[] newBalls(int[] balls, int ballIndex) {
        int[] result = new int[balls.length - 1];
        System.arraycopy(balls, 0, result, 0, ballIndex);
        System.arraycopy(balls, ballIndex + 1, result, ballIndex, balls.length - 1 -
                ballIndex);
        return result;

    }

    // 뽑힌 공 인덱스 ballIndex의 값을 빼고 새로운 배열 만들기
    // private static int[] newBalls(int[] balls, int ballIndex) {
    // int[] arr1 = new int[ballIndex];
    // int[] arr2 = new int[balls.length - ballIndex];
    // for (int i = 0; i < ballIndex; i++) {
    // arr1[i] = balls[i];
    // }
    // for (int i = 0; i < balls.length - ballIndex; i++) {
    // arr2[i] = balls[i];
    // }
    // int[] result = new int[arr1.length + arr2.length];
    // System.arraycopy(arr1, 0, result, 0, arr1.length);
    // System.arraycopy(arr2, 0, result, arr2.length, 0);
    // return result;
    // }

    // 배열 복사 메소드 : System 클래스에 있음.
    // System 클래스 메소드의 복사를 활용해보세요.

    // 두 배열 합치기
    private static int[] mergeOfArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, 0);
        int i;
        // arr1을 target 배열 result에 복사
        for (i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        // arr2을 target 배열 result에 복사
        // 첫번째 반복문이 끝나면 result 인덱스 변수 i = arr1.length부터 시작하기
        for (i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }

        return result; // 배열의 참조값을 전달하기
    }
}
