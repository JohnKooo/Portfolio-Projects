package org.main.objects;

public class Agent extends Person {
    String phoneNumber;
    double salary;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    // setters below

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Agent(){
        super("N/A", "N/A", Nationality.USA);
    }
    public Agent(String firstName, String lastName, Nationality nationality, String phoneNumber, double salary) {
        super(firstName, lastName, nationality);
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }


    public void yearlyBonus(){

    }
}
