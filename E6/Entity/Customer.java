package E6.Entity;

public class Customer {
    private int id;
    private String codeCus;
    private String nameCus;
    private String phoneCus;

    public Customer() {
    }

    public Customer(int id, String codeCus, String nameCus, String phoneCus) {
        this.id = id;
        this.codeCus = codeCus;
        this.nameCus = nameCus;
        this.phoneCus = phoneCus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeCus() {
        return codeCus;
    }

    public void setCodeCus(String codeCus) {
        this.codeCus = codeCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getPhoneCus() {
        return phoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        this.phoneCus = phoneCus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", codeCus='" + codeCus + '\'' +
                ", nameCus='" + nameCus + '\'' +
                ", phoneCus='" + phoneCus + '\'' +
                '}';
    }
}
