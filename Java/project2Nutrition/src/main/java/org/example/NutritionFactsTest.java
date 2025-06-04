package org.example;

public class NutritionFactsTest {
    public static void main(String[] args) {
        Label newFood = new Label();
        System.out.println(newFood.getProductName() + "\n" +
                newFood.getCaloriesPerServing() + "\n" +
                newFood.getServingPerContainer() + "\n" +
                newFood.getSodiumPerServing());

        System.out.println("\n\n");
        Label newerFood = new Label("Good Food", 20, 10, 2);

        System.out.println(newerFood.getProductName() + "\n" +
                newerFood.getCaloriesPerServing() + "\n" +
                newerFood.getServingPerContainer() + "\n" +
                newerFood.getSodiumPerServing());

        System.out.println("Method testing below: \n\n");

        System.out.println("total cals: " + newFood.totalNumCalories());
        System.out.println("Total Sodium: " + newFood.totalNumSodium());

        newFood.setProductName("changed");
        newFood.setSodiumPerServing(0.2);
        newFood.setCaloriesPerServing(2000);
        newFood.setServingPerContainer(2000);

        System.out.println(newFood.getProductName() + "\n" +
                newFood.getCaloriesPerServing() + "\n" +
                newFood.getServingPerContainer() + "\n" +
                newFood.getSodiumPerServing());
    }
}