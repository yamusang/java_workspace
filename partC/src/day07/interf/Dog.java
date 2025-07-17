package day07.interf;

public class Dog implements Runnable {

    private String type;

    @Override
    public String run(int speed) {
        // TODO Auto-generated method stub
        return "매우 잘 달림 - " + speed;
    }

    @Override
    public String beable() {
        // TODO Auto-generated method stub
        return "짖고 싸우기 잘함!!";
    }

}
