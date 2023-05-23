package main;

import sparse_matrix.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int choice = 0;
        int subIndex = 0, stuIndex = 0, grade = 0;
        IntSparseMatrix originMatrix = new IntSparseMatrix(15, 15);
        System.out.println("----MENU----");
        menu.add("Add grade of subject");
        menu.add("Print subject's grade table(base on Subject's Index)");
        menu.add("Print student's grade table(base on Student's Index)");
        menu.add("Update grade ");
        menu.add("Quit");
        do {
            choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    System.out.println("----ADD----");
                    do {
                        System.out.print("Enter Subject' index: ");
                        try {
                            subIndex = Integer.parseInt(sc.nextLine().trim());
                            if (subIndex <= 0 || subIndex >= originMatrix.getMaxCol()) {
                                System.err.println("Invalid index, please re-enter a new subject index");
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid index, please re-enter a new subject index");
                        }
                    } while (subIndex <= 0 || subIndex >= originMatrix.getMaxCol());
                    boolean check = true;
                    String again = "";
                    while (check = true) {
                        try {
                            System.out.print("Enter Student's index: ");
                            try {
                                stuIndex = Integer.parseInt(sc.nextLine().trim());
                                if (stuIndex <= 0 || stuIndex >= originMatrix.getMaxRow()) {
                                    System.err.println("Invalid index, please re-enter a new student index");
                                }
                            } catch (Exception e) {
                                break;
                            }

                            System.out.print("Enter Student's grade: ");
                            try {
                                grade = Integer.parseInt(sc.nextLine().trim());
                                if (grade < 0 || grade > 10) {
                                    System.out.println("Invalid grade [0-10], please re-enter a new grade");
                                }
                            } catch (Exception e) {
                                break;
                            }
                            originMatrix.add(stuIndex, subIndex, grade);
                            System.out.println("Enter Y to re-enter OR N to stop add: ");
                            again = sc.nextLine().trim();
                            if(again.equalsIgnoreCase("N")){
                                check  = false;
                                break;
                            }
                        } catch (Exception e) {
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("----PRINT GRADE TABLE BY SUBJECT' INDEX----");
                    do {
                        subIndex = 0;
                        System.out.print("Enter Subject' index: ");
                        try {
                            subIndex = Integer.parseInt(sc.nextLine().trim());
                            if (subIndex <= 0 || subIndex >= originMatrix.getMaxCol()) {
                                System.err.println("Invalid index, please re-enter a new index[FROM 1 TO " + (originMatrix.getMaxCol() - 1) + "]");
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid index, please re-enter a new subject's index");
                        }
                    } while (subIndex <= 0 || subIndex >= originMatrix.getMaxCol());
                    printSubTable(originMatrix, subIndex);
                    break;
                case 3:
                    System.out.println("----PRINT GRADE TABLE BY STUDENT INDEX----");
                    do {

                        System.out.print("Enter Student's index: ");
                        try {
                            stuIndex = Integer.parseInt(sc.nextLine().trim());;
                            if (stuIndex <= 0 || stuIndex >= originMatrix.getMaxRow()) {
                                System.err.println("Invalid index, please re-enter a new student's index[FROM 1 TO " + (originMatrix.getMaxRow() - 1) + "]");
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid index, please re-enter a new student's index");
                        }
                    } while (stuIndex <= 0 || stuIndex >= originMatrix.getMaxRow());
                    printStuTable(originMatrix, stuIndex);
                    break;

                case 4:
                    System.out.println("---Update grade---");

                    do {
                        stuIndex = 0;
                        System.out.print("Enter student's index to update: ");
                        try {
                            System.out.flush();
                            stuIndex = Integer.parseInt(sc.nextLine());
                            if (stuIndex <= 0 || stuIndex >= originMatrix.getMaxRow()) {
                                System.err.println("Please enter a valid number from 1 to " + (originMatrix.getMaxRow() - 1));
                            }
                        } catch (Exception e) {
                            System.err.println("Please enter a valid number");
                        }
                    } while (stuIndex <= 0 || stuIndex >= originMatrix.getMaxRow());

                    do {
                        subIndex = 0;
                        System.out.print("Enter subject's index to update:");
                        try {
                            System.out.flush();
                            subIndex = Integer.parseInt(sc.nextLine());
                            if (subIndex <= 0 || subIndex >= originMatrix.getMaxCol()) {
                                System.err.println("Please enter a valid number from 1 to " + (originMatrix.getMaxCol() - 1));
                            }
                        } catch (Exception e) {
                            System.err.println("Please enter a valid number");
                        }

                    } while (subIndex <= 0 || subIndex >= originMatrix.getMaxCol());

                    do {
                        grade = -1;
                        System.out.print("Enter student's grade:");
                        try {
                            grade = Integer.parseInt(sc.nextLine());
                            if (grade < 0 || grade > 10) {
                                System.err.println("Please enter a number from 1 to 10!");
                            }
                        } catch (Exception e) {
                            System.err.println("Please enter a number from 1 to 10");
                        }

                    } while (grade < 0 || grade > 10);

                    originMatrix.update(stuIndex, subIndex, grade);
                    System.out.println("Update successful!");
                    break;
                default:
                    System.out.println("Good bye! Have a good day!");

            }
        } while (choice > 0 && choice < menu.size());
    }

   public static void printSubTable(IntSparseMatrix m, int subIndex) {
        if (m == null) {
            System.out.println("Empty matrix!");
            return;
        }
        System.out.print("Stu\\Sub\t");
        System.out.print(subIndex + "\t");

        System.out.println();

        for (int i = 1; i < m.getMaxRow(); i++) {
            System.out.print(i + "\t");

            Integer val = m.get(i, subIndex);
            System.out.print((val == null ? 0 : val) + "\t");

            System.out.println();
        }
    }

    public static void printStuTable(IntSparseMatrix m, int stuIndex) {
        if (m == null) {
            System.out.println("Empty matrix!");
            return;
        }
        System.out.print("Stu\\Sub\t");
        for (int i = 1; i < m.getMaxCol(); i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print(stuIndex + "\t");

        for (int i = 1; i < m.getMaxCol(); i++) {

            Integer val = m.get(stuIndex, i);
            System.out.print((val == null ? 0 : val) + "\t");

        }
        System.out.println("");
    }
}
