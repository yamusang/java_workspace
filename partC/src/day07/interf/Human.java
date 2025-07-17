package day07.interf;

public class Human implements Runnable, Cookable {

    private String hobby;

    @Override
    public String run(int speed) {
        // TODO Auto-generated method stub
        return "달리기 잘함 : 평균속도 - " + speed;
    }

    @Override
    public void cook(String material) {
        System.out.println("오늘은" + material + "저녁 요리를 합니다.");

    }

    @Override
    public String beable() {
        // TODO Auto-generated method stub
        return "취미는" + hobby;
    }

}
