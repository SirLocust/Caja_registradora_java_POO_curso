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
        View.showHeaderPrincipal();
        View.showMenuPrincipal();
        View.showItemsMenu();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            switch (option){
                case 1:
                    View.showBuyHeader();
                    break;
                case 2:
                    View.showSaleHeader();
                    break;
                case 3:
                    View.showStockHeader();
                    break;
                case 4:
                    View.showBuyListHeader();
                    break;
                case 5:
                    View.showSaleListHeader();
                    break;
                case 6:
                    View.showThanks();
                    break;
                default:
                    View.showInvalidOption();
            }

        }
        while (option < 1 || option > 6);
    }

    private void buy(){
        View.showBuyHeader();
        int option;
        do {
            View.showGetOption();
            option = View.getOption();
            switch (option){
                case 1:

                    break;
                case 2:
                    View.showSaleHeader();
                    break;
                case 3:
                    View.showStockHeader();
                    break;
                case 4:
                    View.showBuyListHeader();
                    break;
                default:
                    View.showInvalidOption();
            }

        }while (option <1 || option > 4);

    }

    public void buyProducts(int option){
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
}
