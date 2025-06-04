package org.main.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.main.exceptions.NoObjectFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Trip implements Comparable{
    @JsonProperty("agent")
    Agent agent;
    @JsonProperty("guest")
    ArrayList<Guest> guest;
    @JsonProperty("cost")
    double cost;
    @JsonProperty("startDate")
    LocalDate startDate;
    @JsonProperty("endDate")
    LocalDate endDate;

    public Agent getAgent() {
        return agent;
    }

    public ArrayList<Guest> getGuest() {
        return guest;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // setters below

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public void setGuest(ArrayList<Guest> guest) {
        this.guest = guest;
    }

    public void addGuest(Guest guest) {
        try {
            this.guest.add(guest);
        }catch (NoObjectFoundException e){
            System.out.println("ERROR!");
        }
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Trip() {
        this.guest = new ArrayList<>();
    }

    public Trip(Agent agent, ArrayList<Guest> guest, double cost, LocalDate startDate, LocalDate endDate) {
        this.agent = agent;
        this.guest = guest;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString(){
        StringBuilder guests = new StringBuilder();
        for (int i = 0; i < guest.size(); i++) {
            String fullNameOfGuest = guest.get(i).firstName + " " + guest.get(i).lastName + ", ";
            guests.append(fullNameOfGuest);

        }
        return "\nAgent: " + this.agent.firstName + " " + this.agent.lastName +
                "\nGuests: " + guests +
                "\nCost: " + this.cost +
                "\nStart Date: " + this.startDate +
                "\nEnd Date: " + this.endDate + "\n";
    }


    @Override
    public int compareTo(Object o) {
        try {
            Trip label = (Trip)o;
            return Double.compare(this.cost, label.cost);
        }catch (Exception e){
            System.out.println("Incorrect object cast");
            return 5;
        }
    }
}
