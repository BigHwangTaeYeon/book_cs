public class App {
    public static void main(String[] args) throws Exception {

        // Display display = new ScreenDisplay();
        Display display = new BufferDisplay(5);

        display.print("ㅁㅁAAAAAAAA");
        display.print("sfdgsdfdsf");
        display.print("SGRFDGSFDRG");
        display.print("{{{{{{{{{ㅁㅁAAAAAAA}}}}}}}}}A");
        display.print("::LDKJNGVKJSDNK");
        display.print("toerijh");
        display.print("ㄹ퓨AAAAA");
        display.print("ㅁㅁㄹ호ㅓㅜㅗ");
        display.print("호ㅓ,ㅛㅓㅕㄱ속소");

        //bufferSize를 5로 지정해두었기 때문에 content는 5가지만 나온다.
        //그래서 flush()를 통해 나머지를 출력해준다.
        ((BufferDisplay)display).flush();
    }
}
