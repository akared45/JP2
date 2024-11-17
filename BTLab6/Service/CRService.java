package BTLab6.Service;

import BTLab6.Entity.CRIndex;
import BTLab6.Entity.CRStatics;
import BTLab6.Entity.StaticsView;
import BTLab6.General.IGeneral;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CRService implements IGeneral<CRStatics> {
    private List<StaticsView> staticsViewList;

    public CRService(List<StaticsView> staticsViewList) {
        this.staticsViewList = staticsViewList;
    }

    @Override
    public Map<CRStatics, CRStatics> dataCRS() {
        return staticsViewList.stream()
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
    }
    public CRIndex calculateCRIndex(CRStatics crStatics) {
        int totalView = crStatics.getTotalView();
        int totalAddToCart = crStatics.getTotalAddToCart();
        int totalCheckOut = crStatics.getTotalCheckOut();

        double crAddToCart = totalAddToCart > 0 ? (double) totalCheckOut / totalView * 100 : 0;
        double crCheckOut = totalView > 0 ? (double) totalCheckOut / totalView * 100 : 0;

        return new CRIndex(
                crStatics.getId(),
                crStatics.getMonth(),
                crStatics.getYear(),
                crAddToCart,
                crCheckOut
        );
    }

}
