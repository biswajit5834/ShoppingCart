package SimpleJava;

import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceA = 20;
        double priceB = 40;
        double priceC = 50;

        int quantityA = getProductQuantity(scanner, "Product A");
        boolean giftA = isProductGift(scanner, "Product A");

        int quantityB = getProductQuantity(scanner, "Product B");
        boolean giftB = isProductGift(scanner, "Product B");

        int quantityC = getProductQuantity(scanner, "Product C");
        boolean giftC = isProductGift(scanner, "Product C");

        double totalA = calculateTotal(priceA, quantityA);
        double totalB = calculateTotal(priceB, quantityB);
        double totalC = calculateTotal(priceC, quantityC);

        double subtotal = totalA + totalB + totalC;

        DiscountCal dc = new DiscountCal();
        double discountAmount = dc.calculateDiscount(subtotal, quantityA, quantityB, quantityC);

        double shippingFee = calculateShippingFee(quantityA, quantityB, quantityC);
        double giftWrapFee = calculateGiftWrapFee(quantityA, giftA) + calculateGiftWrapFee(quantityB, giftB) + calculateGiftWrapFee(quantityC, giftC);

        double totalAmount = subtotal - discountAmount + shippingFee + giftWrapFee;


        System.out.println("\nProduct Details:");
        printProductDetails("Product A", quantityA, totalA);
        printProductDetails("Product B", quantityB, totalB);
        printProductDetails("Product C", quantityC, totalC);

        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Discount Applied: " + dc.getDiscountName() + " - $" + discountAmount);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Gift Wrap Fee: $" + giftWrapFee);
        System.out.println("Total: $" + totalAmount);

        scanner.close();
    }

    private static int getProductQuantity(Scanner scanner, String productName) {
        System.out.print("Enter quantity for " + productName + ": ");
        return scanner.nextInt();
    }

    private static boolean isProductGift(Scanner scanner, String productName) {
        System.out.print("Is " + productName + " a gift? (true/false): ");
        return scanner.nextBoolean();
    }

    private static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    private static double calculateShippingFee(int quantityA, int quantityB, int quantityC) {
        int totalQuantity = quantityA + quantityB + quantityC;
        int packages = (int) Math.ceil((double) totalQuantity / 10);
        return packages * 5;
    }

    private static double calculateGiftWrapFee(int quantity, boolean isGift) {
        return isGift ? quantity : 0;
    }

    private static void printProductDetails(String productName, int quantity, double totalAmount) {
        System.out.println(productName + ": Quantity - " + quantity + ", Total Amount - $" + totalAmount);
    }
}

class DiscountCal {
    private String discountName;
    private double discountAmount;

    public double calculateDiscount(double subtotal, int quantityA, int quantityB, int quantityC) {
       
        this.discountName = "No Discount";
        this.discountAmount = 0;

        return discountAmount;
    }

    public String getDiscountName() {
        return discountName;
    }
}
