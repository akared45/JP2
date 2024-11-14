package Service;

import Entity.StaticsView;
import General.IFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService<StaticsView> {
    public FileService() {
    }

    @Override
    public List<StaticsView> readFile(String fileInPath) {
        List<StaticsView> staticsViewList=new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInPath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StaticsView staticsView=new StaticsView();
                if(!line.isEmpty()){
                    String[] arrData=line.split(";");
                    staticsView.setId(Integer.parseInt(String.valueOf(arrData[0])));
                    staticsView.setView(Integer.parseInt(String.valueOf(arrData[1])));
                    staticsView.setAddToCart(Integer.parseInt(String.valueOf(arrData[2])));
                    staticsView.setCheckOut(Integer.parseInt(String.valueOf(arrData[3])));
                    staticsView.setCreateAtDate(LocalDate.parse(String.valueOf(arrData[4])));
                    staticsViewList.add(staticsView);
                }
            }
        } catch (IOException e) {
            e.getCause();
        }
        return staticsViewList;
    }

    @Override
    public List<StaticsView> writeFile(String fileOutPath) {
        return List.of();
    }
}
