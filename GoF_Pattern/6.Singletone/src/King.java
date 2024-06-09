public class King {
    private King() {}
    
    private static King self = null;

    // 멀티 쓰레드에서 동기화 시킨다.
    public synchronized static King getInsetance() {
        if (self == null) {
            self = new King();
        }
        return self;
    }

    public void say() {
        System.out.println( " i am .. ");
    }
}
