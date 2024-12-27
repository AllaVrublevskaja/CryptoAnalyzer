package org.javarush;

public class Main {

    public static void main(String[] args) {
        int item = 0;
        while(item<4){
            item = Show.menu();
            Item.executeTheItemOfMenu(item);
        }
    }
}
