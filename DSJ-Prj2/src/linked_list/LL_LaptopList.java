package linked_list;

import java.util.Scanner;
import com.Laptop;

public class LL_LaptopList extends Linked_List {

    Scanner sc = null;

    public LL_LaptopList() {
        super();
        sc = new Scanner(System.in);
    }

    public Node<Laptop> find(String code) {

        Node<Laptop> now = head;
        while (now != null) {
            if (now.data.getCode().equals(code)) {
                return now;
            }
            now = now.next;
        }
        return null;
    }

    void addProduct() {
        String code = "", name = "";
        int price = 0, guaranty = 0;
        System.out.println("-----ADD A NEW LAPTOP-----");
        boolean proceed = false;
        do {
            System.out.print("Enter laptop's code:");
            code = sc.nextLine().toUpperCase();
            proceed = find(code) != null;
            if (proceed == true) {
                System.out.println("This code is duplicated!");
            }
        } while (proceed);

        do {
            System.out.print("Enter laptop's name: ");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if (proceed == true) {
                System.out.println("Laptop's name must be inputted.");
            }
        } while (proceed);

        do {
            System.out.print("Enter laptop's price: ");
            price = Integer.parseInt(sc.nextLine().trim());
            if (price <= 0) {
                System.out.println("Laptop's price must be greater than 0");
            }
        } while (price <= 0);

        do {
            System.out.print("Enter laptop's guaranty: ");
            guaranty = Integer.parseInt(sc.nextLine().trim());
            if (guaranty <= 0) {
                System.out.println("Laptop's guaranty must be greater than 0");
            }
        } while (guaranty <= 0);
        Laptop emp = new Laptop(code, name, price, guaranty);
        this.Add(emp);
        System.out.println("This Laptop is added");
    }

    void removeProduct() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!!!!");
        } else {
            String code = "";
            System.out.print("Enter the code of laptop which will removed: ");
            code = sc.nextLine().toUpperCase();
            Node<Laptop> ref = find(code);
            if (ref == null) {
                System.out.println("This laptop does not exist.");
            } else {
                this.delete(ref.data);
                System.out.println("This laptop has been removed.");
            }
        }
    }

    void editGuaranty() {
        System.out.println("-----EDIT THE GUARANTY-----");
        if (this.isEmpty() == true) {
            System.out.println("The list is empty!!");
        } else {
            System.out.print("Enter the code of laptop which will be edited: ");
            String toCheck = sc.nextLine().toUpperCase();
            Node<Laptop> ref = find(toCheck);
                if (ref != null) {
                    int oldGua = ref.data.getGuaranty();
                    int newGua;
                    do {
                    System.out.print("Old Guaranty: " + oldGua + ", New Guaranty: ");
                    newGua = Integer.parseInt(sc.nextLine());
                    } while (oldGua == newGua);
                    ref.data.setGuaranty(newGua);
                    System.out.println("This guaranty was updated!!");
                } else {
                    System.out.println("This code is not existed!!");
                } 
        }
    }

    void editPrice() {
        System.out.println("-----EDIT THE PRICE-----");
        if (this.isEmpty() == true) {
            System.out.println("The list is empty!!");
        } else {
            System.out.print("Enter the code of laptop which will be edited: ");
            String toCheck = sc.nextLine().toUpperCase();
            Node<Laptop> ref = find(toCheck);
                if (ref != null) {
                    int oldPrice = ref.data.getGuaranty();
                    int newPrice;
                    do {
                    System.out.print("Old Guaranty: " + oldPrice + ", New Guaranty: ");
                    newPrice = Integer.parseInt(sc.nextLine());
                    } while (oldPrice == newPrice);
                    ref.data.setGuaranty(newPrice);
                    System.out.println("This price was updated!!");
                } else {
                    System.out.println("This code is not existed!!");
                } 
        }
    }

    void print() {
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("LAPTOP LIST");
            this.printAll();
        }
    }

}
