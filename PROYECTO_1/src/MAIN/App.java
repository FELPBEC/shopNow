package MAIN;

import MODEL.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        LocalDate expirationDate = null;
        PaymentMethod card = null;
        PaymentMethod bankTransfer = null;
        PaymentMethod digitalWllet = null;
        Order testOrder=new Order(1,card);
        ArrayList<Product> catalog = ProductLoader.loadProdutcs("C:\\Users\\Lenovo\\Documents\\practicas\\PROYECTO_1\\src\\catalog.txt");
        Scanner sc = new Scanner(System.in);
            int idProduct=0;
            byte methodPay = 0;
            
            for (int i = 0; i < catalog.size(); i++) {
            System.out.println("id:"+catalog.get(i).getIdProduct()+"    name: "+catalog.get(i).getName()+"     price:"+catalog.get(i).getPrice());
        }
        do {
            System.out.println("ingrese la id del producto que quiere añadir al carrito");
            System.out.println("Cuando desee dejar de añadir productos ingrese 0");
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
            if (foundProduct==false && idProduct!=0) {
                System.out.println("ERROR!!! ID invalida, intente de nuevo");
            }
        } while (idProduct!=0);

        System.out.println("A continuación, seleccione su metodo de pago: \n 1 si desea pagar con tarjeta,\n 2 para pagar con transferencia bancaria \n 3 para pagar con billetería digital");
            methodPay=sc.nextByte();
            sc.nextLine();
            String owner ="";
            switch (methodPay) {
                case 1:
                    System.out.println("ha elegido tarjeta de crédito, \n a continuación se le solicitaran sus datos \n 1. Nombre del propietario:");
                    owner=sc.nextLine();
                    System.out.println("ahora indique el número de su tarjeta: ");
                    String cardNumber = sc.nextLine();
                    System.out.println("A continuación se le solicitará la fecha de expiración \n Indique el año de expiración de su tarjeta");
                    int year = sc.nextInt();
                    System.out.println("ahora indique el mes");
                    int mounth = sc.nextInt();
                    System.out.println("Finalmente indique el día del mes:");
                    int dayOfMounth=sc.nextInt();
                    expirationDate=LocalDate.of(year, mounth, dayOfMounth);
                    System.out.println("ahora indique el CVV de su tarjeta");
                    int CVV=sc.nextInt();
                    card=  new Card(owner, 0,cardNumber,expirationDate, CVV);
                    System.out.println("metodo de pago añadido, siga con su acción");
                    testOrder.setPaymentMethod(card);
                    break;
                case 2:
                    System.out.println("Ha elegido trasnferencia bancaria, \n indique el nombre del propietario de la cuenta");
                    owner=sc.nextLine();
                    System.out.println("A continuación indique el número de cuenta");
                    int acountNumber=sc.nextInt();
                    System.out.println("indique finalmente el nombre de su banco");
                    String bankName= sc.nextLine();
                    bankTransfer=new BankTransfer(owner, 0, acountNumber, bankName);
                    testOrder.setPaymentMethod(bankTransfer);
                    break;
                case 3:
                    System.out.println("ha elegido cartera digital,\n a continuación escriba el nombre del propietario");
                    owner=sc.nextLine();
                    System.out.println("escriba la ID de su cartera digital");
                    int wlletId=sc.nextInt();
                    digitalWllet=new DigitalWallet(owner, 0, wlletId);
                    testOrder.setPaymentMethod(digitalWllet);
                break;
                default:
                    break;
            }
            
        
    System.out.println(testOrder.ShowProducts()+""+testOrder.ShowPrice());
    sc.close();
    }
}
       

