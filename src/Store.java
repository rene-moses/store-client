import java.util.Scanner;

/**
 * Authored by Moses Franco and Rene Cortez on 5/15/17.
 */
public class Store {
	public static void main(String[] args) {
		System.out.println("1) Sale\n2)Print\n3)Exit");
		Scanner input = new Scanner(System.in);
		int menuItem = input.nextInt();
		String receipt;

		if (menuItem == 1){
			System.out.println("Type item name: ");
			String saleItem = input.next();
			System.out.println("Enter cost of item");
			double itemPrice = input.nextDouble();
			System.out.println("Enter the quantity of the item being purchased");
			int itemQuantity = input.nextInt();
		}
	}
}
