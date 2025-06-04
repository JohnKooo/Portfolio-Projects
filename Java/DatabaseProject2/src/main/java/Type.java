public class Type {
    private String gameType;
    private String platform;

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Type(){

    }

    public Type(String gameType, String platform){
        this.gameType = gameType;
        this.platform = platform;

    }

    @Override
    public String toString() {
        return "\nGame Type: " + this.gameType +
                "\nPlatform: " + this.platform;
    }
}
