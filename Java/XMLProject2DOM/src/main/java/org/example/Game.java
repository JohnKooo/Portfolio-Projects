package org.example;

public class Game extends Type{
    private String gameName;
    private int releaseYear;
    private double gameCost;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getGameCost() {
        return gameCost;
    }

    public void setGameCost(double gameCost) {
        this.gameCost = gameCost;
    }

    public Game(String gameName, int releaseYear,double gameCost, String gameType, String platform){
        super(gameType,platform);
        this.gameName = gameName;
        this.releaseYear = releaseYear;
        this.gameCost = gameCost;

    }

    public Game(){
        super();
    }

    public Game(Type type){
        super(type.getGameType(), type.getPlatform());
    }

    @Override
    public String toString() {
        return "\nGame Name: " + this.gameName +
                "\nRelease Year: " + this.releaseYear +
                "\nGame Cost: $" + this.gameCost +
                super.toString();
    }
}
