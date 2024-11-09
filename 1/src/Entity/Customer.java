package Entity;

public class Customer {
    private int id;
    private String codeCus;
    private String name;

    public Customer() {
    }

    public Customer(int id, String codeCus, String name) {
        this.id = id;
        this.codeCus = codeCus;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(String separator){
        StringBuilder stringBuilder=new StringBuilder();
        return stringBuilder.append(this.getId())
                .append(separator)
                .append(this.getCodeCus())
                .append(separator)
                .append(this.getName())
                .toString();
    }
}
