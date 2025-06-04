package org.example;

import org.example.classes.ElectricCar;
import org.example.classes.GasCar;
import org.example.exception.NoInputFoundException;

import java.util.Scanner;

public class CarApplication {
    public static Scanner input = new Scanner(System.in);

    /**
     * Main Method: Asks user if they want to input a gas or electric car.
     * Then will print the car out for the user.
     * @param args
     */
    public static void main(String[] args) {
        while (true){
            System.out.println("Please enter a car of your choice");
            System.out.println("Gas (G) or Electric (E)");
            char userInput = input.nextLine().charAt(0);
            switch (userInput){
                case 'G','g':
                    GasCarChoice();
                    break;
                case 'E','e':
                    ElectricCarChoice();
                    break;
                default:
                    System.out.println("Please enter a G or E!");
            }
        }
    }

    /**
     * Calls other methods required to make an Electric Car.
     * At the end it will print your car.
     */
    private static void GasCarChoice() {
        String make = MakeModelColorInput("Make");
        String model = MakeModelColorInput("Model");
        String color = MakeModelColorInput("Color");
        int year = yearInput();
        int weight = weightInput();
        GasCar car = gasCarInput(make,model,color,year,weight);
        System.out.println(car);
    }

    /**
     * Calls other methods required to make an Electric Car.
     * At the end it will print your car.
     */
    private static void ElectricCarChoice() {
        String make = MakeModelColorInput("Make");
        String model = MakeModelColorInput("Model");
        String color = MakeModelColorInput("Color");
        int year = yearInput();
        int weight = weightInput();
        ElectricCar car = electricCarInput(make,model,color,year,weight);
        System.out.println(car);
    }

    /**
     * This method is taking in the parameters and asking user
     * for kilowatts and efficiency.
     * then it will make an object and return the object.
     * @param make
     * @param model
     * @param color
     * @param year
     * @param weight
     * @return
     */
    private static ElectricCar electricCarInput(String make, String model, String color, int year, int weight) {
        double kilowatts = 0;
        double efficiency = 0;
        double kilowattCost = 0;

        while (true){
            System.out.println("Enter the kilowatts: ");
            kilowatts = Double.parseDouble(input.nextLine());
            if (kilowatts <= 0) {
                System.out.println("Year can't be below 0 kilowatts");
            }else {
                break;
            }
        }

        while (true) {
            System.out.println("Please enter your efficiency (kWh/mile): ");
            efficiency = Double.parseDouble(input.nextLine());
            if (efficiency <= 0) {
                System.out.println("Year can't be below 0");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Please enter the kilowatt price: ");
            kilowattCost = Double.parseDouble(input.nextLine());
            if (kilowattCost <= 0) {
                System.out.println("can't be below 0");
            } else {
                break;
            }
        }
        ElectricCar electricCar = new ElectricCar(make,model,color,year,weight,kilowatts,efficiency);
        System.out.println("Cost per full charge: " + electricCar.CalcCostPerFill(kilowattCost)+"$");
        return electricCar;
    }

    /**
     * Method is used to take User Input from the user.
     * choice is used to decide what the user needs to enter.
     * @param choice
     * @return A Make, Model, or color.
     */
    private static String MakeModelColorInput(String choice) {
        while (true) {
            System.out.println("Please enter your " + choice);
            String makeModel = input.nextLine();
            if (makeModel.isEmpty()) {
                System.out.println("String cant be empty");
            } else {
                return makeModel;
            }
        }
    }

    /**
     * Getting input from user for the year.
     * Validates for year, anything below 1886 is not excepted.
     * @return A Year input from user.
     */
    private static int yearInput() {
        while (true) {
            System.out.println("Enter the year: ");
            int year = Integer.parseInt(input.nextLine());
            if (year < 1886) {
                System.out.println("Year can't be below 1886");
            }else {
                return year;
            }
        }
    }

    /**
     * Getting input from user for weight.
     * Validates for weight, anything below 900 is not excepted.
     * @return A Weight input from user
     */
    private static int weightInput() {
        while (true) {
            System.out.println("Enter the Weight(Lbs): ");
            int weight = Integer.parseInt(input.nextLine());
            if (weight < 900) {
                System.out.println("Year can't be below 900Lbs");
            }else {
                return weight;
            }
        }
    }

    /**
     * This method is taking in the parameters and asking user
     * for tank size and fuel type.
     * then it will make an object and return the object.
     * @param make
     * @param model
     * @param color
     * @param year
     * @param weight
     * @return A GasCar Object.
     */
    private static GasCar gasCarInput(String make, String model,String color, int year, int weight) {
        double tankSize = 0;
        String fuelType = "";
        double gasCost = 0;
        while (true){
            System.out.println("Enter the Tank size(Gals): ");
            tankSize = Double.parseDouble(input.nextLine());
            if (tankSize <= 0) {
                System.out.println("Year can't be below 0 Gals");
            }else {
                break;
            }
        }

        while (true) {
            System.out.println("Please enter your fuel type: ");
            fuelType = input.nextLine();
            if (fuelType.isEmpty()) {
                System.out.println("String cant be empty");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Please enter the gas price (Per Gal): ");
            gasCost = Double.parseDouble(input.nextLine());
            if (gasCost <= 0) {
                System.out.println("can't be below 0");
            } else {
                break;
            }
        }
        GasCar gasCar = new GasCar(make,model,color,year,weight,tankSize,fuelType);
        System.out.println("Cost per fill up: " + gasCar.CalcCostPerFill(gasCost) + "$");
        return gasCar;
    }
}
