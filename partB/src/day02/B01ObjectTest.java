package day02;

/*
 * .java 소스파일에 클래스는 여러개 정의 가능합니다.
 * public 클래스는 1개. public 클래스 이름 = 파일명
 */
public class B01ObjectTest {
    public static void main(String[] args) {
        // Score타입 객체를 생성 -> 변수로 참조
        Score momo = new Score();
        momo.name = "모모";
        momo.kor = 99;
        momo.eng = 89;
        momo.math = 88;

        System.out.println("momo의 정보:" + momo);
        // Score@372f7a8d는 패키지명. 클래스명@객체의 참조값. 객체의 참조값은 필드값 이용해서 만들고 객체의 주소를
        // 찾아갈때 사용
        System.out.println("---" + momo.name + "," + momo.kor + ",+" + momo.eng + "," + momo.math);

        Score momo2 = momo; // momo의 참조값(주소)를 momo2 변수에 저장. 타입은 반드시 Score로 해야함
        System.out.println("---" + momo2.name + "," + momo2.kor + ",+" + momo2.eng + "," + momo2.math);

        momo.name = "momo";
        momo.kor = 100;
        momo.eng = 100;
        momo.math = 100;
        System.out.println(momo);
    }
}

// Score와 관련된 특징값 또는 기능을 정의
class Score {
    // 필드,속성,프로퍼티
    String name; // 학생 이름
    int kor;
    int eng;
    int math;

    // 메소드는 다음 진도에서....
}