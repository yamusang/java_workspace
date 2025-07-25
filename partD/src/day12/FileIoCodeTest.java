package day12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class FileIoCodeTest {
    public static void main(String[] args) {
        writeFileAutoClose();
        readByLine();
    }

    public static void writeFileAutoClose() {

        String filename = "java_keyword.csv";
        try (
                // close가 필요한 선언
                FileWriter fw = new FileWriter(filename, true); // true : 기존 파일내용에 추가
                PrintWriter pw = new PrintWriter(fw);

        ) {
            int line = 0;
            String test = "public,공용의,1\r\n" + //
                    "private,사적인,1\r\n" + //
                    "list,목록,1\r\n" + //
                    "immutable,불변의,3\r\n" + //
                    "static,정적인,2";
            String[] lines = test.split("\\s+");
            for (int i = 0; i < lines.length; i++) {
                pw.println(lines[i]);
                line++;
            }
            System.out.println("line" + line);
            JavaKeyWord k1 = new JavaKeyWord("final", "최종의", 1);
            JavaKeyWord k2 = new JavaKeyWord("construct", "건설하다", 2);
            pw.println(k1.getKeyword() + "," + k1.getKorean() + "," + k1.getLevel());
            pw.println(k2.getKeyword() + "," + k2.getKorean() + "," + k2.getLevel());
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }

    public static void readByLine() {
        // int ch;
        List<JavaKeyWord> list = new ArrayList<>();
        String line = null;
        FileReader fr = null;
        Scanner sc = null;
        try {
            fr = new FileReader("java_keyword.csv", Charset.forName("UTF-8"));
            sc = new Scanner(fr);

            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] s3 = new String[3];
                s3 = line.split(",");
                JavaKeyWord j1 = new JavaKeyWord(s3[0], s3[1], Integer.parseInt(s3[2]));
                list.add(j1);
                System.out.println(j1);
            }
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        } finally {
            try {
                fr.close();
                sc.close();
            } catch (IOException e) {
            }
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
class JavaKeyWord {
    private String keyword;
    private String korean;
    private int level;

    @Override
    public String toString() {
        return keyword + "," + korean + "," + level;
    }
}