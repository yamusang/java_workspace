package day08;

import java.util.Arrays;

public class C12ProductProblem {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("LG 스탠바이", 450000.89);
        products[1] = new Product("USB 1TB", 42456.34);
        products[2] = new Product("갤럭시 플립", 12345.78);
        products[3] = new Product("아이폰", 42456.12);

        System.out.println(products[0].compareTo(products[1]));

        Arrays.sort(products); // compareTo 재정의가 정확해야 정렬이 됩니다.
        for (Product p : products) {
            System.out.println(p);
        }

        Double a = 123.45; // 래퍼클래스 타입
        Double b = 234.56;

        System.out.println("Double 타입 실수 비교" + a.compareTo(b)); // -1
        System.out.println("Double 타입 실수 비교" + b.compareTo(a)); // 1

        double c = 123.45;
        double d = 234.56;
        System.out.println("double 타입 실수 비교 : " + Double.compare(c, d));
        System.out.println("double 타입 실수 비교 : " + Double.compare(d, c));

        // 얕은 복사 확인을 위한 객체 생성과 전달
        Company c1 = new Company("LG전자", "서울시 서초구");
        products[0].setCompany(c1);
        Product pclone = null;
        try {
            pclone = (Product) products[0].clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone 예외!");
        }
        System.out.println("~~~~~~~~얕은 복사 테스트~~~~~~~~");
        System.out.println("복제 후의 아래 두 객체는 데이터 내용이 같아야 합니다.");
        System.out.println("products[0] : " + products[0]);
        System.out.println("pclone" + pclone);
        System.out.println("\t Product 타입 객체 참조값 확인");
        System.out.println("그러나 복제 후의 아래 두 객체는 주소는 다릅니다.(새로운 객체로 복제)");
        System.out.println(products[0].hashCode() + "," + Integer.toHexString(products[0].hashCode()));
        System.out.println(pclone.hashCode() + "," + Integer.toHexString(pclone.hashCode()));
        // producjt[0]의 company 주소와 복제한 pclone의 company 주소가 같은 얕은 복사
        System.out.println("~~~복제된 객체의 멤버변수");
        System.out.println("~~~멤버변수 Company 객체는 새로운 객체 복사 아니고 참조값 복사. 참조값 동일");
        System.out.println("products[0].getCompany():" + products[0].getCompany());
        System.out.println("pclone.getCompany():" + pclone.getCompany());
        // clone()의 기본 동작이 얕은 복사이므로 멤버 값 중 객체는 참조값을 복사합니다.
        // 깊은 복사는 각각 company 객체가 다른 주소 즉 새로운 객체로 복사되는 것입니다.
    }
}

class Company {
    private String name;
    private String address;

    Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

class Product implements Comparable<Product>, Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String name;
    private double price;
    private Company company;

    // 얕은 복사를 확인하기 위한 객체 정의
    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public int compareTo(Product other) {
        // Product 객체 비교는 '가격'으로 한다.
        return (int) (this.price - other.price); // 1안 강제로 인트로 변환하여 0으로 계산되는 값이 여러개
        // 있을 시 같은 값 처리 됨. 소수점 이하 자리 비교와 정확한 정렬 못함    
        // return Double.compare(this.price, other.price);// 2안
        // return this.price.compareTo(other.price); //3안 단,private Double price;로 변경해야함
    }

    @Override
    public String toString() {
        return String.format("%s (%f)", name, price);
    }
}