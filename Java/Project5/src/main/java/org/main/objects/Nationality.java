package org.main.objects;

public enum Nationality {
    USA("usa"),
    SWITZERLAND("switzerland"),
    AUSTRALIA("australia"),
    UK("uk"),
    ITALY("italy");

    Nationality(String nationality){
        this.nationality = nationality;
    }

    private String nationality;

    public String getNationality(){
        return nationality;
    }
}
