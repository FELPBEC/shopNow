package MAIN;

import MODEL.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        LocalDate expirationDate = LocalDate.of(2023, 6, 5);
        PaymentMethod card = new Card("pepe", 0,"1987353533535356",expirationDate, 12);
        PaymentMethod bankTransfer = new BankTransfer("pepe", 0, 1234646464, "DaviVienda");
        PaymentMethod digitalWllet = new DigitalWallet("pepe", 0, 1987648);
        ArrayList<Product> catalog = ProductLoader.loadProdutcs("C:\\Users\\Lenovo\\Documents\\practicas\\PROYECTO_1\\src\\catalog.txt");
        Scanner sc = new Scanner(System.in);
            int idProduct=0;
            int methodPay = 0;
        System.out.println("ingrese \n 1 si desea pagar con tarjeta,\n 2 para pagar con transferencia bancaria \n 3 para pagar con billetería digital");
            methodPay=sc.nextInt();
            Order testOrder=null;
            switch (methodPay) {
                case 1:
                    testOrder=new Order(1,card);
                    break;
                case 2:
                    testOrder=new Order(1,bankTransfer);
                    break;
                case 3:
                    testOrder=new Order(1,digitalWllet);
                break;
                default:
                    break;
            }
            
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println("id:"+catalog.get(i).getIdProduct()+"    name: "+catalog.get(i).getName()+"     price:"+catalog.get(i).getPrice());
        }
        do {
            System.out.println("enter the id corresponding to the product you want to buy");
            System.out.println("if you dont want add other product write 0");
            idProduct= sc.nextInt();
            boolean foundProduct=false;
            for (int i = 0; i < catalog.size(); i++) {
                if (foundProduct!=true) {
                    if (catalog.get(i).getIdProduct()==idProduct) {
                    testOrder.AddProduct(catalog.get(i));
                    foundProduct=true;
                    }
                }
            }
            if (foundProduct==false) {
                System.out.println("ERROR!!! INVALID ID try again");
            }
        } while (idProduct!=0);
    System.out.println(testOrder.ShowProducts()+""+testOrder.ShowPrice());
    sc.close();
    }
}
       

