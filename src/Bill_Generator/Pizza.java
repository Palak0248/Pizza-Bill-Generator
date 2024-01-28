package Bill_Generator;
public class Pizza {
	private int price;
    private boolean veg;
    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int backPackPrice = 20;
    private int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isOptedForTakeAway = false;
    private double discount = 0.0;

    // Constructor for checking veg or non-veg
    public Pizza(boolean veg) {
        this.veg = veg;
        if (this.veg) {
            this.price = 300;
        } else {
            this.price = 400;
        }
        basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addExtraToppings() {
        isExtraToppingsAdded = true;
        this.price += extraToppingsPrice;
    }

    public void takeAway() {
        isOptedForTakeAway = true;
        this.price += backPackPrice;
    }

    public void applyDiscount(double discountAmount) {
        this.discount = discountAmount;
        this.price -= discountAmount;
    }

    public int getTotalBill() {
        return this.price;
    }

    public void getBill() {
        String bill = " ";
        System.out.println("Pizza: " + basePizzaPrice);

        if (isExtraCheeseAdded) {
            bill += "Extra Cheese added: " + extraCheesePrice + "\n";
        }

        if (isExtraToppingsAdded) {
            bill += "Extra toppings added: " + extraToppingsPrice + "\n";
        }

        if (isOptedForTakeAway) {
            bill += "Take away: " + backPackPrice + "\n";
        }

        if (discount > 0.0) {
            bill += "Discount: " + discount + "\n";
        }

        bill += "Total Bill: " + this.price + "\n";
        System.out.println(bill);
    }
}