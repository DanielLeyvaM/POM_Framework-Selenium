package dataClasses;

public class SingleProductData {
    private String email;
    private String password;
    private String sectionName;
    private String productName;


    //--------------------------- CONSTRUCTOR ----------------------
    public SingleProductData(String email, String password, String sectionName, String productName) {
        this.email = email;
        this.password = password;
        this.sectionName = sectionName;
        this.productName = productName;
    }


    //--------------------------- SETTERS AND GETTERS -------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
