package org.example.classes;

import org.example.exception.NoInputFoundException;

public class GasCar extends Car{
    protected double tankSize;
    protected String fuelType;

    public double getTankSize() {
        return tankSize;
    }
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Setter set to not allow anything below 0 Gals.
     * @param tankSize
     */
    public void setTankSize(double tankSize) {
        try {
            if (tankSize <= 0) {
                throw new NoInputFoundException();
            } else {
                this.tankSize = tankSize;
            }
        }catch (NoInputFoundException e){
            System.out.println("Lowest weight allowed is 900Lb");
        }
    }

    /**
     * Setter set to not allow empty string
     * @param fuelType
     */
    public void setFuelType(String fuelType) {
        try {
            if (fuelType.isEmpty()) {
                throw new NoInputFoundException();
            } else {
                this.fuelType = fuelType;
            }
        }catch (NoInputFoundException e){

        }
    }

    /**
     * Default constructor values set to filler values.
     */
    public GasCar() {
        super();
        this.tankSize = 10000;
        this.fuelType = "N/A";
    }


    /**
     * Overloaded Constructor
     * @param make
     * @param model
     * @param color
     * @param year
     * @param weight
     * @param tankSize
     * @param fuelType
     */
    public GasCar(String make, String model, String color, int year, int weight, double tankSize, String fuelType){
        super(make,model,color,year,weight);
        this.tankSize = tankSize;
        this.fuelType = fuelType;
    }

    /**
     * Takes in a pump cost and multiplies it by the tank size.
     * @param pumpCost
     * @return Returns the Pump Cost.
     */
    @Override
    public double CalcCostPerFill(double pumpCost) {
        return this.tankSize * pumpCost;
    }

    /**
     * Overridden GasCar toString to include tank size and fuel type.
     * @return A formatted string.
     */
    @Override
    public String toString() {
        return super.toString() +
                    "\nTank Size: " + this.tankSize +
                    "\nFuel Type: " + this.fuelType;
    }
}
