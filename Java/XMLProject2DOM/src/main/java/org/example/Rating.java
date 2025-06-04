package org.example;

public class Rating extends Game{
    private char rating;

    public char getRating() {
        return rating;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }

    public Rating(){
        super();
    }

    public Rating(Game game, char rating){
        super(game);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRating: " + this.rating;
    }
}
