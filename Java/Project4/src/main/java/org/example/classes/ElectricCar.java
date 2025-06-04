package org.example.classes;

import org.example.exception.NoInputFoundException;

public class ElectricCar extends Car{
    protected double kilowatts;
    protected double efficiency;

    public double getKilowatts() {
        return kilowatts;
    }
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * setter set to not allowing anything below 0.
     * @param kilowatts
     */
    public void setKilowatts(double kilowatts) {
        try {
            if (kilowatts < 0) {
                throw new NoInputFoundException();
            } else {
                this.kilowatts = kilowatts;
            }
        }catch (NoInputFoundException e){
            System.out.println("Cannot Have a negative or a 0!");
        }
    }

    /**
     * setter set to not allowing anything below 0.
     * @param efficiency
     */
    public void setEfficiency(double efficiency) {
        try {
            if (efficiency < 0) {
                throw new NoInputFoundException();
            } else {
                this.efficiency = efficiency;
            }
        }catch (NoInputFoundException e){
            System.out.println("Cannot Have a negative or a 0!");
        }
    }

    /**
     * Default Constructor.
     */
    public ElectricCar(){
        super();
        this.kilowatts = 10000;
        this.efficiency = 10000;
    }

    /**
     * Overloaded Constructor
     * @param make
     * @param model
     * @param color
     * @param year
     * @param weight
     * @param kilowatts
     * @param efficiency
     */
    public ElectricCar(String make, String model, String color, int year, int weight, double kilowatts, double efficiency) {
        super(make, model, color, year, weight);
        this.kilowatts = kilowatts;
        this.efficiency = efficiency;
    }

    /**
     * Overridden toString to represent Electric Car.
     * @return Formatted string.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nKilowatts: " + this.kilowatts +
                "\nEfficiency " + this.efficiency;
    }

    /**
     * Takes in a cost and multiplies it by Kilowatts.
     * @param pumpCost
     * @return Total Refill cost.
     */
    @Override
    public double CalcCostPerFill(double pumpCost) {
        return this.kilowatts * pumpCost;
    }
}
