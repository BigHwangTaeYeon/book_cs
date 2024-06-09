import prac.CreateInstance;

public class App {
    public static void main(String[] args) throws Exception {

        // King king = new King();
        // 위 코드로 생성할 수 없다.

        // King king = King.getInsetance();
        // king.say();
        
        // King king2 = King.getInsetance();
        // System.out.println("King.hashCode() : " + king.hashCode());
        // System.out.println("King2.hashCode() : " + king2.hashCode());

        // if (king == king2) {
        //     System.out.println("same object");
        // } else {
        //     System.out.println("different object");
        // }
        CreateInstance CreateInstance = new CreateInstance();

        System.out.println(CreateInstance.getInstance().hashCode());

        System.out.println(CreateInstance.getInstance().hashCode());

        System.out.println(CreateInstance.getInstance().hashCode());
    }
}
