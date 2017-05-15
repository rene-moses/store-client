import java.util.Scanner;

/**
 * Authored by Moses Franco and Rene Cortez on 5/15/17.
 */
public class Store {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String receipt = "";
		double saleTotal = 0;

		menuDisplay(input, receipt, saleTotal);



	}

	public static void menuDisplay(Scanner input, String receipt, double salesTotal){
		System.out.println("1) Sale\n2) Print\n3) Exit");
		int menuItem = input.nextInt();
		if (menuItem ==1){
			salesDisplay(input, receipt, salesTotal);
		} else if (menuItem == 2){
			printReceipt(receipt);
		} else if (menuItem == 3) {
			System.out.println("Good Bye.");
			System.exit(0);
		}

	}

	public static double salesDisplay(Scanner input, String receipt, double saleTotal){

		int itemCounter = 1;
		System.out.println("Type item name: ");
		String saleItem = input.next();
		System.out.println("Enter cost of item");
		double itemPrice = input.nextDouble();
		System.out.println("Enter the quantity of the item being purchased");
		int itemQuantity = input.nextInt();
		receipt = itemCounter + ") " + itemQuantity + " x " + itemPrice + " " + saleItem;
		System.out.printf(receipt);
		saleTotal = itemPrice * (double) itemQuantity;
		System.out.println(saleTotal);
		return saleTotal;


	}

	public static void printReceipt (String receipt){
		System.out.println(receipt);
	}

	public static void returnMainMenu (Scanner input){

	}

}
