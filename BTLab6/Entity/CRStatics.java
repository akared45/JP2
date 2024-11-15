package BTLab6.Entity;

import java.util.Objects;

public class CRStatics {
    private int id;
    private int month;
    private int year;
    private int totalView;
    private int totalAddToCart;
    private int totalCheckOut;
    private double crView;
    private double crAddToCart;
    private double crCheckOut;
    public CRStatics() {
    }

    public CRStatics(int id, int month, int year) {
        this.id = id;
        this.month = month;
        this.year = year;
    }

    public CRStatics(int id, int month, int year, int totalView, int totalAddToCart, int totalCheckOut, double crView, double crAddToCart,double crCheckOut) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.totalView = totalView;
        this.totalAddToCart = totalAddToCart;
        this.totalCheckOut = totalCheckOut;
        this.crView = crView;
        this.crAddToCart = crAddToCart;
        this.crCheckOut = crCheckOut;
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

    public double getCrView() {
        return crView;
    }

    public void setCrView(double crView) {
        this.crView = crView;
    }

    public double getCrAddToCart() {
        return crAddToCart;
    }

    public void setCrAddToCart(double crAddToCart) {
        this.crAddToCart = crAddToCart;
    }

    public double getCrCheckOut() {
        return crCheckOut;
    }

    public void setCrCheckOut(double crCheckOut) {
        this.crCheckOut = crCheckOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CRStatics crStatics)) return false;
        return id == crStatics.id && month == crStatics.month && year == crStatics.year && totalView == crStatics.totalView && totalAddToCart == crStatics.totalAddToCart && totalCheckOut == crStatics.totalCheckOut && Double.compare(crView, crStatics.crView) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year, totalView, totalAddToCart, totalCheckOut, crView);
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
                ", crView=" + String.format("%.2f", crView) + "%" +
                ", crAddToCart=" + String.format("%.2f", crAddToCart) + "%" +
                ", crCheckOut=" + String.format("%.2f", crCheckOut) + "%" +
                '}';
    }
}
