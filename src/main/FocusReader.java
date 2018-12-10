import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FocusReader {
    private String path;

    public FocusReader(String path) {
        this.path = path;
    }

    public <T> List<T> read(Function<String, T> func){
        try {
            return Files.lines(Paths.get(path)).map(func).collect(Collectors.toList());
        }catch (IOException e) {
            System.out.println("IO Exception in read method");
        }
        return null;
    }
}
