package org.main.objects;

import org.main.exceptions.NoNationalityInputFoundException;

public abstract class Person {
    String firstName;
    String lastName;
    Nationality nationality;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationality(Nationality nationality) throws NoNationalityInputFoundException {
        this.nationality = nationality;
        if (this.nationality == null){
            throw new NoNationalityInputFoundException();
        }
    }

    public Person(String firstName, String lastName, Nationality nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    @Override
    public String toString(){
        return "First Name: " + this.firstName +
                "\nLast Name: " + this.lastName +
                "\nNationality: " + this.nationality;
    }
}
