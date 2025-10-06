package VIEW;

import javax.swing.*;
import MODEL.Order;
import MODEL.Product;
import MODEL.ProductLoader;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
public class ShopnowUI extends JFrame{
    private JList<String>productList;
    private DefaultListModel<String>ListModel;
    private JTextArea cartArea;
    private Order order;
    private ArrayList<Product> catalog;
    //RECORDAR MODIFICAR EL RETORNO VOID CUANDO SE ACABE ESTA PARTE DEL CÓDIGO
    public void ShopNowUI(){
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
        JScrollPane scroollCatalog = new JScrollPane(productList);
        

            //Se crea un botón
        JButton addButton= new JButton("Add");
        JButton finishBuy= new JButton("Add");

        addButton.addActionListener((ActionEvent e)-> {
            int selectedProduct = productList.getSelectedIndex();
            if (selectedProduct !=-1) {
                Product product = catalog.get(selectedProduct);
                order.AddProduct(product);
                cartArea.append(product.getName()+" $ "+ product.getPrice()+"\n");
            } 
            
        });
        finishBuy.addActionListener((ActionEvent z)-> {
            cartArea.append(order.ShowProducts());
        });

        //panel izquierdo
        JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.add(new JLabel("Cátalogo de productos"),BorderLayout.NORTH);
            leftPanel.add(scroollCatalog,BorderLayout.CENTER);
            leftPanel.add(addButton,BorderLayout.SOUTH);

        //panel derecho
        JPanel rightJPanel = new JPanel(new BorderLayout());
            rightJPanel.add(new JLabel("Carrito de compras"),BorderLayout.NORTH);
            rightJPanel.add(finishBuy,BorderLayout.SOUTH);


    }
}
