package General;

import java.util.List;

public interface IFileService<T> {
    public List<T> readFile(String fileInPath);
    public List<T> writeFile(String fileOutPath);
}
