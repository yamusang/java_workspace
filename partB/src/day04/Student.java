package day04;

public class Student {
    private String name;
    private int grade;

    // 기본 생성자
    // 인자로 전달 받는 값은 없지만 (개발자가) name과 age 변수를 임의의 값으로 초기화
    public Student() {
        name = "Anonymous";
        grade = 1;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }

    // 참고 : toString은 문자열을 리턴받음
    // 직접 출력문을 실행하여 변수값을 출력하는 인스턴스 메소드
    public static void main(String[] args) {
        Student s = new Student();
        s.printInfo();
    }
}