package team.ed.storage;

import team.ed.objects.Meat;
import team.ed.objects.Potato;
import team.ed.objects.Product;
import team.ed.objects.Rice;

public class DataBase {

    private final  Product[] products;

    public DataBase(){
        this.products = new Product[3];
        Product potato = new Potato("sabanera");
        Product rice = new Rice("Diana");
        Product meat = new Meat("Zenu");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;
    }

    public Product getByIndex(int index){
        if (index < 0 || index > 2){
            System.out.println("indice no valido!");
            return null;
        }
        return this.products[index];
    }
    public Product[] getAll(){
        return products;
    }
}
