package BurgerCompany;

public enum ExtraItem {



    SAUCE("Sauce", 10.00, 1),
    CHEESE("Cheese", 20.00, 2),
    PATTY("Patty", 30.00, 3),
    NO_EXTRA_ITEM("No extra item", 0.00, 4);

    private String item;
    private double price;
    private int itemId;

    ExtraItem(String item, double price, int itemId) {
        this.item = item;
        this.price = price;
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getItemId() {
        return itemId;
    }

    public static ExtraItem getItemById(int id) {
        switch (id) {
            case 1:
                return SAUCE;
            case 2:
                return CHEESE;
            case 3:
                return PATTY;
            default:
                return NO_EXTRA_ITEM;
        }
    }

    public static void printExtraItems() {
        System.out.println("\t" + SAUCE.toString() + "\n" +
                "\t" + CHEESE.toString() + "\n" +
                "\t" + PATTY.toString());
    }

    @Override
    public String toString() {
        return getItemId() + " - " + getItem() + ": $" + getPrice();
    }
}