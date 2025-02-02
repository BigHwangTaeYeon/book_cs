package A_before;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class FileProcessor {
    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public int process() {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int result = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                result = getResult(result, line);
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("Not Fount File", e);
        }
    }

    protected abstract int getResult(int result, String line);


}
