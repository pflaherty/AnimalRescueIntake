// @Student name: Paige Flaherty
// @version: 2.0

package grazioso.milestone;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // Instance variables
	private static Scanner scnr = new Scanner(System.in);
	
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

	private static String menuSelection = "";

    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input and takes the appropriate action.
		while (!menuSelection.equalsIgnoreCase("q")) {  // Ignoring case so input will not be case-sensitive
			displayMenu();  // Calling displayMenu method
			menuSelection = scnr.nextLine();  // Prompting user for input
			switch(menuSelection) {  // Using case for better readability compared to if/else
			case "1":
				intakeNewDog(scnr);
				break;
			case "2":
				intakeNewMonkey(scnr);
	        	break;
			case "3":
				// TODO:Reserve an animal
				reserveAnimal(scnr);
	        	System.out.println("Reserve an animal code is in progress");
	        	break;
			case "4":
				printAnimals();
	        	break;
			case "5":
				printAnimals();
	        	break;
			case "6":
				printAnimals();
	        	break;
			case "q":  // Case is for lower-case,
			case "Q":  // Case is for upper-case, same action will be performed for either input
	        	System.out.println("\nYou have entered " + menuSelection + " to quit the Rescue Animal System application.");
	        	break;
			default:  // Default case will cover all other inputs, for example if user types "7" or "one"
	        	System.out.println("Invalid input. Refer to menu and select valid entry.");
	        	break;
			}
		}
		
		System.out.println("Thank you for using the Rescue Animal System.");
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", "false", "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", "false", "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", "true", "Canada");
        Dog dog4 = new Dog("Sunshine", "Golden Retriever", "female", "3", "75.9", "10-25-2020", "Canada", "in service", "false", "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Curious George", "male", "11", "75.6", "05-13-2019", "United States", "intake", "false", "United States", "16.6", "32.4", "33.4", "Capuchin");
        Monkey monkey2 = new Monkey("Harambe", "male", "13", "235.2", "02-04-2020", "United States", "Phase I", "false", "United States", "10.9", "49.7", "50.8", "Tamarin");
        Monkey monkey3 = new Monkey("Koko", "female", "24", "225.6", "12-23-2019", "Canada", "in service", "true", "Canada", "9.2.6", "42.0", "42.9", "Marmoset");
        Monkey monkey4 = new Monkey("Tiny Kong", "female", "17", "63.2", "10-25-2020", "Canada", "in service", "false", "Canada", "9.2.6", "42.0", "42.9", "Guenon");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }

    // Method for intakeNewDog. Will first prompt for dog name, then check if dog is already in system. If dog
    	// is in system, user is prompted with message. Otherwise user will be prompted for new dog intake information.
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("\nWhat is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        
      // This is code to instantiate a new dog and add it to the appropriate list.
       	// Do not need to prompt for dog name again, name was already obtained at beginning of method.
        System.out.println("What is the dog's breed?");
        String breed = scnr.nextLine();
                
        // Prompting for gender. Using while loop to validate user input.
        System.out.println("What is the dog's gender?");
        String gender = scnr.nextLine();
        gender = gender.toLowerCase();  // Converting user input to lower case for data consistency
        while ( !gender.equals("") ) {
        	if (gender.equals("male")) {
           		break;
           	}
           	else if (gender.equals("female")) {
           		break;
           	}
           	else {  // If user enters a value other than allowed options.
           		System.out.println("You have entered an invalid gender. Please enter male or female.");
           		System.out.println("What is the dog's gender?");
           		gender = scnr.nextLine();
           		gender = gender.toLowerCase();
           	}
        }
                
        System.out.println("What is the dog's age?");
        String age = scnr.nextLine();
                
        System.out.println("What is the dog's weight?");
        String weight = scnr.nextLine();
                
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scnr.nextLine();
                
        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scnr.nextLine();
        
        // Prompting for training status. Using while loop to validate user input.
        System.out.println("What is the dog's training status?");
        String trainingStatus = scnr.nextLine();
        while ( !trainingStatus.equals("") ) {
        	if (trainingStatus.equalsIgnoreCase("Intake")) {  // Using ignore case so validation is not case-sensitive.
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Phase I")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Phase II")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Phase III")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Phase VI")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Phase V")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("In Service")) {
           		break;
           	}
        	else if (trainingStatus.equalsIgnoreCase("Farm")) {
           		break;
           	}
        	else {  // If user enters a value other than allowed options.
        		System.out.println("You have entered an invalid training status. Only the following are allowed; Intake, Phase II, "
        				+ "Phase III, Phase IV, Phase V, In Service, or Farm.");
        		System.out.println("What is the dog's training status?");
        		trainingStatus = scnr.nextLine();
        	}
        }
               
        // Prompting for reserved status. Using while loop to validate user input.
        System.out.println("Is the dog reserved? Enter: True or False");
        String reserved = scnr.nextLine();
        reserved = reserved.toLowerCase();  // Converting user input to lower case for data consistency
        while ( !reserved.equals("") ) {
        	if (reserved.equals("true")) {
           		break;
           	}
        	else if (reserved.equals("false")) {
           		break;
           	}
        	else {  // If user enters a value other than allowed options.
        		System.out.println("You have entered an invalid reserved status. Please enter true or false.");
           		System.out.println("Is the dog reserved? Enter: true or false");
           		reserved = scnr.nextLine();
           		reserved = reserved.toLowerCase();
        	}
        }
                
        System.out.println("What is the dog's in service country?");
        String inServiceCountry = scnr.nextLine();
        
        // Adding the new dog obtained from user input to the arrayList
        Dog dogNew = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, 
        	reserved, inServiceCountry);
    	dogList.add(dogNew);
        
    	// Display new dog added confirmation message to user.
    	System.out.println("");
    	System.out.println("New dog has been added to the list.");
    	System.out.println("");
    	      
        // Code to print out dog list
    	System.out.println("Current dog list:");
        for(Dog dog: dogList) {
        	System.out.println(dog.getName());
        }
    }

    // Method for intakeNewMonkey. Will first prompt for monkey name, then check if monkey is already in system. If monkey
	  // is in system, user is prompted with message. Otherwise user will be prompted for new monkey intake information.
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("\nWhat is the monkey's name?");
        String name = scanner.nextLine();
        for(Monkey monkey: monkeyList) {
            if(monkey.getName().equalsIgnoreCase(name)) {  // Using IgnoreCase so validate is not case-sensitive
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }

      // This is code to instantiate a new monkey and add it to the appropriate list.
        // Do not need to prompt for monkey name again, name was already obtained at beginning of method.
        // Prompting for gender. Using while loop to validate user input.
        System.out.println("What is the monkey's gender?");
        String gender = scnr.nextLine();  // Obtains input from user
        gender = gender.toLowerCase();  // Converting user input to lower case for data consistency
        while ( !gender.equals("") ) {
          	if (gender.equals("male")) {
           		break;
           	}
           	else if (gender.equals("female")) {
           		break;
           	}
           	else {  // If user enters a value other than allowed options.
           		System.out.println("You have entered an invalid gender. Please enter male or female.");
           		System.out.println("What is the monkey's gender?");
           		gender = scnr.nextLine();
           		gender = gender.toLowerCase();
           	}
        }
            
        System.out.println("What is the monkey's age?");
        String age = scnr.nextLine();
        
        System.out.println("What is the monkey's weight?");
        String weight = scnr.nextLine();
         
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scnr.nextLine();
         
        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scnr.nextLine();
           
        // Prompting for training status. Using while loop to validate user input.
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scnr.nextLine();
        while ( !trainingStatus.equals("") ) {
         	if (trainingStatus.equalsIgnoreCase("Intake")) {
           		break;
           	}
         	else if (trainingStatus.equalsIgnoreCase("Phase I")) {
           		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("Phase II")) {
           		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("Phase III")) {
           		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("Phase VI")) {
           		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("Phase V")) {
          		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("In Service")) {
           		break;
           	}
          	else if (trainingStatus.equalsIgnoreCase("Farm")) {
           		break;
           	}
          	else {  // If user enters a value other than allowed options.
           		System.out.println("You have entered an invalid training status. Only the following are allowed; Intake, Phase II, "
           				+ "Phase III, Phase IV, Phase V, In Service, or Farm.");
           		System.out.println("What is the monkey's training status?");
           		trainingStatus = scnr.nextLine();
           	}
        }
            
        // Prompting for reserved status. Using while loop to validate user input.
        System.out.println("Is the monkey reserved? Enter: true or false");
        String reserved = scnr.nextLine();
        reserved = reserved.toLowerCase();  // Converting user input to lower case for data consistency
        while ( !reserved.equals("") ) {
           	if (reserved.equals("true")) {
           		break;
           	}
           	else if (reserved.equals("false")) {
           		break;
           	}
           	else {  // If user enters a value other than allowed options.
          		System.out.println("You have entered an invalid reserved status. Please enter true or false.");
           		System.out.println("Is the monkey reserved? Enter: true or false");
           		reserved = scnr.nextLine();
           		reserved = reserved.toLowerCase();
          	}
        }
            
        System.out.println("What is the monkey's in service country?");
        String inServiceCountry = scnr.nextLine();
            
        System.out.println("What is the monkey's tail length?");
        String tailLength = scnr.nextLine();
            
        System.out.println("What is the monkey's height?");
        String height = scnr.nextLine();
            
        System.out.println("What is the monkey's body length?");
        String bodyLength = scnr.nextLine();
            
        // Prompting for species. Using while loop to validate user input.
        System.out.println("What is the monkey's species?");
        String species = scnr.nextLine();
        while ( !species.equals("") ) {
           	if (species.equalsIgnoreCase("capuchin")) {
           		break;
           	}
           	else if (species.equalsIgnoreCase("guenon")) {
           		break;
           	}
           	else if (species.equalsIgnoreCase("macaque")) {
           		break;
           	}
           	else if (species.equalsIgnoreCase("marmoset")) {
           		break;
           	}
           	else if (species.equalsIgnoreCase("squirrel monkey")) {
           		break;
           	}
           	else if (species.equalsIgnoreCase("tamarin")) {
           		break;
           	}
           	else {  // If user enters a value other than allowed options.
           		System.out.println("You have entered an invalid species. Only the following are allowed; Capuchin, Guenon, "
           				+ "Macaque, Marmoset, Squirrel Monkey, or Tamarin.");
           		System.out.println("What is the monkey's species?");
           		species = scnr.nextLine();
           	}
        }
            
        // Adding the new monkey obtained from user input to the arrayList
	    Monkey monkeyNew = new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, 
	    reserved, inServiceCountry, tailLength, height, bodyLength, species);
	    monkeyList.add(monkeyNew);
        
	    // Display new monkey added confirmation message to user.
	    System.out.println("");
    	System.out.println("New monkey has been added to the list.");
    	System.out.println("");
	    
        // added code to print out monkeyList - MC
    	// Updated to add print message - PF
    	System.out.println("Current dog list:");
    	for (Monkey monkey: monkeyList) {
    		System.out.println(monkey.getName());
        }
    }

    
    /* Method solution from teacher
     public static void reserveAnimal(Scanner scanner) {
		System.out.println("Which type of animal to reserve? (Dog or Monkey)");
		String animalType = scanner.nextLine();
		System.out.println("For which country will you need the animal?");
		String country = scanner.nextLine();
		boolean animalReserved = false;
		if(animalType.equals("Dog") || animalType.equals("dog")) {
			for(Dog dog: dogList) {
				if(dog.getAcquisitionLocation().equals(country)) {
					dog.setReserved(true);
					animalReserved = true;
				}
			}
		} else if(animalType.equals("Monkey") || animalType.equals("monkey")) {
			for(Monkey monkey: monkeyList) {
				if(monkey.getAcquisitionLocation().equals(country)) {
					monkey.setReserved(true);
					animalReserved = true;
				}
			}
		} else {
			System.out.println("I'm sorry, we don't provide that type of animal");
			return;
		}
		if(animalReserved) {
			System.out.println("The animal has been reserved");
		}else {
			System.out.println("I'm sorry, there is no available " + animalType + " in " + country);
		}
		
	}
    */	
    
    
    // Method to reserve an animal. User will be prompted for animal type, then name and acquisition country.
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("\nTo reserve an animal, the animal must not be reserved and have a training status of \"in service\".");
    	System.out.println("Do you want to reserve a dog or monkey?");
        String animal = scnr.nextLine();
        String animalReserved = "false";  // Creating method variable to pass in the If statements
        String animalTrainingStatus = "in service"; // Creating method variable to pass in the If statements
        
        // Using while loop to validate user's input of animal
        while ( !animal.contentEquals("") ) {
        	// If statement for dog
        	if (animal.equalsIgnoreCase("dog")) {
	        	System.out.println("What is the name of the dog?");
	        	String dogName = scnr.nextLine();
	        	System.out.println("What is the dog's acquisition country?");
	            String dogAcquisitionCountry = scnr.nextLine();
	            for(Dog dog: dogList) {
	            	// Looking for dog that matches user input name and country, but also where reserved=false and trainingStatus=in service.
	            	if ( dogName.equalsIgnoreCase(dog.getName())
	            			&& dogAcquisitionCountry.equalsIgnoreCase(dog.getAcquisitionLocation())
	            			&& animalReserved.equalsIgnoreCase(dog.getReserved())
	            			&& animalTrainingStatus.equalsIgnoreCase(dog.getTrainingStatus()) ) {
	            		System.out.println("This dog is available, the dog's reserved status will be updated.");
	            		dog.setReserved("true"); 
	            	}
	            	else {  // If user enters a value other than allowed options.
	            		System.out.println("Sorry, no dog is available that matches your criteria. An available dog is not reserved and has a "
	            				+ "training status of \"in service\".");
	            		return; //returns to menu
	            	}
	            }
	        }
	        // If statement for monkey
        	else if (animal.equalsIgnoreCase("monkey")) {
	        	System.out.println("What is the name of the monkey?");
	        	String monkeysName = scnr.nextLine();
	        	System.out.println("What is the monkey's acquisition country?");
	            String monkeyAcquisitionCountry = scnr.nextLine();
	            for(Monkey monkey: monkeyList) {
	            	// Looking for monkey that matches user input name and country, but also where reserved=false and trainingStatus=in service.
	            	if ( monkeysName.equalsIgnoreCase(monkey.getName())
	            			&& monkeyAcquisitionCountry.equalsIgnoreCase(monkey.getAcquisitionLocation())
	            			&& animalReserved.equalsIgnoreCase(monkey.getReserved())
	            			&& animalTrainingStatus.equalsIgnoreCase(monkey.getTrainingStatus()) ) {
	            		System.out.println("This monkey is available, the monkey's reserved status will be updated.");
	            		monkey.setReserved("true"); 
	            	}
	            	else {  // If user enters a value other than allowed options.
	            		System.out.println("Sorry, no monkey is available that matches your criteria. An available monkey is not reserved and has a "
	            				+ "training status of \"in service\".");
	            		return; //returns to menu
	            	}
	            }
	        }
	        else {  // If user enters a value other than allowed options.
	        	System.out.println("You have entered an invalid entry. Please enter dog or monkey.");
	        	System.out.println("Do you want to reserve a dog or monkey?");
	        	animal = scnr.nextLine();
	        } 
        } 
    }

    // The printAnimals method will perform action based on user input in menuSelection.
    public static void printAnimals() {
        
    	// If user input from menuSelection was 4 (Print a list of all dogs)
    	  // It will print all dogs and display the following: name, trainingStaus, reserved.
    	if (menuSelection.equals("4")) {
    		System.out.println("\nCurrent dog list:");
            for(Dog dog: dogList) {
            	System.out.print("  Name: " + dog.getName());
            	System.out.print(", Training Status: " + dog.getTrainingStatus());
            	System.out.println(", Reserved: " + dog.getReserved());
            }
        }
    	
        // If user input from menuSelection was 5 (Print a list of all monkeys)
    	  // It will print all dogs and display the following: name, trainingStaus, reserved.
        if (menuSelection.equals("5")) {
    		System.out.println("\nCurrent monkey list:");
            for(Monkey monkey: monkeyList) {
            	System.out.print("  Name: " + monkey.getName());
            	System.out.print(", Training Status: " + monkey.getTrainingStatus());
            	System.out.println(", Reserved: " + monkey.getReserved());
            }
        }
        
        // If user input from menuSelection was 6 (Print a list of all available animals that are not reserved)
        if (menuSelection.equals("6")) {
        	String reserved = "false";  // Variable needed to filter for only available animals
        	String trainingStatus = "in service"; // Variable needed to filter for only in service animals
        	System.out.println("\nThese are all of the available animals with a training status of \"in service\":");
        	for(Dog dog: dogList) {
        		if ( reserved.equalsIgnoreCase(dog.getReserved()) 
        				&& trainingStatus.equalsIgnoreCase(dog.getTrainingStatus()) ) {
        			System.out.print("  Type: Dog, ");
        			System.out.print("Name: " + dog.getName());
        			System.out.println(", Acquisition Country: " + dog.getAcquisitionLocation());
        		}
            }
        	for(Monkey monkey: monkeyList) {
        		if ( reserved.equalsIgnoreCase(monkey.getReserved()) 
        				&& trainingStatus.equalsIgnoreCase(monkey.getTrainingStatus()) ) {
        			System.out.print("  Type: Monkey, ");
        			System.out.print("Name: " + monkey.getName());
        			System.out.println(", Acquisition Country: " + monkey.getAcquisitionLocation());
        		}
            }
        	System.out.println("\nNote: If above list is blank, then zero \"in service\" animals are currently available.");
        }
    }
}
