/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import com.Menu;

public class LL_Laptop_Program {
        public static void main(String[] args){
        System.out.println("=====LAPTOP MANAGEMENT=====");
        Menu menu = new Menu();
        menu.add("Add a new laptop");
        menu.add("Remove a laptop");
        menu.add("Edit the Guaranty of laptop");
        menu.add("Edit price of laptop");
        menu.add("Prin employee list");
        menu.add("Quit");
        LL_LaptopList proList = new LL_LaptopList();
        int userChoice;
        do{
            userChoice = menu.getUserChoice();
            switch(userChoice){
                case 1 : proList.addProduct(); break;
                case 2 : proList.removeProduct(); break;
                case 3 : proList.editGuaranty(); break;
                case 4 : proList.editPrice(); break; 
                case 5 : proList.print(); break;
                default: System.out.println("GOOD BYE"); break;
            }
        }while(userChoice > 0 && userChoice < 6);
    }
}
