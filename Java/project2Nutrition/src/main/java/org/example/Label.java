package org.example;

import java.text.Format;

//import static sun.util.locale.LocaleUtils.isEmpty;


public class Label implements Comparable{
    private String productName;
    private int caloriesPerServing;
    private int servingPerContainer;
    private double sodiumPerServing;

    public String getProductName() {
        return productName;
    }

    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public int getServingPerContainer() {
        return servingPerContainer;
    }

    public double getSodiumPerServing() {
        return sodiumPerServing;
    }

    public void setProductName(String productName) {
        if (productName.isEmpty()) {
            this.productName = "Null";
            System.out.println("Error! Null Value Entered.");
        }else {
            this.productName = productName;
        }

    }

    public void setCaloriesPerServing(int caloriesPerServing) {
        if (caloriesPerServing <= 0){
            this.caloriesPerServing = 0;
            System.out.println("Value is incorrect! cant be a 0 or negative");
        }else {
            this.caloriesPerServing = caloriesPerServing;
        }

    }

    public void setServingPerContainer(int servingPerContainer) {
        if (servingPerContainer <= 0){
            this.servingPerContainer = 0;
            System.out.println("Value is incorrect! cant be a 0 or negative");
        }else {
            this.servingPerContainer = servingPerContainer;
        }
    }

    public void setSodiumPerServing(double sodiumPerServing) {
        if (sodiumPerServing < 0){
            this.sodiumPerServing = 0;
            System.out.println("Value is incorrect! cant be a 0 or negative");
        }else {
            this.sodiumPerServing = sodiumPerServing;
        }
    }

    public Label(){
        setProductName("Nurds");
        setCaloriesPerServing(60);
        setServingPerContainer(9);
        setSodiumPerServing(0);
    }

    public Label(String productName, int caloriesPerServing, int servingPerContainer, double sodiumPerServing){
        setProductName(productName);
        setCaloriesPerServing(caloriesPerServing);
        setServingPerContainer(servingPerContainer);
        setSodiumPerServing(sodiumPerServing);
    }

    public int totalNumCalories(){
        return (getServingPerContainer() * getCaloriesPerServing());
    }

    public double totalNumSodium(){
        return (getServingPerContainer() * getSodiumPerServing());
    }

    @Override
    public String toString(){
        String moreThanDaily = "";
        // code below to figure out if over or below daily limit
        if (totalNumCalories() > 2000){
            moreThanDaily = "This Would be more than the daily limit!\n";
        }else {
            moreThanDaily = "This Would be less than the daily limit!\n";
        }

        return "-------------------------------------------------\n" +
                "\tProduct: " + getProductName() + "\n" +
                "\n1 Serving Of: " + getProductName() + "\n" +
                "Calories: " + getCaloriesPerServing() + "\n"+
                "Sodium: " + getSodiumPerServing() + "\n" +
                "\n\nServing of Whole Container: \n" +
                "Calories: " + totalNumCalories() + "\n" +
                "Sodium: " + totalNumSodium() + "\n" +
                moreThanDaily + "\n";
    }

    @Override
    public int compareTo(Object o) {
        try {
            Label label = (Label)o;
            return Integer.compare(this.totalNumCalories(), label.totalNumCalories());
        }catch (Exception e){
            System.out.println("Incorrect object cast");
            return 5;
        }
    }
}
