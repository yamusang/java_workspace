package day06;

public class C05MyShapeParent {
    public static void main(String[] args) {
        Shape s1 = new Circle(30, 30, 30, 30, "gray");
        s1.draw();
        System.out.println(s1.calcArea());
        Shape s3 = new Rectangle(10, 10, 10, 10, "red");
        s3.draw();
        System.out.println(s3.calcArea());
        Shape s4 = new Triangle(20, 20, 20, 20, "blue");
        s4.draw();
        System.out.println(s4.calcArea());
        s4.calcArea();
        Shape s2 = new Shape(13, 14, 30, 40, "green");
        s2.draw();

    }
}

class Shape {
    private static int count;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String color;
    private int id;

    void move(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void color(String color) {
        this.color = color;
    }

    void draw() {
        System.out.println(posX);
        System.out.println(posY);
        System.out.println(width);
        System.out.println(height);
        System.out.println(color);
        System.out.println(id);
    }

    double calcArea() {
        return width * height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    Shape() {
        count++;
        this.id = count;
        this.color = "black";

    }

    // 커스텀 생성자는 상속되지 않음
    Shape(int posX, int posY, int width, int height, String color) {
        this();
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.color = color;

    }

}

class Rectangle extends Shape {

    Rectangle() {
        super();
    }

    Rectangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    double calcArea() {
        // TODO Auto-generated method stub
        return super.calcArea();
    }

    @Override
    void draw() {
        // TODO Auto-generated method stub
        System.out.println(
                "사각형:" + this.getPosX() + "," + this.getPosY() + "," + this.getWidth() + "," + this.getHeight() + ","
                        + this.getColor() + "," + this.getId());
    }
}

class Triangle extends Shape {
    Triangle() {
        super();
    }

    Triangle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    double calcArea() {
        // TODO Auto-generated method stub
        return this.getWidth() * this.getHeight() / 2;
    }

    @Override
    void draw() {
        // TODO Auto-generated method stub
        System.out.println(
                "삼각형:" + this.getPosX() + "," + this.getPosY() + "," + this.getWidth() + "," + this.getHeight() + ","
                        + this.getColor() + "," + this.getId());
    }
}

class Circle extends Shape {
    Circle() {
        super();
    }

    Circle(int posX, int posY, int width, int height, String color) {
        super(posX, posY, width, height, color);
    }

    @Override
    double calcArea() {
        // TODO Auto-generated method stub
        return this.getWidth() / 2 * this.getWidth() / 2 * 3.14;
    }

    @Override
    void draw() {
        // TODO Auto-generated method stub
        System.out.println(
                "원:" + this.getPosX() + "," + this.getPosY() + "," + this.getWidth() + "," + this.getHeight() + ","
                        + this.getColor() + "," + this.getId());
    }
}