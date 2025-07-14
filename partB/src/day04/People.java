package day04;

public class People {
    private String name;
    private int age;
    private boolean isAdult;

    // 1) 기본 생성자는 컴파일러가 자동으로 만들어줍니다.(단, 커스텀 생성자가 없을 때만)
    // ㄴ new People()로 객체 생성할 때 People가 기본 생성자 메소드 실행합니다.

    public People() {
        System.out.println("People 기본 생성자 실행합니다.");
    }

    // 2) 커스텀 생성자
    public People(String name, int age, boolean isAdult) {
        // 인스턴스 변수 초기화
        this.name = name;
        this.age = age;
        this.isAdult = isAdult;
    }

    // 3)커스텀 생성자는 필요한 변수만 초기화하도록 많이 만들 수 있습니다.
    public People(String name) {
        // 인스턴스 변수 초기화
        this.name = name;

    }

    public People(int age) {
        // 인스턴스 변수 초기화
        this.age = age;
    }

    public People(boolean isAdult) {
        // 인스턴스 변수 초기화
        this.isAdult = isAdult;
    }

    // 🔥오버로딩(overloading) : 메소드 이름은 같고, 메소드의 인자가 타입과 개수가 다른 형태
    // 생성자를 포함해서 모든 메소드에 적용.

    // 복습 : 기본생성자를 사용할 때에는 setter 필수
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    // 값을 읽기 위해서 공통적으로 getter 필요
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAdult() {
        return this.isAdult;
    }

    @Override
    public String toString() {
        return String.format("%s - %d %s", this.name, this.age, this.isAdult);
    }
}
