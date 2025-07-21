package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("작업 메뉴를 선택하세요.");
            System.out.println("[A]회원 추가 [R] 회원 삭제 [U] 회원 포인트 변경 [S] 회원 목록 [E] 종료");
            String menu = System.console().readLine("선택>>>");
            switch (menu.toUpperCase()) {
                case "A":
                    addMember(list); // 3개의 값을 입력받아 Member 객체 만들기
                    break;
                case "R":
                    int index = Integer.parseInt(System.console().readLine("삭제할 인덱스 입력 >>>>"));
                    list.remove(index);
                    break;
                case "U":
                    index = Integer.parseInt(System.console().readLine("수정할 인덱스 입력"));
                    System.out.println("현재 포인트:" + list.get(index).getPoint());
                    list.get(index).setPoint(Integer.parseInt(System.console().readLine("수정할 포인트 입력")));
                    System.out.println("현재 포인트:" + list.get(index).getPoint());

                    break;
                case "S":
                    for (Member m : list) {
                        System.out.println(m);
                    }
                    break;
                case "E":
                    status = false;
                    break;

                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    break;
            }
        }

    }

    private static void addMember(List<Member> list) {
        Member member = new Member();

        member.setId(Integer.parseInt(System.console().readLine("id>>>")));
        member.setName(System.console().readLine("이름>>>"));
        member.setPoint(100);
        list.add(member);

    };
}
