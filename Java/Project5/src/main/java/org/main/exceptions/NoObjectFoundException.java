package org.main.exceptions;

public class NoObjectFoundException extends NullPointerException{
    NoObjectFoundException(){
        System.out.println("Arraylist has not been instantiated");
    }
}
