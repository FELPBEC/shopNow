package MODEL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int idOrder;
    private ArrayList<Product> orderProducts = new ArrayList<Product>();
    private LocalDateTime buyDate;
    private PaymentMethod PaymentMethod;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm");

public Order(int idOrder, PaymentMethod PaymentMethod){
    this.idOrder = idOrder; 
   this.buyDate=LocalDateTime.now();
   this.PaymentMethod=PaymentMethod;
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

public ArrayList<Product> getOrderProducts() {
    return orderProducts;
}

public void setOrderProducts(ArrayList<Product> orderProducts) {
    this.orderProducts = orderProducts;
}

public PaymentMethod getPaymentMethod() {
    return PaymentMethod;
}

public void setPaymentMethod(PaymentMethod paymentMethod) {
    PaymentMethod = paymentMethod;
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
    String list = "Nombre.........Precio \n";
    for (int i = 0; i < orderProducts.size(); i++) {
        list+=orderProducts.get(i).getName()+"   "+orderProducts.get(i).getPrice() + "\n";
    }
    
    list+="fecha de pago :"+buyDate.plusHours(24).format(formatter)+"     total price:";
    PaymentMethod.ProcessPayment();
    return list;
}

}
