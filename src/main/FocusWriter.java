import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class FocusWriter <T> {
    private String path;

    FocusWriter(String path) {
        this.path = path;
    }

    public void write(List<T> list){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            for (T value : list) {
                writer.write(String.valueOf(value));
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception in write method");
        } catch (IOException e) {
            System.out.println("IO Exception in write method");
        }
    }
}
