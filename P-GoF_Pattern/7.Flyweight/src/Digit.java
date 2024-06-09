import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Digit {
    private ArrayList<String> data = new ArrayList<String>();

    public Digit(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            //파일을 열고
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            // 메모리 로드
            for (int i = 0; i < 8; i++) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //파일을 닫는다.
                if (fr != null)
                    fr.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void print(int x, int y) {
        for (int i = 0; i < 8; i++) {
            String line = data.get(i);
            System.out.print(String.format("%c[%d;%df", 0x1B, y + i, x));
            System.out.print(line);
        }
    }
}
