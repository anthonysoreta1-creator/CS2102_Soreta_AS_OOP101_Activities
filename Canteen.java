import java.util.Scanner;
public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==== MENU ====");
        System.out.println("1. Burger\t- $80.00");
        System.out.println("2. Pizza\t- $120.00");
        System.out.println("3. Pasta\t- $100.00");
        System.out.println("4. Sandwich\t- $70.00");
        System.out.println("5. Coffee\t- $80.00");

        String orderAgain = "Y";
        int totalItems = 0;
        double totalbeforeDiscount = 0;
        double totalDiscount = 0;

      
        while (orderAgain.equals("Y")) {

            System.out.print("\nEnter item number: ");
            int item = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (item < 1 || item > 5 || quantity < 1 || quantity > 10) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");
            } 
            else{
                System.out.print("Are you a student? (Y/N): ");
                char student = input.next().charAt(0);

                double price = 0;

                switch (item) {

                    case 1:
                        price = 80;
                        break;

                    case 2:
                        price = 120;
                        break;

                    case 3:
                        price = 100;
                        break;

                    case 4:
                        price = 70;
                        break;

                    case 5:
                        price = 80;
                        break;

                    default:
                        break;
                }

                double purchase = price * quantity;
                System.out.printf("\nSubtotal: $%.2f%n", purchase);

                double discountPercentage;

                if (student == 'Y' && purchase >= 500) {
                    discountPercentage = 0.15;
                } 
                else if (student == 'Y') {
                    discountPercentage = 0.10;
                } 
                else if (purchase >= 500) {
                    discountPercentage = 0.05;
                } 
                else {
                    discountPercentage = 0;
                }

                double discount = purchase * discountPercentage;
                double total = purchase - discount;

                totalItems += quantity;
                totalbeforeDiscount += purchase;
                totalDiscount += discount;

                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", total);
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next();
        }

        double finalAmount = totalbeforeDiscount - totalDiscount;

        System.out.println("\n==== ORDER SUMMARY ====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalbeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);

        System.out.println("\nThank you for ordering!");

        input.close();
    }
}
