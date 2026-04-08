
import java.util.Scanner;
import java.util.ArrayList;
public class CashRegister {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Cash Register Program!");
        System.out.println("Please select a mode: ");
        //admin mode or cashier mode
        System.out.println("1. Admin Mode");
        System.out.println("2. Cashier Mode");
        int mode = input.nextInt();
        input.nextLine(); 
        switch (mode) {
            case 1 -> adminMode(input);
            case 2 -> cashierMode(input);
            default -> System.out.println("Invalid mode selected.");
        }
        input.close();
    }

    private static void adminMode(Scanner input) {
       //add items
    
        System.out.println("Enter the number of items to add: ");
         int numItems = input.nextInt();
        input.nextLine(); // Consume newline
        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter description for item " + (i + 1) + ": ");
            String description = input.nextLine();
            System.out.println("Enter unit cost for item " + (i + 1) + ": ");
            double unitCost = input.nextDouble();
            System.out.println("Enter sale price for item " + (i + 1) + ": ");
            double salePrice = input.nextDouble();
            System.out.println("Enter number on hand for item " + (i + 1) + ": ");
            int numberOnHand = input.nextInt();
            input.nextLine();
            ArrayList<Item> inventory = new ArrayList<>();
            // Store the item in the inventory array list
            inventory.add(new Item(description, unitCost, salePrice, numberOnHand));
            for (Item item : inventory) {     //loop through inventory and print details of items
            System.out.println("Description: " + item.getDescription());
            System.out.println("Unit Cost: " + item.getUnitCost());
            System.out.println("Sale Price: " + item.getSalePrice());
            System.out.println("Number on Hand: " + item.getNumberOnHand());
            System.out.println("Projected Profit: " + (item.getSalePrice() - item.getUnitCost()) * item.getNumberOnHand());
        }
        }
       
    }

    private static void cashierMode(Scanner input) {
        //scan items
            System.out.println("Enter the number of items to sell: ");
            int numItems = input.nextInt();
        //calculate totals
        double total = 0;
        //complete sales
        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter SKU for item " + (i + 1) + ": ");
            String sku = input.nextLine();
            System.out.println("Enter the number of items: " + (i + 1) + ": ");
            int quantity = input.nextInt();
            input.nextLine(); 

            total += 10 * quantity;
        }
        //show total and ask for payment
        System.out.println("Total for the sale: " + total);
        System.out.println("Enter 'continue' or 'Cancel': ");
        String action = input.nextLine();
        //complete or cancel sale
        if (action.equalsIgnoreCase("continue")) {
            System.out.println("Sale Successful");
            //calculate sales tax
            double salesTax = total * 0.055;
            System.out.println("Sales Tax: " + salesTax);
        } else if (action.equalsIgnoreCase("Cancel")) {
            System.out.println("Sale Cancelled");
        } else {
            System.out.println("Action Not Valid. Sale not completed.");
        }
        
    }

}