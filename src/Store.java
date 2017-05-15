import java.util.Scanner;

/**
 * Authored by Moses Franco and Rene Cortez on 5/15/17.
 */
public class Store {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String receipt = "";
		double saleTotal = 0;
		int itemCounter = 1;

		menuDisplay(input, receipt, saleTotal, itemCounter);



	}

	public static void menuDisplay(Scanner input, String receipt, double saleTotal, int itemCounter){
		System.out.println("1) Sale\n2) Print\n3) Exit");
		int menuItem = input.nextInt();
		if (menuItem ==1){
			salesDisplay(input, receipt, saleTotal, itemCounter);
		} else if (menuItem == 2){
			printReceipt(input, receipt, saleTotal, itemCounter);
		} else if (menuItem == 3) {
			exitSystem();
		}

	}

	public static void salesDisplay(Scanner input, String receipt, double saleTotal, int itemCounter){

		String saleItem = getItemName(input);
		double itemPrice = getItemPrice(input);
		int itemQuantity = getItemQuantity(input);
		receipt += "\n" + itemCounter + ") " + itemQuantity + " x " + itemPrice + " " + saleItem;
		saleTotal += itemPrice * (double) itemQuantity;
		itemCounter++;
        returnMainMenu(input, receipt, saleTotal, itemCounter);


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
		return input.next();
	}

	public static void printReceipt (Scanner input, String receipt, Double saleTotal, int itemCounter){
		System.out.println(receipt);
		System.out.printf("%f2%n", saleTotal);
		returnMainMenu(input, receipt, saleTotal, itemCounter);
	}

	public static void exitSystem() {
		System.out.println("Good Bye.");
		System.exit(0);
	}

	public static void returnMainMenu (Scanner input, String receipt, double saleTotal, int itemCounter){
		System.out.println("Do you wish to return to the main menu? (y/n)");
		String continueAnswer = input.next();
		if ("y".equalsIgnoreCase(continueAnswer)){
			menuDisplay(input, receipt, saleTotal, itemCounter);
		}
		else if("n".equalsIgnoreCase(continueAnswer)){
			exitSystem();
		}
		else {
			System.out.println("That's not a proper answer");
			returnMainMenu(input, receipt, saleTotal, itemCounter);
		}
	}

}
