public class Settings {
    private static Settings instance;

    private Settings() {}

    /**
     * 이 방법은 멀티 쓰레드 환경에서 안전하지 않다.
     */
//    public static Settings getInstance() {
//        if(instance == null) {
//            instance = new Settings();
//        }
//        return instance;
//    }

    /**
     * 1. 위 방법의 문제점을 가장 쉽게 해결하는 방법
     */
    public static synchronized Settings getInstance1() {
        if(instance == null) {
            instance = new Settings();
        }
        return instance;
    }
    /**
     * 2. 초기화(eager initialization - 이른 초기화) 사용, final 로 불변 객체로 만듦
     * 1번 방법도 좋지만 가볍도 간단하게 구현해도 되는 상황에 적합
     */
    private static final Settings INSTANCE = new Settings();
    public static Settings getInstance2() {
        return INSTANCE;
    }
    /**
     * 3. 사용이 될 때, 인스턴스를 생산하고 싶을 때.
     * double checked locking 사용
     */
    public static volatile Settings instance3;
    public static Settings getInstance3() {
        if (instance3 == null) {
            synchronized (Settings.class) {
                instance3 = new Settings();
            }
        }
        return instance3;
    }
    /**
     * 4. volatile (1.5 이후에 나온 키워드)
     * - volatile keyword는 Java 변수를 Main Memory에 저장하겠다라는 것을 명시하는 것입니다.
     * - 매번 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것입니다.
     * - 또한 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것입니다.
     *
     * - Task 를 수행하는 동안 성능 향상을 위해 Main Memory 에서 읽은 변수 값을 CPU Cache 에 저장하게 됩니다.
     * - 만약에 Multi Thread 환경에서 Thread 가 변수 값을 읽어올 때 각각의 CPU Cache 에 저장된 값이 다르기 때문에 변수 값 불일치 문제가 발생하게 됩니다.
     *
     * 위와 같이 volatile 키워드를 사용하지 않는 방법 Inner class, LAZY LOADING 까지 가능
     */
    private static class SettingsHolder{
        private static final Settings INSTANCE = new Settings();
    }
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

    /**
     * 역직렬화 대응 방안
     * 역직렬화 시, 항상 호출되는 메소드이다.
     */
    protected Object readResolve() {
        return getInstance();
    }
}
