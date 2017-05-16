import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Authored by Moses Franco and Rene Cortez on 5/15/17
 * Codeup
 * Pinnacles
 */
public class Store {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String receipt = "";
		double saleTotal = 0;
		int itemCounter = 1;

		menuDisplay(input, receipt, saleTotal, itemCounter);
	}

	public static void menuDisplay(Scanner input, String receipt, double saleTotal, int itemCounter) {
		System.out.println("1) Sale\n2) Print\n3) Exit");
		String menuItem = input.nextLine();
		switch (menuItem) {
			case "1":
				salesDisplay(input, receipt, saleTotal, itemCounter);
				break;
			case "2":
				printReceipt(input, receipt, saleTotal, itemCounter);
				break;
			case "3":
				exitSystem(input, receipt, saleTotal, itemCounter);
				break;
			default:
				System.out.println("That's not a proper response");
				menuDisplay(input, receipt, saleTotal, itemCounter);
				break;
		}
	}

	public static void salesDisplay(Scanner input, String receipt, double saleTotal, int itemCounter) {
		String saleItem = getItemName(input);
		double itemPrice = getItemPrice(input);
		int itemQuantity = getItemQuantity(input);
		receipt += "\n" + itemCounter + ") " + itemQuantity + " x $" + itemPrice + " " + saleItem;
		saleTotal += itemPrice * (double) itemQuantity;
		itemCounter++;
		continueAddingItems(input, receipt, saleTotal, itemCounter);
	}

	public static int getItemQuantity(Scanner input) {
		System.out.println("Enter the quantity of the item being purchased");
		return input.nextInt();
	}

	public static double getItemPrice(Scanner input) {
		System.out.println("Enter cost of item");
		return input.nextDouble();
	}

	public static String getItemName(Scanner input) {
		System.out.println("Type item name: ");
		input.nextLine();
		return input.nextLine();
	}

	public static void printReceipt(Scanner input, String receipt, Double saleTotal, int itemCounter) {
		Date date = new Date();
		String border = "************";
		System.out.println(border);
		System.out.println(date);
		System.out.println(receipt);
//		System.out.printf("Your total is: $%.2f%n%n", saleTotal);
		customMoney("$###,###.00", saleTotal);
		System.out.println(border);
		returnMainMenu(input, receipt, saleTotal, itemCounter);
	}

	public static void customMoney(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		System.out.println(output + "\n");
	}

	public static void returnMainMenu(Scanner input, String receipt, double saleTotal, int itemCounter) {
		System.out.println("Do you wish to return to the main menu? (y/n)");
		String continueAnswer = input.next();
		if ("y".equalsIgnoreCase(continueAnswer)) {
			menuDisplay(input, receipt, saleTotal, itemCounter);
		} else if ("n".equalsIgnoreCase(continueAnswer)) {
			exitSystem(input, receipt, saleTotal, itemCounter);
		} else {
			System.out.println("That's not a proper answer");
			returnMainMenu(input, receipt, saleTotal, itemCounter);
		}
	}

	public static void continueAddingItems(Scanner input, String receipt, double saleTotal, int itemCounter) {
		System.out.println("Do you want to add more items? (y/n)");
		String continueAnswer = input.next();
		if ("y".equalsIgnoreCase(continueAnswer)) {
			salesDisplay(input, receipt, saleTotal, itemCounter);
		} else if ("n".equalsIgnoreCase(continueAnswer)) {
			returnMainMenu(input, receipt, saleTotal, itemCounter);
		} else {
			System.out.println("That's not a proper answer");
			continueAddingItems(input, receipt, saleTotal, itemCounter);
		}
	}

	public static void exitSystem(Scanner input, String receipt, double saleTotal, int itemCounter) {
		System.out.println("Good Bye.");
		System.exit(0);
	}
}
