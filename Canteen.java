import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== MENU ====");
        System.out.println("1. Burger\t- $80.00");
        System.out.println("2. Pizza\t- $120.00");
        System.out.println("3. Pasta\t- $100.00");
        System.out.println("4. Sandwich\t- $70.00");
        System.out.println("5. Coffee\t- $80.00");

        String again = "Y";
        int itemCount = 0;
        double overallTotal = 0;
        double overallDiscount = 0;

        while (again.equals("Y")) {

            System.out.print("\nEnter item number: ");
            int choice = sc.nextInt();

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            if (choice < 1 || choice > 5 || qty < 1 || qty > 10) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");
            } 
            else {
              System.out.print("Are you a student? (Y/N): ");
                char studentAnswer = sc.next().charAt(0);

                double itemPrice = 0;

                switch (choice) {

                    case 1:
                        itemPrice = 80;
                        break;

                    case 2:
                        itemPrice = 120;
                        break;

                    case 3:
                        itemPrice = 100;
                        break;

                    case 4:
                        itemPrice = 70;
                        break;

                    case 5:
                        itemPrice = 80;
                        break;

                    default:
                        break;
                }

                double amount = itemPrice * qty;

                System.out.printf("\nSubtotal: $%.2f%n", amount);

                double rate;

                if (studentAnswer == 'Y' && amount >= 500) {
                    rate = 0.15;
                } 
                else if (studentAnswer == 'Y') {
                    rate = 0.10;
                } 
                else if (amount >= 500) {
                    rate = 0.05;
                } 
                else {
                    rate = 0;
                }

                double reduction = amount * rate;
                double payable = amount - reduction;

                itemCount += qty;
                overallTotal += amount;
                overallDiscount += reduction;

                System.out.printf("Discount: $%.2f%n", reduction);
                System.out.printf("Order total: $%.2f%n", payable);
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = sc.next();
        }

        double netAmount = overallTotal - overallDiscount;

        System.out.println("\n==== ORDER SUMMARY ====");
        System.out.println("Total items: " + itemCount);
        System.out.printf("Total before discount: $%.2f%n", overallTotal);
        System.out.printf("Total discount: $%.2f%n", overallDiscount);
        System.out.printf("Final amount: $%.2f%n", netAmount);

        System.out.println("\nThank you for ordering!");

        sc.close();
    }
}
