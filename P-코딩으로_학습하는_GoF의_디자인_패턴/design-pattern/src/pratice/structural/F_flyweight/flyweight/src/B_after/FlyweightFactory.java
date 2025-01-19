package B_after;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Font> chache = new HashMap<>();

    public Font getFont(String font) {
        if(chache.containsKey(font)) {
            return chache.get(font);
        } else {
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            chache.put(font, newFont);
            return newFont;
        }
    }
}
