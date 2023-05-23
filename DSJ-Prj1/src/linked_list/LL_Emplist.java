/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import com.Employee;
import java.util.Scanner;
public class LL_Emplist extends SSL {
    Scanner sc = null;
 
    public LL_Emplist() {
        super();
        sc = new Scanner(System.in);
    }
    
    //find
    public SSLNode<Employee> find(String code) {
       
    SSLNode<Employee> now = head;
    while(now != null){
        if(now.data.getCode().equals(code)) return now;
        now = now.next;
    }
        return null;
    }

    //add
    public void add() {
        String code = "", name = "";
        int salary = 0, guaranty = 0;
        System.out.println("Add new employeee");
        boolean proceed = false;
        do {
            System.out.print("Enter employee's code:");
            code = sc.nextLine().toUpperCase();
            proceed = find(code) != null;   
            if (proceed == true) {
                System.out.println("This code is duplicated!");
            }
        } while (proceed);

        do {
            System.out.print("Enter employee's name: ");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if (proceed == true) {
                System.out.println("Employee's name must be inputted.");
            }
        } while (proceed);

        do {
            System.out.print("Enter employee's salary");
            salary = Integer.parseInt(sc.nextLine().trim());
            if (salary <= 0) {
                System.out.println("Employee's salary must be greater than 0");
            }
        } while (salary <= 0);

        Employee emp = new Employee(code, name, salary);
        this.Add(emp);
        System.out.println("This employee is added");

    }

    public void remove() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!!!!");
        } else {
            String code = "";
            System.out.print("Enter the code of employee who will removed: ");
            code = sc.nextLine().toUpperCase();
            SSLNode<Employee> ref = find(code);
            if (ref == null) {
                System.out.println("He/she does not exist.");
            } else {
                this.delete(ref.data);
                System.out.println("This employee has been removed.");
            }
        }
    }

    //increasing
    public void increaseSalary() {
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            String code = "";
            System.out.print("Enter the code of employee who will be promoted: ");
            code = sc.nextLine().toUpperCase();
            SSLNode<Employee> ref = find(code);
            if (ref == null) {
                System.out.println("He/she does not exist.");
            } else {
                int oldSal = ref.data.getSalary();
                int newSal;
                do {
                    System.out.print("Old salary: " + oldSal + ", new salary: ");
                    newSal = Integer.parseInt(sc.nextLine());
                } while (newSal <= oldSal);
                ref.data.setSalary(newSal);
                System.out.println("His/her salary has been updated.");
            }
        }
    }
    public void print(){
        if(this.isEmpty()) System.out.println("The list is empty.");
        else{
            System.out.println("EMPLOYEE LIST");
        this.printAll();
        }
    }
}
