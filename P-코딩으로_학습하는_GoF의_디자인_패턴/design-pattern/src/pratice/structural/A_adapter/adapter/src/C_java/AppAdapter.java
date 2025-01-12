package C_java;

import java.io.*;
import java.util.*;

public class AppAdapter {
    public static void main(String[] args) {
        // T... a 가변 인자 "a", "b", "c" 배열
        // 배열을 리스트로 변환해서 반환
        List<String> list = Arrays.asList("a", "b", "c");
        /**
         * list 가 adaptee
         * Collections.enumeration() 가 adapter
         * Enumeration<String> 가 target interface
         */
        Enumeration<String> enumeration = Collections.enumeration(list);
        System.out.println("enumeration = " + enumeration);
        ArrayList<String> list1 = Collections.list(enumeration);


        try(InputStream is = new FileInputStream("README.md");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr)) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
