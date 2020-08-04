package team.ed.storage;

import team.ed.objects.Meat;
import team.ed.objects.Potato;
import team.ed.objects.Product;
import team.ed.objects.Rice;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private final  Product[] products;
    private List<Product> purchases;
    private List<Product> sales;

    public DataBase(){
        this.products = new Product[3];
        Product potato = new Potato("sabanera");
        Product rice = new Rice("Diana");
        Product meat = new Meat("Zenu");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        this.purchases = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    public Product getByIndex(int index){
        if (index < 0 || index > 2){
            System.out.println("indice no valido!");
            return null;
        }
        Product result = null;
        try {
            result = products[index].clone();
        }
        catch (CloneNotSupportedException error){
            System.out.println(error);
        }
        return result;
    }
    public Product[] getAll(){
        Product[] result = new Product[3];
        try {
            result[0] = products[0].clone();
            result[1] = products[1].clone();
            result[2] = products[2].clone();
        }
        catch (CloneNotSupportedException error){
            System.err.println(error);

        }
        return result;
    }

    public void buy(Product product){
        Product temp;
        switch (product.getClass().getSimpleName()){
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("no valido");
                return;
        }

        temp.setAmount(temp.getAmount()+ product.getAmount());
        temp.setPrice(product.getPrice());
        purchases.add(product);
    }
    public void sale(Product product){
        Product temp;
        switch (product.getClass().getSimpleName()){
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("no valido");
                return;
        }

        temp.setAmount(temp.getAmount() - product.getAmount());
        product.setPrice(temp.getPrice() * 1.25f);
        purchases.add(product);
        sales.add(product);
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public List<Product> getSales() {
        return sales;
    }
}
