package BTLab6.Service;

import BTLab6.Entity.CRStatics;
import BTLab6.Entity.StaticsView;
import BTLab6.General.IFileService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FileService implements IFileService<StaticsView,CRStatics> {
    private List<CRStatics> crStaticsList=new ArrayList<>();
    public FileService() {
    }

    public void setData(Map<CRStatics, CRStatics> dataMap){
        this.crStaticsList= new ArrayList<>(dataMap.values());
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
    public void writeFile(String fileOutPath) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutPath));
            bufferedWriter.write("ID;Month;Year;TotalView;TotalAddToCart;TotalCheckOut;CRView;CRAddToCart;CRCheckOut");
            bufferedWriter.newLine();
            crStaticsList.stream().peek(crStatics -> {
                try {
                    String lineWrite = String.format("%d|%d|%d|%d|%d|%d|%.2f|%.2f|%.2f",
                            crStatics.getId(),
                            crStatics.getMonth(),
                            crStatics.getYear(),
                            crStatics.getTotalView(),
                            crStatics.getTotalAddToCart(),
                            crStatics.getTotalCheckOut(),
                            crStatics.getCrView(),
                            crStatics.getCrAddToCart(),
                            crStatics.getCrCheckOut());
                    bufferedWriter.write(lineWrite);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }).collect(Collectors.toList());
        }catch (IOException e){
            e.getCause();
        }
    }
}
