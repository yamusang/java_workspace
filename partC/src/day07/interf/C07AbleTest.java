package day07.interf;

// 다형성
// 인터페이스 구현 클래스는 인터페이스로 대입
// 메소드의 인자 또는 리턴값의타입이 됩니다.
public class C07AbleTest {
    // 🔥인터페이스 구현 객체(Human)를 인터페이스 타입Runnable으로 참조시킬 때,
    // 해당 변수는 다른 인터페이스 Cookable 메소드는 실행할 수 없다.
    public static void main(String[] args) {
        // 인터페이스 구현 객체의 변수 타입. 3가지 모두 가능합니다.
        Human hu = new Human();
        today(hu);
        Cookable hu2 = new Human();
        today(hu2);
        hu2.cook("파스타");
        Runnable hu3 = new Human();
        // hu3.cook("파스타");//오류: 다른 인터페이스 타입으로 참조하였음.
        System.out.println("Cookable인터페이스 상수 : " + Cookable.MAX_TIME);
        // today(hu3); //오류: 다른 인터페이스 타입으로 참조하였음.
        today(new Human()); // new Human() 객체의 주소(참조값)을 메소드에 전달
        // tomorrow(new AI());// 오류
        someday(new AI("GPT"));
        tomorrow(new Dog());

        // 인터페이스 구현하는 익명 클래스 정의
        Cookable robot = new Cookable() {
            @Override
            public void cook(String material) {
                // TODO Auto-generated method stub
                System.out.println("인스턴트 요리를 합니다.");
            }
        };
        today(robot);
    }

    private static void today(Cookable cookable) {
        cookable.cook("라면");
    }

    private static void tomorrow(Runnable runnable) {
        String temp = runnable.run(100);
        System.out.println(temp);
    }

    private static void someday(Thinkable thinkable) {
        thinkable.think("자바");
    }
}
