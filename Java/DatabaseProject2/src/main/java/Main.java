import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static String password = "1111";
    public static String username = "root";
    public static String url = "jdbc:mysql://localhost:3306/";

    //TODO connect to data base using the constructor in MYSQlClassDAO();
    public static GameDAO gameDAO = new MySqlClassDAO(username,password,url);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("""
                        Games Database
                        
                    Please enter one option:
                    1. Display
                    2. Add Data
                    3. Update Data
                    4. Delete Data
                    5. Remove Database
                    6. Save(DONT FORGET TO SAVE IF CHANGES HAVE BEEN MADE!)
                    7. End Program
                    """);

            try {
                int userInput = Integer.parseInt(input.nextLine());

                switch (userInput){
                    case 1:
                        display();
                        break;
                    case 2:
                        addData();
                        break;
                    case 3:
                        updateData();
                        break;
                    case 4:
                        deleteData();
                        break;
                    case 5:
                        removeDatabase();
                        break;
                    case 6:
                        gameDAO.saveData();
                        break;
                    case 7:
                        endProgram();
                        break;
                }
            }catch (Exception e){
                System.out.println("Please enter a valid option.");
            }

        }
    }

    private static void display() {
        gameDAO.displayData();
    }

    private static void addData() {
        System.out.println("You are now adding data for a new game!");
        String gameName = userInputHelper(1,"Enter your games name: ");
        String releaseYear = userInputHelper(2,"Enter your games release year: ");
        String gameCost = userInputHelper(3,"Enter your games cost: ");
        String gameType = userInputHelper(1,"Enter your games type: ");
        String platform = userInputHelper(1,"Enter your games platform: ");
        String rating = userInputHelper(4,"Enter your games rating: ");
        gameDAO.addData(gameName,releaseYear,gameCost,gameType,platform,rating);

    }

    private static void updateData() {
        gameDAO.displayData();
        String gameNameInput = "";
        String newValueInput = "";
        String columnChoice = "";

        boolean mainWhileSwitch = true;
        while (mainWhileSwitch) {
            while (true) {
                System.out.println("Enter the games name you want to update: ");
                gameNameInput = input.nextLine();
                break;
            }

            boolean goOn = true;
            while (goOn) {
                try {


                    System.out.println("Enter which data you want to update");
                    System.out.println("""
                            1. Game Name
                            2. Release Year
                            3. Game Cost
                            4. Game Type
                            5. Platform
                            6. Rating
                            """);
                    int columnInput = Integer.parseInt(input.nextLine());
                    switch (columnInput) {
                        case 1:
                            columnChoice = "gameName";
                            goOn = false;
                            break;
                        case 2:
                            columnChoice = "releaseYear";
                            goOn = false;

                            break;
                        case 3:
                            columnChoice = "gameCost";
                            goOn = false;

                            break;
                        case 4:
                            columnChoice = "gameType";
                            goOn = false;

                            break;
                        case 5:
                            columnChoice = "platform";
                            goOn = false;

                            break;
                        case 6:
                            columnChoice = "rating";
                            goOn = false;

                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Not an option, try again!");
                }
            }
            while (true) {
                System.out.println("Enter the new value: ");
                newValueInput = input.nextLine();
                break;
            }
            mainWhileSwitch = gameDAO.updateData(gameNameInput,newValueInput,columnChoice);
        }
    }

    private static void deleteData() {
        while (true) {
            display();
            try {
                String userInput = userInputHelper(1,"Enter the games name you want to delete: ");
                gameDAO.deleteData(userInput);
                break;
            }catch (Exception e){
                System.out.println("Please make sure the games name exactly how you see it!!");
            }

        }
    }

    private static void removeDatabase() {
        gameDAO.deleteDatabase();
    }

    private static void endProgram() {
        System.exit(0);
    }

    private static String userInputHelper(int inputDecider, String textPrint){
        // string input
        if (inputDecider == 1){
            while (true){
                try {
                    System.out.println(textPrint);
                    return input.nextLine();
                }catch (Exception e){
                    System.out.println("ERROR!");
                }
            }
        }
        // int input
        if (inputDecider == 2){
            while (true){
                try {
                    System.out.println(textPrint);
                    int userinput = Integer.parseInt(input.nextLine());
                    return String.valueOf(userinput);
                }catch (Exception e){
                    System.out.println("ERROR!");
                }
            }
        }
        // double input
        if (inputDecider == 3){
            while (true){
                try {
                    System.out.println(textPrint);
                    double userinput = Double.parseDouble(input.nextLine());
                    return String.valueOf(userinput);
                }catch (Exception e){
                    System.out.println("ERROR!");
                }
            }
        }
        // char input
        if (inputDecider == 4){
            while (true){
                try {
                    System.out.println(textPrint);
                    char userInput = input.nextLine().charAt(0);
                    return String.valueOf(userInput);
                }catch (Exception e){
                    System.out.println("ERROR!");
                }
            }
        }
        return null;
    }
}
