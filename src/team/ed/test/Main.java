package team.ed.test;


import team.ed.views.View;

public class Main {
    public static void main(String ...args){
        View.showHeaderPrincipal();
        View.showMenuPrincipal();
        View.showGetOption();
        int option = View.getOption();
        System.out.println("la opcioon digitada fue " + option);
    }
}
