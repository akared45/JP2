package BTLab6;
import BTLab6.Entity.CRIndex;
import BTLab6.Service.CRService;
import BTLab6.Service.FileService;
import BTLab6.Entity.CRStatics;
import BTLab6.Entity.StaticsView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/", "\\") + "/BTLab6/data/Statics.view.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "/BTLab6/data/StaticsCR.view.txt";

        FileService fileService = new FileService();
        List<StaticsView> staticsViewList = fileService.readFile(fileInPath);
        CRService crService=new CRService(staticsViewList);

        Map<CRStatics, CRStatics> dataCRS = crService.dataCRS();
        dataCRS.values().forEach(crStatics -> {
            CRIndex crIndex = crService.calculateCRIndex(crStatics);
            fileService.addCRIndex(crIndex);
        });

        fileService.writeFile(fileOutPath);
        System.out.println("Data written to file: " + fileOutPath);
    }
}