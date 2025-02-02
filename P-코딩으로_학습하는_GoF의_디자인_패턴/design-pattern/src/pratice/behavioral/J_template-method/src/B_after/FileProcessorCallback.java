package B_after;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileProcessorCallback {
    private String path;

    public FileProcessorCallback(String path) {
        this.path = path;
    }

    public int process(Operation operation) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int result = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                result = operation.getResult(result, line);
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("Not Fount File", e);
        }
    }
}
