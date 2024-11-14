package Entity;

public class CRStatics {
    private int id;
    private int month;
    private int year;
    private int totalView;
    private int totalAddToCart;
    private int totalCheckOut;

    public CRStatics() {
    }

    public CRStatics(int id, int month, int year) {
        this.id = id;
        this.month = month;
        this.year = year;
    }

    public CRStatics(int id, int month, int year, int totalView, int totalAddToCart, int totalCheckOut) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.totalView = totalView;
        this.totalAddToCart = totalAddToCart;
        this.totalCheckOut = totalCheckOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalView() {
        return totalView;
    }

    public void setTotalView(int totalView) {
        this.totalView = totalView;
    }

    public int getTotalAddToCart() {
        return totalAddToCart;
    }

    public void setTotalAddToCart(int totalAddToCart) {
        this.totalAddToCart = totalAddToCart;
    }

    public int getTotalCheckOut() {
        return totalCheckOut;
    }

    public void setTotalCheckOut(int totalCheckOut) {
        this.totalCheckOut = totalCheckOut;
    }

    @Override
    public String toString() {
        return "CRStatics{" +
                "id=" + id +
                ", month=" + month +
                ", year=" + year +
                ", totalView=" + totalView +
                ", totalAddToCart=" + totalAddToCart +
                ", totalCheckOut=" + totalCheckOut +
                '}';
    }
}
