package day09;

import java.util.ArrayList;
import java.util.List;

public class D05MemberManagerApp {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        // list 초기화 메소드 실행
        initMemberList(list); // list 변수 참조값 전달
        System.out.println("회원 관리 프로그램입니다.");
        boolean status = true;
        while (status) {
            System.out.println("작업 메뉴를 선택하세요.");
            System.out.println("[A]회원 추가 [R] 회원 삭제 [U] 회원 포인트 변경 " + "\n [S] 회원 목록 [N] 이름 조회 [E] 종료");
            String menu = System.console().readLine("선택>>>");

            // 인덱스, 회원 id 입력 : 잘못된 문자 입력하면 Integer.parseInt() 메소드 예외 생깁니다.
            // 단순처리 : switch 문을 try 구문으로 묶어서 예외 발생하면 다시 반복 처음 메뉴 입력 실행하기
            switch (menu.toUpperCase()) {
                case "A":
                    addMember(list); // 3개의 값을 입력받아 Member 객체 만들기
                    break;
                case "N":
                    String find = System.console().readLine("\t조회할 이름 입력");
                    int count = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getName().contains(find)) {
                            count++;
                            // 순서대로 인덱스 i의 데이터 가져와서 getter 이름값이 contains(find)
                            System.out.println("\t" + i + ": " + list.get(i));
                        }

                    }
                    if (count == 0) {
                        System.out.println("\t조회 데이터가 없습니다.");
                    }
                    break;
                case "R":
                    int index = Integer.parseInt(System.console().readLine("\t삭제할 인덱스 입력 >>>>"));
                    if (confirm("포인트 삭제")) {
                        Member m = list.remove(index); // 리턴값은 삭제한 index 위치의 데이터
                        System.out.println("\t삭제 데이터 확인 :" + m);
                    } else {
                        System.out.println("\t삭제 취소합니다.");
                    }
                    break;
                case "U":
                    index = Integer.parseInt(System.console().readLine("\t수정할 인덱스 입력"));
                    double point = Double.parseDouble(System.console().readLine("\t포인트 입력 >>>"));
                    if (confirm("포인트 변경")) {
                        list.get(index).setPoint(point);
                        System.out.println("\t업데이트 결과 :" + list.get(index));
                    } else {
                        System.out.println("포인트 변경을 취소했습니다.");
                    }

                    break;
                case "S":
                    System.out.println("\t\t회원리스트");
                    for (int i = 0; i < list.size(); i++)
                        System.out.println("\t" + i + ": " + list.get(i));
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

    // 프로그램 실행할 때 마다 4개의 객체를 리스트에 저장하고 시작 : list 초기화
    // 메소드 인자는 main 메소드의 ArrayList 객체의 주소를 저장
    private static void initMemberList(List<Member> list) {

        Member m1 = new Member(1, "김땡땡", 133.4);
        Member m2 = new Member(2, "반하나", 111.9);
        Member m3 = new Member(3, "최사과", 85.4);
        Member m4 = new Member(4, "박모모", 96.3);

        // 불변 객체 리스트가 메소드의 인자로 가변 객체 list에 모든 요소 추가
        list.addAll(List.of(m1, m2, m3, m4));
    }

    private static void addMember(List<Member> list) {

        int id = Integer.parseInt(System.console().readLine("id>>>"));
        String name = System.console().readLine("이름>>>");

        if (confirm("회원 등록")) {
            Member m = new Member(id, name, 100);
            list.add(m);
            System.out.println("\t등록회원 : " + m);
        } else {
            System.out.println("등록 작업을 취소합니다.");
        }

    };

    // 추가, 삭제, 변경 작업 반영할 때 확인 받는 멧지ㅣ 출력 메소드
    private static boolean confirm(String task) {
        String yn = System.console().readLine(task + "을(를) 실행할까요?(확인: 엔터, 취소:N)");
        // 엔터를 누르면 참 리턴
        return yn.length() != 0 && yn.toUpperCase().equals("N") ? false : true;
    }
}
