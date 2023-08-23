import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	//Stores entire to-do list dynamically
	ArrayList<String> to_do_list = new ArrayList<>();

	public static void main(String[] args) {



		Main mainClass = new Main();
		mainClass.emptyCheck();
		

	}

	public void emptyCheck() {

	try {

		if (new File("to_do_list.txt").exists()) {
			System.out.println("File already exists! Add task now? [y/n]");
			Scanner scanner = new Scanner(System.in);
			String add_task = scanner.nextLine();

			if (add_task.equals("y")) {
				add_item(scanner);
			}

			else {
				System.out.println("Closing program");
			}

		}

		else {
			System.out.println("File does not exist! Creating one now...");
			PrintWriter writer = new PrintWriter("to_do_list.txt", "UTF-8");
			writer.close();
		}

	}

		  catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }
		
		}
	

	public void add_item(Scanner scanner) {
		System.out.println("What task would you like to add?");
		to_do_list.add(scanner.nextLine());
	}

}
