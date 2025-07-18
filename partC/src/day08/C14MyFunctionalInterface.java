package day08;

public class C14MyFunctionalInterface {
    public static void main(String[] args) {

        // ITestA 인터페이스 구현한 익명 클래스 정의
        ITestA ta = new ITestA() {
            @Override
            public void testa(String message) {
                System.out.println("testa: " + message);
            }
        };
        ta.testa("오늘은 신나는 금요일!!");

        ITestA ta2 = (message) -> System.out.println("testa:" + message);
        // 인자의 타입 생략 하고 (message)작성 가능
        ta2.testa("굿바이~~");
        // ta2.testa(34);// 오류: 인자 타입은 선언된 String으로 해야함

        ITestC tc = new ITestC() {
            public int testc(int a, int b) {
                return a * b;
            };
        };

        System.out.println(tc.testc(10, 20));

        ITestC tc2 = (a, b) -> a * b;
        int result = tc2.testc(11, 34);
        System.out.println("testc 실행 결과 :" + result);
        ITestC tc3 = (a, b) -> {
            a += 11;
            b += 10;
            return a * b;
        };
        result = tc3.testc(11, 34);
        System.out.println("testc 실행 결과 :" + result);

    }
}

/*
 * 자바의 인터페이스 중에는 인자(개수), 리턴값의 유무 등등에 따라
 * 다양한 형식의 인터페이스가 있습니다. :Consumer,Supplier,Function 등등
 * 특징 : 추상 메소드가 1개만 정의되어있고 이것을 다른 프로그래밍언어의 함수처럼 사용
 * 
 * 함수형 인터페이스를 익명 클래스로 구현할 때 주로 람다식 사용을 합니다.
 * 익명 클래스 : 다른 메소드의 인자로 쓰입니다.
 * 
 * 자바에는
 * 
 */

interface ITestA {
    void testa(String message); // 인자O,리턴X : Consumer(소비자)
}

interface ITestB {
    int testb(); // 인자X,리턴O : Supplier(공급자)
}

interface ITestC {
    int testc(int a, int b); // 인자 O, 리턴 O :Function(함수)
}