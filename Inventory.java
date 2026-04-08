/* :  You will write a program to act as a  cash register for a small business. It will provide two 
modes of operation. Admin: to allow the owner to add items to inventory with a SKU, price and 
number on hand.  Cashier: To scan items and get their price, subtract from inventory once the “Paid” 
button is clicked. It should calculate the sales tax on the sale of 5.5%, and record in a table the amount 
due to the State. */
import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Object> items = new ArrayList<>();
    @SuppressWarnings("FieldMayBeFinal")
    private static int numberOfItems;
    public Inventory(){
        numberOfItems = 0;
    }
        public Inventory(int numberOfItems){
            Inventory.numberOfItems = numberOfItems;
        }
        public int getNumberOfItems() {
            return numberOfItems;
        }
        public static int projectedProfit(double unitCost, double salePrice){
            return (int) ((salePrice - unitCost) * numberOfItems);
        }
        public void setItems(ArrayList<Object> items) {
            Inventory.items = items;
        }

        public static ArrayList<Object> getItems() {
            return items;
        }
        public static void addItems(int numberOfItems){
            for (int i = 0; i < numberOfItems; i++){
                items.add(new Object());
            }
        }
        public static void removeItems(int numberOfItems){
            for (int i = 0; i < numberOfItems; i++){
                if (!items.isEmpty()){
                    items.remove(items.size() - 1);
                }
            }
        }
        public static void printInventory(){
            System.out.println("Current Inventory: " + items);
        }
        @Override
        public String toString(){
            return "Inventory{" + "numberOfItems=" + numberOfItems + '}';
        }
    }

