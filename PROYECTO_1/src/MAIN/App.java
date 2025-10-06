package MAIN;

import MODEL.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Date fecha = new Date(2);
        PaymentMethod card = new Card("pepe", 0,"1987",fecha, 12);
        Order testOrder=new Order(1,card);
        ArrayList<Product> catalog = ProductLoader.loadProdutcs("C:\\Users\\Lenovo\\Documents\\practicas\\PROYECTO_1\\src\\catalog.txt");
        Scanner sc = new Scanner(System.in);
            int idProduct=0;
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
       

