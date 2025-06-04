package com.example.part2project1;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Rating extends Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private char rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
