package MODEL;
import java.util.ArrayList;

public class Order {
    private int idOrder;
    private ArrayList<Product> orderProducts = new ArrayList<Product>();

public Order(int idOrder){
    this.idOrder = idOrder; 
}
public void AddProduct(Product newProduct){
    orderProducts.add(newProduct);
}
public double ShowPrice(){
    double finalPrice = 0;
    for (int i = 0; i < orderProducts.size(); i++) {
        finalPrice+=(orderProducts.get(i).getPrice());
        }
    return finalPrice;
}

}
