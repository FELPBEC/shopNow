package MODEL;

public class Product {
    private int idProduct;
    private String name;
    private double price;
    public Product(int idProduct,String name, double price) {
        this.idProduct= idProduct;
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void showProductInfo(){
        System.out.println("Product info: " + "\n"+ "name: " + name +"\n"+ "price:" + price);
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    
    
}
