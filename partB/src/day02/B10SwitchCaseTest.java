package day02;

public class B10SwitchCaseTest {
    public static void main(String[] args) {
        String op; // +,-,*,/값만 사용
        boolean status = true;
        while (status) {
            String d1 = System.console().readLine("숫자1:");
            op = System.console().readLine("연산 선택하기(+,-,*,/) | 종료는 N 입력>>>");
            String d2 = System.console().readLine("숫자2:");
            long data1 = Long.valueOf(d1);
            long data2 = Long.valueOf(d2);
            switch (op) {
                case "+":
                    System.out.println("더하기 선택하셨습니다.");
                    System.out.println("결과는" + MyCalculator.add(data1, data2));
                    break;
                case "-":
                    System.out.println("빼기 선택하셨습니다.");
                    System.out.println("결과는" + MyCalculator.substract(data1, data2));
                    break;
                case "*":
                    System.out.println("곱하기 선택하셨습니다.");
                    System.out.println("결과는" + MyCalculator.multiply(data1, data2));
                    break;
                case "/":
                    System.out.println("나누기 선택하셨습니다.");
                    if (op.equals(("/")) && d2.equals("0")) {
                        System.out.println("다시 입력하세요.");
                    } else {
                        System.out.println("결과는" + MyCalculator.divide(data1, data2));

                    }
                    break;
                case "N", "n":// while 종료 조건
                    status = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.+,-,*,/ 값만 사용합니다.");
                    break;
            }
        }
    }
}
