package day02;

public class B07MyCalculatorTest {
    public static void main(String[] args) {
        boolean a = true;
        while (a) {
            String d1 = System.console().readLine("숫자1:");
            String func = System.console().readLine("+-*/ 종료는(5)");
            String d2 = System.console().readLine("숫자2:");
            long data1 = Long.valueOf(d1);
            long data2 = Long.valueOf(d2);

            if (func.equals("+")) {
                System.out.println("결과는" + MyCalculator.add(data1, data2));
            } else if (func.equals("-")) {
                System.out.println("결과는" + MyCalculator.substract(data1, data2));
            } else if (func.equals("*")) {
                System.out.println("결과는" + MyCalculator.multiply(data1, data2));
            } else if (func.equals("/")) {
                if (func.equals(("/")) && d2.equals("0")) {
                    System.out.println("다시 입력하세요.");
                } else {
                    System.out.println("결과는" + MyCalculator.divide(data1, data2));

                }
            } else if (func.equals("5")) {
                a = false;
                System.out.println(Math.addExact(data1, data2));
                System.out.println(Math.subtractExact(data1, data2));
                System.out.println(Math.multiplyExact(data1, data2));
                System.out.println("min:" + Math.min(data1, data2));
                System.out.println("max:" + Math.max(data1, data2));
            }
        }
        // 지금 연습한 MyCalculator 클래스와 유사한 기능의 자바 클래스 Math가 있습니다.

    }

}

class MyCalculator {
    static double add(double data1, double data2) {
        return data1 + data2;
    }

    static double substract(double data1, double data2) {
        return data1 - data2;
    }

    static double multiply(double data1, double data2) {
        return data1 * data2;
    }

    static double divide(double data1, double data2) {
        return data1 / data2;
    }
}