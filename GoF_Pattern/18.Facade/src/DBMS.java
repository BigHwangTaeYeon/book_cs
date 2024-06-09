import java.util.HashMap;

public class DBMS {
    private HashMap<String, Row> db = new HashMap<String, Row>();

    public DBMS() {
        db.put("jane", new Row("Jane", "1990-02-14", "jane09@naver.com"));
        db.put("robert", new Row("Robert", "1979-04-19", "nice@google.com"));
        db.put("dorosh", new Row("Dorosh", "1985-08-21", "jane09@hanmail.co.kr"));
    }

    public Row query(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return db.get(name.toLowerCase());
    }
}
