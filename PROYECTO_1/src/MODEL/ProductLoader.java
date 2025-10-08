package MODEL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductLoader {
    public static ArrayList<Product> loadProdutcs(String pathFile) {
        ArrayList<Product>productList= new ArrayList<>();
            try(BufferedReader buffer = new BufferedReader(new FileReader(pathFile))){
                String line;
                while ((line=buffer.readLine())!=null) {
                    String[]values = line.split(",");
                    int id = Integer.parseInt(values[0]);
                    String name = values[1];
                    double price = Double.parseDouble(values[2]);

                    productList.add(new Product(id, name, price));
                }
            }catch (FileNotFoundException e){
                System.out.println("Archivo no encontrado \n verifique la ruta" + pathFile);  
            }catch(IOException e){
                System.out.println("Error al encontrar el archivo");
            }finally{
                System.out.println("Cierra del programa");
            }
        return productList;
        
    }
}
