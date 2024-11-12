package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private int id;
    private String codeProduct;
    private int click;
    private int addToCart;
    private LocalDate checkOut;

    public Product() {
    }

    public Product(int id, String codeProduct, int click, int addToCart , LocalDate checkOut) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.click = click;
        this.addToCart = addToCart;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(int addToCart) {
        this.addToCart = addToCart;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", click=" + click +
                ", addToCart=" + addToCart +
                ", checkOut=" + checkOut +
                '}';
    }
}
