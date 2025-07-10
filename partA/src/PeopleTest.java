public class PeopleTest {
    public static void main(String[] args) {
        // People클래스를 이용하여 객체를 만듭니다.
        // -> 객체를 만드는 연산은 new 입니다.
        //변수는 참조형 타입으로 객체의 주소를 저장합니다.
        People sana = new People(); //클래스 타입 변수명 = new 클래스 이름() 
        People momo = new People();

        System.out.println("sana People 객체 정보(속성 기본값 확인)");
        System.out.println("name:"+sana.name); //null(참조형 기본값)
        System.out.println("age:"+sana.age); //0
        System.out.println("age:"+sana.isAdult); //false
        System.out.println("gender:"+sana.gender); //' '
        
        // momo객체에 속성값을 저장하기
        // 객체(Object)는 데이터의 대상이 여러 값(또는 기능/ 메소드)으로 표현될 때 사용.
        momo.name="김모모";
        momo.age=23;
        momo.isAdult=true;
        momo.gender='F';
        
        System.out.println("momo People 객체 정보(속성 저장값 확인)");
        System.out.println("name:"+momo.name); //null(참조형 기본값)
        System.out.println("age:"+momo.age); //0
        System.out.println("isAdult:"+momo.isAdult); //false
        System.out.println("gender:"+momo.gender); //' '
        

        // 참고 : 문자열 객체 생성
        String test = new String();
        String test2 = "트와이스";
    }
}
