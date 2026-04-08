
public class Item {
    //instance fields
    private int numberOnHand;
    private double unitCost;
    private double salePrice;
    private String description;
    //alternate constructor
    public Item(String description, double unitCost, double salePrice, int numberOnHand) {
        this.description = description;
        this.unitCost = unitCost;
        this.salePrice = salePrice;
        this.numberOnHand = numberOnHand;
    }  
    //getters
    public String getDescription() {
        return description;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getNumberOnHand() {
        return numberOnHand;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public void setNumberOnHand(int numberOnHand) {
        this.numberOnHand = numberOnHand;
    }
}
