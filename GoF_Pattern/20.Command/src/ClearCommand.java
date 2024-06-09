public class ClearCommand implements Command{

    @Override
    public void run() {
        // console 화면을 지워주는 코드값
        System.out.print("\033[H\033[2J");
        // console 화면을 지우라는 명령어
        System.out.flush();;
    }
   
    
}
