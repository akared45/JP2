package BTLab6.General;

import java.util.List;

public interface IFileService<T, C> {
    public List<T> readFile(String fileInPath);
    public void writeFile(String fileOutPath);
}
