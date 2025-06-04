package org.example.exception;

public class NoInputFoundException extends Exception {
    public NoInputFoundException(){
        System.out.println("Please enter the correct input required!");
    }
    public void WrongInput(){
        System.out.println("error");
    }
}
