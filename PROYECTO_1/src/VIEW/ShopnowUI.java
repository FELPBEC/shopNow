package VIEW;

import javax.swing.*;
import MODEL.Order;
import MODEL.Product;
import MODEL.ProductLoader;

import java.util.ArrayList;
import java.awt.*;
public class ShopnowUI extends JFrame{
    private JList<String>productList;
    private DefaultListModel<String>ListModel;
    private JTextArea cartArea;
    private Order order;
    private ArrayList<Product> catalog;
    //RECORDAR MODIFICAR EL RETORNO VOID CUANDO SE ACABE ESTA PARTE DEL CÓDIGO
    public void ShopNow(){
        setTitle("ShopwNow-------------Carrito de Compras");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        catalog = ProductLoader.loadProdutcs("C:\\Users\\Lenovo\\Documents\\practicas\\PROYECTO_1\\src\\catalog.txt");
        order = new Order(101);
            //Primer panel que contiene la lista, donde se almacenan los datos
        ListModel =new DefaultListModel<>();

            for (int i = 0; i < catalog.size(); i++) {
                ListModel.addElement(catalog.get(i).getIdProduct()+" - "+catalog.get(i).getName()+" -     ($"+catalog.get(i).getPrice()+")" );;
            }
            //se pasa el modelo de la lista con los datos a 
        productList=new JList<>(ListModel);
           
        //Se crea una barra Scroll
        JScrollPane scroollCatalong = new JScrollPane(productList);

            //Se crea un botón
        JButton addButton= new JButton("Agregar al carrito");


    }
}
