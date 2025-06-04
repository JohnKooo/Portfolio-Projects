package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NutritionProgram {
    public static ArrayList<Label> labels = new ArrayList<>();
    public static FileOutputStream fileOutputStream;
    public static ObjectMapper objectMapper;
    public static ObjectWriter objectWriter;

    static {
        try {
            objectMapper = new ObjectMapper();
            objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            JsonNode jsonNode = objectMapper.readTree(new File("nutrition.json"));
            for (JsonNode element: jsonNode){
                Label label = objectMapper.treeToValue(element,Label.class);
                labels.add(label);
            }
            fileOutputStream = new FileOutputStream("nutrition.json");
        } catch (IOException e) {
            System.out.println("File Not Found!"+e);
        }
    }

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // W's
        boolean keepGoing = true;
        while (keepGoing){
            int userChoice = 0;
            try {
                System.out.println("\nMake a new product: 1\n" +
                                   "Display products: 2\n" +
                                   "Exit the Program: 3");
                userChoice = Integer.parseInt(input.nextLine());
            }catch (Exception e){
                System.out.println("LOOKS LIKE YOU ENTERED WRONG INPUT!!");
            }
            switch (userChoice){
                case 1:
                    System.out.println("\nYou are now entering a new product!\n");
                    newProduct();
                    break;
                case 2:
                    outputData();
                    break;
                case 3:
                    writeToFile();
                    keepGoing = false;
                    break;
                default:
                    System.out.println("\nEnter a value of 1-3, or not and keep seeing this message.\n");
            }
        }
    }

    private static void writeToFile() {
        try {
            objectWriter.writeValue(fileOutputStream, labels);
        }catch (IOException e){
            System.out.println("Couldn't write to file!");
        }
    }

    private static void newProduct() {
        String productName = labelObjectInput(true,false,false);
        System.out.println("\nEnter the calories per serving: \n");
        int caloriesPerServing = Integer.parseInt(labelObjectInput(false,true,false));
        System.out.println("\nEnter the servings per container: \n");
        int servingPerContainer = Integer.parseInt(labelObjectInput(false,true,false));
        System.out.println("\nEnter the sodium per serving: \n");
        double sodiumPerServing = Double.parseDouble(labelObjectInput(false,false,true));

        Label newProduct = new Label(productName, caloriesPerServing, servingPerContainer, sodiumPerServing);
        labels.add(newProduct);
        System.out.println(newProduct);
    }

    private static void outputData() {
        System.out.println("""
                        Products Placed Below
                -------------------------------------
                """);
        ArrayList<Label> sortedLabels = labels;
        Collections.sort(sortedLabels);
        for(Label lb: sortedLabels){
            System.out.println(lb);
        }
    }
    // method below works by which input is needed then its runs just one
    private static String labelObjectInput(boolean one, boolean two, boolean three) {
        while (one){
            try {
                System.out.println("Enter your product name: ");
                String productName = input.nextLine();

                System.out.println("Does this look right (Y/N)? \n What you entered: " + productName);
                String validating = input.nextLine();
                if (validating.equals("Y")){
                    return productName;
                }else {
                    System.out.println("\n!Rerun!\n");
                }
            }catch (Exception e){
                System.out.println("ERROR!!");
            }
        }

        while (two){
            try {
                System.out.println("Enter the Number Value: ");
                int perServing = Integer.parseInt(input.nextLine());
                if (perServing <= 0){
                    System.out.println("Number cant be below 0 or 0, if anything enter a 1!");
                }else {
                    return String.valueOf(perServing);
                }
            }catch (Exception e){
                System.out.println("Enter a number please!");
            }
        }

        while (three){
            try {
                double perServing = Double.parseDouble(input.nextLine());
                if (perServing <= 0){
                    System.out.println("Number cant be below 0 or 0, if anything enter a 1!");
                }else {
                    return String.valueOf(perServing);
                }
            }catch (Exception e){
                System.out.println("Enter a number please!");
            }
        }
        return "ERROR!";
    }
}
