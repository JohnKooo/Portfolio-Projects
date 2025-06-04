package org.main.helperClasses;

import org.main.objects.Guest;
import org.main.objects.Nationality;

import java.util.Scanner;

public class GuestEdit {
    public static Scanner input = new Scanner(System.in);
    public static Guest guestEditor(Guest guest){
        System.out.println("Editing guest!");
        boolean editGuestBool = true;
        while (editGuestBool) {
            try {
                System.out.println("""
                            Options
                        1 : Change First Name
                        2 : Change Last Name
                        3 : Change Nationality
                        4 : Go back to menu
                        """);
                int userChoice = Integer.parseInt(input.nextLine());
                switch (userChoice) {
                    case 1:
                        String first = firstLastNameInputEdit("First Name");
                        guest.setFirstName(first);
                        break;
                    case 2:
                        String last = firstLastNameInputEdit("Last Name");
                        guest.setLastName(last);
                        break;
                    case 3:
                        Nationality nat = nationalityUserInputEdit();
                        guest.setNationality(nat);
                        break;
                    case 4:
                        editGuestBool = false;
                        break;
                    default:
                        System.out.println("Enter one of the options");
                }
            } catch (Exception e) {
                System.out.println("Enter the right value");
            }
        }
        return guest;
    }

    /**
     * This methods allows for changing the nationality of the guess your editing.
     * @return a new nationality for the guest your editing
     */
    private static Nationality nationalityUserInputEdit() {
        System.out.println("""
                    Nationality's:
                USA
                Switzerland
                Australia
                UK
                Italy
                """);
        boolean nationalityBool = true;
        while (nationalityBool) {
            System.out.println("\nPlease enter the Nationality you want to select now\n");
            String nationInput = input.nextLine();
            for (Nationality nationalityEnum : Nationality.values()) {
                if (nationInput.equalsIgnoreCase(nationalityEnum.getNationality())) {
                    nationalityBool = false;
                    return nationalityEnum;
                } else {
                    System.out.print(".");
                }
            }
        }
        return null;
    }

    /**
     * Simply asks the user for a name to input.
     * Validates user input so its not empty or includes just spaces.
     *
     * @param firstName
     * @return Either first name or last name
     */
    private static String firstLastNameInputEdit(String firstName) {
        while (true) {
            System.out.println("Enter your " + firstName + "\n");
            try {
                String nameInput = input.nextLine();
                if (nameInput.isBlank()) {
                    throw new Exception();
                }
                System.out.println("Does this look correct?(Y/N)\nYour Input: " + nameInput);
                char userValidation = input.nextLine().charAt(0);
                if (userValidation == 'Y') {
                    return nameInput;
                }
            } catch (Exception e) {
                System.out.println("Please do not leave the input blank!\n");
            }
        }
    }
}
