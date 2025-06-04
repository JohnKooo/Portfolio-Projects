package Longaberger;
import java.util.Scanner;

// Program: Takes customer order.
// Name: John 
// Date: 07/11/2023
public class LongaBergerProgram {
    static final Scanner input = new Scanner(System.in);
    static int orderCounter = 0;

    public static void main(String[] args) {
        // gets info about it being standard or custom
        // Objects defined below
        BasketBuild personJoe = new BasketBuild();

        // this switch determines whether to let the user make inputs or use the default constructor inputs.
        while (true) {
            char order_type = orderType();

            try {
                switch (order_type) {
                    case 'C':
                        customOrderMethod(personJoe);
                        break;
                    case 'S':
                        personJoe.calculations();
                        System.out.println(personJoe);
                        break;
                }
            }catch (Exception e){

            }
        }
    }
    public static void customOrderMethod(BasketBuild personJoe){
        char basket_type = basketType();
        String accessory_type = accessoryType();
        String state = stateInput();
        int customer_type = customerType();

        personJoe.setBasket_type(basket_type);
        personJoe.setAccessory_type(accessory_type);
        personJoe.setState(state);
        personJoe.setCustomer_type(customer_type);

        personJoe.calculations();
        System.out.println(personJoe);
    }

    private static char orderType(){
        while (true) {
            if (orderCounter >= 1){
                System.out.println("\nIf you have another order, Please continue (Enter N when done):");
            }
            System.out.println("\nWould you like the (S)tandard order or the (C)ustom order?: ");
            char order_type = input.nextLine().charAt(0);
            switch (order_type) {
                case 'S', 'C':
                    orderCounter++;
                    return order_type;
                case 'N':
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Wrong input, try again.");
            }
        }
    }

    private static char basketType() {
        while (true) {
            char[] basketTypes = {'C','W','K','M','U'};
            System.out.println("Enter a basket type, basket types include:");
            System.out.println("""
                    C = Cracker
                    W = Wildflower
                    K = Key
                    M = Magazine
                    U = Umbrella
                    Note: Enter the Single Letter, not the word!!
                    """);
            char basket_type = input.nextLine().charAt(0);
            for (int i = 0; i < basketTypes.length; i++){
                if (basket_type == basketTypes[i]){
                    return basket_type;
                }else {
                    System.out.print(".");
                }
            }
        }
    }

    private static String accessoryType() {
        while (true) {
            String[] accessoryTypes = {"A1","A2","A3","A4"};
            System.out.println("Enter a accessory type, accessory types include:");
            System.out.println("""
                    A1 = Protector
                    A2 = Liner
                    A3 = Combo
                    A4 = None
                    Note: Enter the 2 digit code, not the name!!
                    """);
            String accessory_type = input.nextLine();
            for (int i = 0; i < accessoryTypes.length; i++){
                if (accessory_type.equals(accessoryTypes[i])){
                    return accessory_type;
                }else {
                    System.out.print(".");
                }
            }
        }
    }

    private static String stateInput() {
        while (true) {
            System.out.println("Enter your state:");
            System.out.println("""
                    IA = Iowa
                    IL = Illinois
                    MO = Missouri
                    Note: Enter the abbreviation, not the actual not!!
                    """);
            String state_input = input.nextLine();
            if (state_input.equals("IA") || state_input.equals("IL") || state_input.equals("MO")) {
                System.out.println("Thanks");
                return state_input;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    private static int customerType() {
        while (true) {
            System.out.println("Enter your customer type, customer types include:");
            System.out.println("""
                    1 = Dealer
                    2 = Walk In
                    3 = Bus
                    Note: Enter the digit, not the name!!
                    """);
            int customer_type = 0;
            try {
                customer_type = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Have to enter a digit.");
            }

            if (customer_type == 1 || customer_type == 2 || customer_type == 3) {
                System.out.println("Thanks!");
                return customer_type;
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
