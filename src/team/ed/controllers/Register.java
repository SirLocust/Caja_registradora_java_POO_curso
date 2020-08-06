package team.ed.controllers;

import team.ed.objects.Meat;
import team.ed.objects.Potato;
import team.ed.objects.Product;
import team.ed.objects.Rice;
import team.ed.storage.DataBase;
import team.ed.views.View;

public class Register {

    private DataBase dataBase;
    public Register(){
    dataBase = new DataBase();
    }

    public void register(){

        int option;
        do {
            View.showHeaderPrincipal();
            View.showMenuPrincipal();
            View.showGetOption();
            option = View.getOption();
            switch (option){
                case 1:
                    this.buy();
                    break;
                case 2:
                    View.showSaleHeader();
                    break;
                case 3:

                    this.showStock();
                    break;
                case 4:
                    View.showBuyListHeader();
                    break;
                case 5:
                    View.showSaleListHeader();
                    break;
                case 6:
                    View.showThanks();
                    System.exit(0);
                    break;
                default:
                    View.showInvalidOption();
            }

        }
        while (option >= 1 || option <= 6);
    }

    private void buy(){
        int option;
        do {
            View.showBuyHeader();
            View.showGetOption();
            option = View.getOption();
            if(option >= 1 && option <= 3 ){
                buyProducts(option);
            }else if(option == 4){
                View.showGetBack("Compras");

                return;
            }
            else{
                View.showInvalidOption();
            }

        }while (option <= 1 || option >= 4);

    }

    private void buyProducts(int option){
        Product  product = null;
        switch (option){
            case 1:
                product = new Potato("sabanera");
                break;
            case 2:
                product = new Rice("Diana");
                break;
            case 3:
                product = new Meat("Zenu");
                break;

        }
        View.showGetAmount();
        int amout =  View.getAmount();
         View.showGetPrice();
        double price = View.getPrice();

        product.setAmount(amout);
        product.setPrice(price);

        dataBase.buy(product);
    }

    private void showStock(){
        View.showStockHeader();
        View.showItemsStock(this.dataBase.getAll());
        View.showAnyKey();
        View.getOption();
    }


}
