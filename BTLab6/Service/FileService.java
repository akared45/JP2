package BTLab6.Service;

import BTLab6.Entity.CRIndex;
import BTLab6.Entity.StaticsView;
import BTLab6.General.IFileService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService implements IFileService<StaticsView> {
    private final List<CRIndex> crIndexes = new ArrayList<>();

    public void addCRIndex(CRIndex index) {
        crIndexes.add(index);
    }

    @Override
    public List<StaticsView> readFile(String filePath) {
        List<StaticsView> staticsViews = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    StaticsView view = new StaticsView(
                            Integer.parseInt(parts[0]),
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            LocalDate.parse(parts[4])
                    );
                    staticsViews.add(view);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return staticsViews;
    }

    @Override
    public void writeFile(String filePath) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write("ID;Month;Year;CRView;CRAddToCart;CRCheckOut");
            bufferedWriter.newLine();
            crIndexes.stream().peek(crStatics -> {
                try {
                    String lineWrite = String.format("%d|%d|%d|%.2f|%.2f|%.2f",
                            crStatics.getId(),
                            crStatics.getMonth(),
                            crStatics.getYear(),
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
        } catch (IOException e) {
            e.getCause();
        }
    }
}
