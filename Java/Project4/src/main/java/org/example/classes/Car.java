package org.example.classes;

import org.example.exception.NoInputFoundException;

public abstract class Car {
    protected String make;
    protected String model;
    protected int year;
    protected String color;
    protected int weight;

    public String getMake() {
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public String getColor(){
        return color;
    }
    public int getWeight(){
        return weight;
    }

    /**
     * Setter set to not allow empty string
     * @param make
     */
    public void setMake(String make) {
        try {
            if (make.isEmpty()) {
                throw new NoInputFoundException();
            } else {
                this.make = make;
            }
        }catch (NoInputFoundException e){

        }
    }

    /**
     * Setter set to not allow empty string
     * @param model
     */
    public void setModel(String model){
        try {
            if (model.isEmpty()) {
                throw new NoInputFoundException();
            } else {
                this.model = model;
            }
        }catch (NoInputFoundException e){

        }
    }

    /**
     * setter set to not allowing anything below 1886.
     * @param year
     */
    public void setYear(int year){
        try {
            if (year < 1886) {
                throw new NoInputFoundException();
            } else {
                this.make = make;
            }
        }catch (NoInputFoundException e){
            System.out.println("Lowest year allowed is 1886");
        }
    }

    /**
     * Setter set to not allow empty string
     * @param color
     */
    public void setColor(String color){
        try {
            if (color.isEmpty()) {
                throw new NoInputFoundException();
            } else {
                this.color = color;
            }
        }catch (NoInputFoundException e){

        }
    }

    /**
     * Setter set to not allow anything below 900Lbs.
     * @param weight
     */
    public void setWeight(int weight){
        try {
            if (weight < 900) {
                throw new NoInputFoundException();
            } else {
                this.weight = weight;
            }
        }catch (NoInputFoundException e){
            System.out.println("Lowest weight allowed is 900Lb");
        }
    }

    /**
     * Default constructor values set to filler values
     */
    public Car(){
        this.make = "N/A";
        this.model = "N/A";
        this.color = "N/A";
        this.year = 10000;
        this.weight = 10000;
    }

    /**
     * Overloaded constructor
     * @param make
     * @param model
     * @param color
     * @param year
     * @param weight
     */
    public Car(String make, String model, String color, int year, int weight){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.weight = weight;
    }

    /**
     * Abstract class used to return cost per fill
     * @param pumpCost
     * @return pumpCost
     */
    public abstract double CalcCostPerFill(double pumpCost);

    /**
     * An overridden toString to be used when printing an object
     * @return Returns a readable string for the object
     */
    @Override
    public String toString(){
        return "Make: " + this.make +
               "\nModel: " + this.model +
                "\nColor: " + this.color +
                "\nYear: " + this.year +
                "\nWeight: " + this.weight;
    }
}
