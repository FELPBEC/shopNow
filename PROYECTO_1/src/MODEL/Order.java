package MODEL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int idOrder;
    private ArrayList<Product> orderProducts = new ArrayList<Product>();
    private LocalDateTime buyDate;

public Order(int idOrder ){
    this.idOrder = idOrder; 
   this.buyDate=LocalDateTime.now();
}

public int getIdOrder() {
    return idOrder;
}

public void setIdOrder(int idOrder) {
    this.idOrder = idOrder;
}

public LocalDateTime getBuyDate() {
    return buyDate;
}

public void setBuyDate(LocalDateTime buyDate) {
    this.buyDate = buyDate;
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
public String ShowProducts(){
    String list = "Name.........Price \n";
    for (int i = 0; i < orderProducts.size(); i++) {
        list+=orderProducts.get(i).getName()+"   "+orderProducts.get(i).getPrice() + "\n";
    }
    list+="fecha:"+buyDate.plusHours(24)+"     total price:";
    return list;
}
}
