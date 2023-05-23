/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int getUserChoice() {
        int choice = 0, i;
        for (i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Select an option: 1.." + i + ":");
                choice = Integer.parseInt(sc.nextLine());
                if (choice <= 0 || choice > i) {
                    System.out.println("Please Enter choice from 1.." + i + "!!!");
                }else{
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please Enter choice from 1.." + i + "!!!");
            }
        }
        return choice;
    }
}
