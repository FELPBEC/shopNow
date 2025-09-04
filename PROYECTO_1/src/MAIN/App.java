
import MODEL.Client;
import MODEL.Order;
import MODEL.Product;
public class App {
    public static void main(String[] args) throws Exception {
        Client elPepe = new Client("Pepe el mago","1987", "elpepe87@gmail.com");
        Product headphones = new Product(1987, "headphones",70000 );
        Product gamerComputer = new Product(4732, "gamerComputer",2500000 );
        Product microphone = new Product(7294, "microphone",40000 );
        Product mouse = new Product(8413, "mouse",30000 );
        Product fan = new Product(6452, "fan",130000 );
        Order testOrder = new Order(487);
        testOrder.AddProduct(headphones);
        testOrder.AddProduct(gamerComputer);
        testOrder.AddProduct(microphone);
        testOrder.AddProduct(mouse);
        testOrder.AddProduct(fan);
        System.out.println(""+testOrder.ShowProducts()+testOrder.ShowPrice());

    }
}
