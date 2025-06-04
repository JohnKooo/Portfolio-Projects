package org.main.objects;

public class Guest extends Person{
    boolean mealPlan;
    boolean paid;

    public boolean getMealPlan() {
        return mealPlan;
    }

    public boolean getPaid() {
        return paid;
    }
    // setters below


    public void setMealPlan(boolean mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Guest(){
        super("N/A", "N/A", Nationality.AUSTRALIA);
    }
    public Guest(String firstName, String lastName, Nationality nationality, boolean mealPlan, boolean paid) {
        super(firstName,lastName,nationality);
        this.mealPlan = mealPlan;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMeal Plan: " + this.mealPlan +
                "\nPaid: " + this.mealPlan + "\n";
    }
}
