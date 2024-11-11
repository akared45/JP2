package E6.Entity;

public class Product {
    private int id;
    private String codeProduct;
    private String nameProduct;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int id, String codeProduct, String nameProduct, double price, int quantity) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
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

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
