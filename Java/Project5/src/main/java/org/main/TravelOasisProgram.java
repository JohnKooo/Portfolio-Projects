package org.main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.main.exceptions.NoObjectFoundException;
import org.main.helperClasses.GuestEdit;
import org.main.helperClasses.SaveWriteToFile;
import org.main.objects.Agent;
import org.main.objects.Guest;
import org.main.objects.Nationality;
import org.main.objects.Trip;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class TravelOasisProgram{
    public static ArrayList<Trip> trips = new ArrayList<>();
    public static ArrayList<LocalDate> startDates = new ArrayList<LocalDate>();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
//        readFile();
        trips = SaveWriteToFile.readFile(trips);
        System.out.println("""
                        Travel Oasis Program
                    """);
        boolean continueProgram = true;
        while (continueProgram){
            try {
                System.out.println("1: Add Trip\n" +
                        "2: Edit a Trip\n" +
                        "3: Display Trips\n" +
                        "4: Show All current Guests signed up\n" +
                        "5: Exit");
                int userChoice = Integer.parseInt(input.nextLine());
                switch (userChoice){
                    case 1:
                        newTrip();
                        break;
                    case 2:
                        editTrip();
                        break;
                    case 3:
                        displayTrips();
                        break;
                    case 4:
                        displayGuests();
                        break;
                    case 5:
                        SaveWriteToFile.saveFile(trips);
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("\nPlease enter an option!\n");
                }
            }catch (NoObjectFoundException e){
                System.out.println("ERROR AT MAIN!: " + e);
            }
        }
    }

    /**
     * Method: newTrip()
     * This method is making a new trip involving the user making them enter the required input
     *
     */
    private static void newTrip() {
        Trip trip = new Trip();
        System.out.println("\nYou are now making a new trip please follow the instructions below\n");
        Agent selectedAgent = agentSelector();
        trip.setAgent(selectedAgent);
        boolean newGuestBool = true;
        while (newGuestBool){

            try {
                System.out.println("Do you want to add a guest?(Y/N)");
                char addNewGuestCheck = input.nextLine().charAt(0);
                switch (addNewGuestCheck) {
                    case 'Y':
                        Guest newGuest = newGuest();
                        trip.addGuest(newGuest);
                        break;
                    case 'N':
                        if (trip.getGuest().size() == 0){
                            System.out.println("You need at least 1 guest!\n");
                            throw new Exception("Please Enter at least 1 guest");
                        }
                        newGuestBool = false;
                        break;
                    default:
                        System.out.println("Please enter Y or N!\n");
                }
            }catch (Exception e){
                System.out.println("Please enter Y or N!\n");
            }
        }

        /*
          below sets start date and an end date.
          Inside the else its setting the start and making an end date 6 days in advance.
         */
        while (true){
            try {
                LocalDate dateNow = LocalDate.now();
                startDates.add(dateNow);
                for (int i = 0; i < startDates.size(); i++) {
                    if (startDates.get(i) == dateNow) {

                    } else {
                        trip.setStartDate(dateNow);
                        trip.setEndDate(LocalDate.now().plusDays(6));
                        break;
                    }
                }
                if (startDates.size() == 1){
                    trip.setStartDate(dateNow);
                    trip.setEndDate(LocalDate.now().plusDays(6));
                }
                break;
            }catch (Exception e){
                System.out.println("ERROR!");
            }
        }

        // code below sets a random trip cost based off how many guests are on the trip
        int guestCount = trip.getGuest().size();
        Random random = new Random();
        int tripCost = random.ints(400,1000).findFirst().getAsInt() * guestCount;
        trip.setCost(tripCost);
        // below adds trip to trips arraylist
        trips.add(trip);
    }

    /**
     * This method is getting the FirstName,LastName ,MealPlan ,Paid ,Nationality , and Guest objects
     * from the user.
     * @return Should return a fully made Guest object
     */
    private static Guest newGuest() {
        boolean mealPlan = true;
        boolean paid = true;
        String firstName = firstLastNameInput("First Name");
        String lastname = firstLastNameInput("Last Name");
        Nationality nationalityInput = nationalityUserInput();
        boolean guestLoop = true;
        while (guestLoop){
            System.out.println("Do you have a meal plan?(T/F):\n");
            char mealPlanInput = input.nextLine().charAt(0);

            switch (mealPlanInput){
                case 'T':
                    mealPlan = true;
                    paid = true;
                    guestLoop = false;
                    return new Guest(firstName,lastname,nationalityInput,mealPlan,paid);
                case 'F':
                    mealPlan = false;
                    paid = false;
                    guestLoop = false;
                    return new Guest(firstName,lastname,nationalityInput,mealPlan,paid);
                default:
                    System.out.println("Please enter T or F!\n");
            }
        }
        return newGuest();
    }

    /**
     * Get string input from the user then loops through
     * the enum values to match what the user entered.
     * @return A Nationality Enum
     */
    private static Nationality nationalityUserInput() {
        System.out.println("""
                    Nationality's:
                USA
                Switzerland
                Australia
                UK
                Italy
                """);
        boolean nationalityBool = true;
        while (nationalityBool){
            System.out.println("\nPlease enter your Nationality (If none below match enter USA):\n");
            String nationInput = input.nextLine();
            for (Nationality nationalityEnum:Nationality.values()){
                if (nationInput.equalsIgnoreCase(nationalityEnum.getNationality())){
                    nationalityBool = false;
                    return nationalityEnum;
                }else {
                    System.out.print(".");
                }
            }
        }
        return null;
    }

    /**
     * Simply asks the user for a name to input.
     * Validates user input so its not empty or includes just spaces.
     * @param firstName
     * @return Either first name or last name
     */
    private static String firstLastNameInput(String firstName) {
        while (true) {
            System.out.println("Enter your " + firstName + "\n");
            try {
                String nameInput = input.nextLine();
                if (nameInput.isBlank()) {
                    throw new Exception();
                }
                System.out.println("Does this look correct?(Y/N)\nYour Input: " + nameInput);
                char userValidation = input.nextLine().charAt(0);
                if (userValidation == 'Y'){
                    return nameInput;
                }
            } catch (Exception e) {
                System.out.println("Please do not leave the input blank!\n");
            }
        }



    }

    /**
     * Asks the user to pick 1 of three agents then returns that agent.
     * @return A Agent object
     */
    private static Agent agentSelector() {
        while (true){
            System.out.println("Please select one of the three agents below:\n");
            System.out.println("""
                    1 : Timmy Sharts
                    2 : Amy Fecely
                    3 : Toby Maguire
                    """);
            try {
                int userChoice = Integer.parseInt(input.nextLine());
                switch (userChoice) {
                    case 1:
                        return new Agent("Timmy", "Sharts", Nationality.USA, "123-123-1234", 80_000);
                    case 2:
                        return new Agent("Amy", "Fecely", Nationality.AUSTRALIA, "234-234-2345", 70_000);
                    case 3:
                        return new Agent("Toby", "Maguire", Nationality.USA, "+1(323) 856-2278", 75_000_000);
                    default:
                        System.out.println("Please select one of the agents!\n");
                }
            }catch (Exception e){
                System.out.println("Enter a value please\n");
            }
        }
    }

    private static void editTrip() {

        System.out.println("""
                    Do you want to remove a trip or edit the guests in a trip
                """);
        boolean tripBoolChecker = true;
        while (tripBoolChecker) {
            System.out.println("""
                    1 : Remove Trip
                    2 : Edit Guests in a trip?
                    3 : Go back to menu
                    """);
            try {
                int userChoice = Integer.parseInt(input.nextLine());
                switch (userChoice) {
                    case 1:
                        removeTrip();
                        break;
                    case 2:
                        editGuestsInTrip();
                        break;
                    case 3:
                        tripBoolChecker = false;
                    default:
                        System.out.println("Please enter an option!\n");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!\n");
            }
        }
    }

    private static void removeTrip() {
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ": " + trips.get(i).toString());
        }
        while (true) {
            if (trips.size() == 0){
                System.out.println("You dont have any trips!\n");
                break;
            }
            try {
                System.out.println("Enter the number of the trip you want to remove:\n");
                int userChoice = Integer.parseInt(input.nextLine());
                if (trips.get(userChoice - 1) == null) {
                    System.out.println("Please select a current trip shown!\n");
                }else {
                    trips.remove(userChoice - 1);
                    break;
                }
            } catch (Exception e) {
                System.out.println("error!");
            }
        }
    }

    /**
     * This method shows all the current trips in the program and asks the user
     * to select one of the trips to edit.
     */
    private static void editGuestsInTrip() {
        for (int i = 0; i < trips.size(); i++) {
            System.out.println((i + 1) + ": " + trips.get(i).toString());
        }
        while (true) {
            if (trips.size() == 0){
                System.out.println("You don't have any trips!\n");
                break;
            }
            try {
                System.out.println("Enter the number of the trip you want to edit:\n");
                int userChoice = Integer.parseInt(input.nextLine());
                if (trips.get(userChoice - 1) == null) {
                    System.out.println("Please select a current trip shown!\n");
                }else {
                    editTheTrip(userChoice - 1);
                    break;
                }
            } catch (Exception e) {
                System.out.println("error!");
            }
        }
    }

    /**
     * This method edits a guest in the trip.
     * it grabs the guest object into a new object for editing and deletes the original Guest from the trip guests
     * arrayList.
     * then it sends the guest object for editing into editing.
     * @param i : i is the selected trip number to then grab the right guest from the right trip.
     */
    private static void editTheTrip(int i) {
        for (int y = 0; y < trips.get(i).getGuest().size(); y++) {
            System.out.println((y + 1) + ": " + trips.get(i).getGuest().get(y).toString());
        }
        while (true) {
            try {
                System.out.println("Enter the number of the guest you want to edit:\n");
                int userChoice = Integer.parseInt(input.nextLine());
                if (trips.get(i).getGuest().get(userChoice - 1) == null) {
                    System.out.println("Please select a current guest shown!\n");
                } else {
                    Guest guest = trips.get(i).getGuest().get(userChoice - 1);
                    trips.get(i).getGuest().remove(userChoice - 1);
                    // code below calls the class GuestEdit to edit the Guest object
                    Guest newGuest = GuestEdit.guestEditor(guest);
                    trips.get(i).getGuest().add(newGuest);
                    break;
                }
            } catch (Exception e) {
                System.out.println("error!");
            }
        }
    }

    private static void displayTrips() {
        ArrayList<Trip> sortedList = trips;
        Collections.sort(sortedList);
        System.out.println("\nYour Current Trips:\n");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(trips.get(i).toString());
        }
    }

    private static void displayGuests(){
        System.out.println("""
                    GUESTS:
                """);
        System.out.println("\nYour Current Guests:\n");
        for (int i = 0; i < trips.size(); i++) {
            for (int j = 0; j < trips.get(i).getGuest().size(); j++) {
                System.out.println(trips.get(i).getGuest().get(j).toString());
            }

        }
    }
}

