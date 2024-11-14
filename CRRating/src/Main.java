import Entity.CRStatics;
import Entity.StaticsView;
import Service.FileService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String sysPath = System.getProperty("user.dir");
        String fileInPath = sysPath.replace("/", "\\") + "/data/Statics.view.txt";

        FileService fileService = new FileService();
        List<StaticsView> staticsViewList = fileService.readFile(fileInPath);

        Map<CRStatics, CRStatics> dataCRS = staticsViewList.stream()
                .collect(Collectors.groupingBy(
                        cr -> new CRStatics(cr.getId(), cr.getMonthOfDate(), cr.getYearOfDate()),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                listCR -> {
                                    CRStatics crStatics = new CRStatics();
                                    StaticsView firstStaticsView = listCR.get(0);
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
        dataCRS.forEach((k,v)->System.out.println(v));
    }
}