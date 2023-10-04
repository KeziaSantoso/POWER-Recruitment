import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<String> namesList = new ArrayList<>();
	ArrayList<String> genderList = new ArrayList<>();
	ArrayList<String> adressList = new ArrayList<>();
	ArrayList<Integer> agesList = new ArrayList<>();
	ArrayList<String> initialsList = new ArrayList<>();
	
	public Main() {
		Integer chosenNumber = 0;
		
		do {
		printGreetings();
		chosenNumber = chooseNumber();
		
			if(chosenNumber == 1) {
				menu1();
			}else if (chosenNumber == 2) {
				menu2();
			}else if(chosenNumber == 3) {
				menu3();
			}
			
		}while(chosenNumber != 4);
		
		System.out.println("Goodbye!");
	}
	
	void printGreetings() {
		System.out.println("POWER Recruitment");
		System.out.println("=================");
		System.out.println("1. Input New Candidate");
		System.out.println("2. View Candidate's Data");
		System.out.println("3. Remove Candidate");
		System.out.println("4. Exit");
	}
	
	Integer chooseNumber() {
		int choose = 0;
		
		System.out.print("Choose: ");
		choose = scan.nextInt();
		scan.nextLine();
		
		return choose;
	}
	
	
	
	void menu1() {
		String name = "";
		
		do {
			System.out.print("Input candidate's name[5..20]: ");
			name = scan.nextLine();
			
			if(!name.contains(" ")) {
				System.out.println("name must be at least 2 words!\n");
			}
			
		}while(name.length() < 5 || name.length() > 20 || !name.contains(" ") || name.startsWith(" ") || name.endsWith(" "));
		
		String gender = "";
		
		do {
			System.out.print("Input candidate's gender[Male : Female]: ");
			gender = scan.nextLine();
		}while(!gender.equals("Male") && !gender.contentEquals("Female"));
		
		String adress = "";
		
		do {
			System.out.print("Input candidate's adress [must be ended with 'Street']: ");
			adress = scan.nextLine();
		}while(!adress.endsWith("Street"));
		
		int age = 0;
		
		do {
			System.out.print("Input candidate's age[17..30]: ");
			age = scan.nextInt();
			scan.nextLine();
		}while(age < 17 || age > 30);
		
		namesList.add(name);
		genderList.add(gender);
		adressList.add(adress);
		agesList.add(age);
		
		
		String initial = String.valueOf(name.charAt(0)) + name.charAt(name.indexOf(" ") + 1);
		System.out.println("Thank you for registering! Your Initial is: " + initial + "\n");
		initialsList.add(initial);
	}
	
	void menu2() {
		if(namesList.isEmpty()) {
			System.out.println("No data!\n");
		}else {
			for(int i = 0; i < namesList.size() - 1; i++) {
				for(int j = 0; j < namesList.size() - i - 1; j++) {
					if(namesList.get(j).compareTo(namesList.get(j + 1)) > 0) {
						Collections.swap(namesList, j, j + 1);
						Collections.swap(initialsList, j, j + 1);
						Collections.swap(genderList, j, j + 1);
						Collections.swap(adressList, j, j + 1);
						Collections.swap(agesList, j, j + 1);
					}
				}
			}
			
			System.out.println("| No | Name                           | Initial | Gender     | Age | Adress               |");
			for(int i = 0; i < namesList.size(); i++) {
				System.out.printf("| " + (i + 1) + "  | " + "%-30s | " + "%-7s | " + "%-10s | " + "%-3d | " + "%-20s |\n", namesList.get(i), initialsList.get(i), genderList.get(i), agesList.get(i), adressList.get(i));
			}
		}
	}
	
	void menu3() {
		menu2();
		
		int remove = 0;
		
		if(!namesList.isEmpty()) {
			System.out.print("Input candidate to be removed[1.." + namesList.size() + "] [0 for cancel]: ");
			remove = scan.nextInt();
			scan.nextLine();
			
			if(remove == 0) {
				System.out.println("Canceled!\n");
			}else {
				remove -= 1;
				namesList.remove(remove);
				initialsList.remove(remove);
				genderList.remove(remove);
				agesList.remove(remove);
				adressList.remove(remove);
			}
		}else {
			System.out.println("No data!\n");
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
