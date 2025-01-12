import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        /**
         * 리플랙션을 통해 싱글톤 피해가기
         * 리플렉션은 대응할 수 없다, 막을 수 없다.
         */
        Settings settings = Settings.getInstance();

        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 새로운 인스턴스 생성
        Settings settings1 = constructor.newInstance();

        System.out.println("settings == settings1 = " + (settings == settings1));

        /**
         * 직열화 역직열화를 통해 싱글톤 피해가기
         * 자바에는 오브젝트를 파일 형태로 디스크에 저장(직열화)해두고 다시 읽어 들임(역직열화)
         * readResolve() 를 통해 대응할 수 있다.
         */
//        Settings settings2 = Settings.getInstance();
//        Settings settings3 = null;
//
//        // 직열화
//        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
//            out.writeObject(settings2);
//        }
//
//        // 역직열화
//        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
//            settings3 = (Settings) in.readObject();
//        }
//        System.out.println("(settings2 == settings3) = " + (settings2 == settings3));

//        SettingsEnum settingsEnum = SettingsEnum.INSTANCE;
//
//        SettingsEnum settingsEnum1 = null;
//        Constructor<?>[] constructors = SettingsEnum.class.getDeclaredConstructors();
//        for (Constructor<?> constructor1 : constructors) {
//            constructor1.setAccessible(true);
//            settingsEnum1 = (SettingsEnum) constructor1.newInstance("INSTANCE");
//        }
//
//        System.out.println("settingsEnum == settingsEnum1 = " + (settingsEnum == settingsEnum1));

        SettingsEnum settingsEnum2 = SettingsEnum.INSTANCE;
        SettingsEnum settingsEnum3 = null;
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settingsEnum.obj"))) {
            out.writeObject(settingsEnum2);
        }
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settingsEnum.obj"))) {
            settingsEnum3 = (SettingsEnum) in.readObject();
        }
        System.out.println("(settingsEnum2 == settingsEnum3) = " + (settingsEnum2 == settingsEnum3));
    }
}