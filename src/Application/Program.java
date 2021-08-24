package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Calendar cal = Calendar.getInstance();
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Bithdate (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		
		Client client = new Client(name, email, date);	
		
		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.printf("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		for(int i=1;i<=items;i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String prod_name = sc.nextLine();
			System.out.print("Product price: ");
			double prod_price = sc.nextDouble();
			
			Product product = new Product(prod_name, prod_price);
			
			System.out.print("Quantity: ");
			int prod_quantity = sc.nextInt();
						
			OrderItem item = new OrderItem(prod_quantity, prod_price, product);
			order.addItem(item);
						
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
			
		sc.close();

	}

}
