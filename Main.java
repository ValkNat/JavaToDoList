import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main {

	//Stores entire to-do list dynamically
	ArrayList<String> to_do_list = new ArrayList<>();

	public static void main(String[] args) {



		Main mainClass = new Main();
		mainClass.emptyCheck();
		

	}


	public void mainPage() {

		//Displays tasks
		for(int i =0; i < to_do_list.size(); i++) {
			System.out.print("[" + i + "] ");
			System.out.println(to_do_list.get(i));
		}

		//Options menu
		System.out.println("[What would you like to do?");
		String options = "(1): Add Task \n (2): Delete Task \n (3): Close Program";
		System.out.println(options);
		Scanner options_scanner = new Scanner(System.in);
		String option_selected = options_scanner.nextLine();

		//Option selection menu
		switch (option_selected) {

		case "1":
			add_item(options_scanner);
			break;

		case "2":
			delete_item(options_scanner);

		case "3":
			System.exit(0);

		default:
			System.out.println("Error");

		}

		
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
				mainPage();
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
		PrintWriter writer = new PrintWriter(new FileWriter("to_do_list.txt", true));
		writer.println(added_item);
		writer.close();
	}

	catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }

        //Returns to home-page post-adding task
		mainPage();


	}


	public void delete_item(Scanner scanner) {
		System.out.println("Please enter index number of desired item to delete...");
		int index = scanner.nextInt();
		to_do_list.remove(index);

		//Following code also deletes item from to_do_list.txt
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("to_do_list.txt", false));
			for (String task : to_do_list) {
				writer.println(task);
			}
			writer.close();
		}

		catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }

        mainPage();



	}


	}

