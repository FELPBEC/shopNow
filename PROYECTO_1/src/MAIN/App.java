package MAIN;

import MODEL.*;
//TEST CUENTA GIT
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
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
            String list = "";
            for (int i = 0; i < catalog.size(); i++) {
                list+="id:"+catalog.get(i).getIdProduct()+"    name: "+catalog.get(i).getName()+"     price:"+catalog.get(i).getPrice()+"\n"; 
        }
        JOptionPane.showMessageDialog(null,list );

        do {
            idProduct=Integer.parseInt(JOptionPane.showInputDialog("ingrese la id del producto que quiere añadir al carrito \n Cuando desee dejar de añadir productos ingrese 0"));
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
                JOptionPane.showMessageDialog(null, "ERROR!!! ID invalida, intente de nuevo");
            }
        } while (idProduct!=0);
            methodPay=Byte.parseByte(JOptionPane.showInputDialog("A continuación, seleccione su metodo de pago: \n 1 si desea pagar con tarjeta,\n 2 para pagar con transferencia bancaria \n 3 para pagar con billetería digital"));
            String owner ="";
            switch (methodPay) {
                case 1:
                    owner=JOptionPane.showInputDialog("ha elegido tarjeta de crédito, \n" + //
                                                " a continuación se le solicitaran sus datos \n" + //
                                                " 1. Nombre del propietario:");
                    String cardNumber = JOptionPane.showInputDialog("2. Número de su tarjeta:");
                    JOptionPane.showMessageDialog(null, "3. fecha de expiración");
                    int year = Integer.parseInt(JOptionPane.showInputDialog("Indique el año de expiración de su tarjeta"));
                    int mounth = Integer.parseInt(JOptionPane.showInputDialog("ahora indique el mes (en número)"));
                    int dayOfMounth=Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese el día del mes"));
                    expirationDate=LocalDate.of(year, mounth, dayOfMounth);
                    int CVV=Integer.parseInt(JOptionPane.showInputDialog("ahora indique el CVV de su tarjeta"));
                    card=  new Card(owner, 0,cardNumber,expirationDate, CVV);
                    JOptionPane.showMessageDialog(null,"Medio de pago añadido");
                    testOrder.setPaymentMethod(card);
                    card.ProcessPayment();
                    break;
                case 2:
                    owner=JOptionPane.showInputDialog("ha elegido transferencia bancaria, \n" + //
                                                " a continuación se le solicitaran sus datos \n" + //
                                                " 1. Nombre del propietario:");
                    int acountNumber=Integer.parseInt(JOptionPane.showInputDialog("2. número de cuenta"));
                    System.out.println();
                    String bankName= JOptionPane.showInputDialog("3. nombre de su banco");
                    bankTransfer=new BankTransfer(owner, 0, acountNumber, bankName);
                    testOrder.setPaymentMethod(bankTransfer);
                    bankTransfer.ProcessPayment();
                    break;
                case 3:
                    System.out.println();
                    owner=JOptionPane.showInputDialog("ha elegido cartera digital,\n a continuación escriba el nombre del propietario");
                    int wlletId=Integer.parseInt(JOptionPane.showInputDialog("escriba la ID de su cartera digital"));
                    digitalWllet=new DigitalWallet(owner, 0, wlletId);
                    testOrder.setPaymentMethod(digitalWllet);
                    digitalWllet.ProcessPayment();
                break;
                default:
                    break;
            }
            
            JOptionPane.showMessageDialog(null,testOrder.ShowProducts()+""+testOrder.ShowPrice());
    sc.close();
    }
}
       

