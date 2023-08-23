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

			//New region of code to add pre-existing tasks in to_do_list.txt to to_do_list ArrayList
			File file = new File("to_do_list.txt");
			Scanner filescanner = new Scanner(file);
			while (filescanner.hasNextLine()) {
				to_do_list.add(filescanner.nextLine());
			}
			System.out.println(to_do_list);

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
		String added_item = scanner.nextLine();
		to_do_list.add(added_item);

	try {
		PrintWriter writer = new PrintWriter("to_do_list.txt", "UTF-8");
		writer.println(added_item);
		writer.close();

	}

	catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }

		System.out.println("Current to-do list:");

		for(int i = 0; i < to_do_list.size(); i++) {
			System.out.println(to_do_list.get(i));
		}




	}


	}

