package BTLab6;
import BTLab6.Service.FileService;
import BTLab6.Entity.CRStatics;
import BTLab6.Entity.StaticsView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/", "\\") + "/BTLab6/data/Statics.view.txt";
        String fileOutPath = sysPath.replace("/", "\\") + "/BTLab6/data/StaticsCR.view.txt";
        FileService fileService = new FileService();
        List<StaticsView> staticsViewList = fileService.readFile(fileInPath);
        Map<CRStatics, CRStatics> dataCRS = staticsViewList.stream()
                .collect(Collectors.groupingBy(
                        cr -> new CRStatics(cr.getId(), cr.getMonthOfDate(), cr.getYearOfDate()),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                listCR -> {
                                    CRStatics crStatics = new CRStatics();
                                    StaticsView firstStaticsView = listCR.getFirst();
                                    int totalView = listCR.stream().mapToInt(StaticsView::getView).sum();
                                    crStatics.setId(firstStaticsView.getId());
                                    crStatics.setMonth(firstStaticsView.getMonthOfDate());
                                    crStatics.setYear(firstStaticsView.getYearOfDate());
                                    crStatics.setTotalView(totalView);
                                    crStatics.setTotalAddToCart(listCR.stream().mapToInt(StaticsView::getAddToCart).sum());
                                    crStatics.setTotalCheckOut(listCR.stream().mapToInt(StaticsView::getCheckOut).sum());
                                    return crStatics;
                                }
                        )
                ));
        Map<String, Integer> totalViewByMonthYear = staticsViewList.stream()
                .collect(Collectors.groupingBy(
                        sv -> sv.getMonthOfDate() + "-" + sv.getYearOfDate(),
                        Collectors.summingInt(StaticsView::getView)
                ));
        dataCRS.values().forEach(crStatics -> {
            String monthYearKey = crStatics.getMonth() + "-" + crStatics.getYear();
            int totalViewInMonth = totalViewByMonthYear.getOrDefault(monthYearKey, 1);
            double crView = (double) crStatics.getTotalView() / totalViewInMonth * 100;
            crStatics.setCrView(crView);
        });
        dataCRS.values().forEach(crStatics -> {
            if (crStatics.getTotalView() > 0) {
                double crAddToCart = ((double) crStatics.getTotalAddToCart() / crStatics.getTotalView()) * 100;
                double crCheckOut = ((double) crStatics.getTotalCheckOut() / crStatics.getTotalView()) * 100;
                crStatics.setCrAddToCart(crAddToCart);
                crStatics.setCrCheckOut(crCheckOut);
            } else {
                crStatics.setCrAddToCart(0.0);
                crStatics.setCrCheckOut(0.0);
            }
        });
        dataCRS.forEach((k,v)->System.out.println(v));
        fileService.setData(dataCRS);
        fileService.writeFile(fileOutPath);
        System.out.println("Success: " + fileOutPath);

    }
}