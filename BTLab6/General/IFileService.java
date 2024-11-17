package BTLab6.General;

import java.util.List;

public interface IFileService<T> {
    List<T> readFile(String filePath);
    void writeFile(String filePath);
}
