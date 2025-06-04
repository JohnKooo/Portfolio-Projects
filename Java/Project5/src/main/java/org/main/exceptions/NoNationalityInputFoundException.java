package org.main.exceptions;

public class NoNationalityInputFoundException extends Exception{
    public NoNationalityInputFoundException(){
        System.out.println("There seems to be no Nationality entered, " +
                "Please rerun the program and check if issue continues");
    }
}
