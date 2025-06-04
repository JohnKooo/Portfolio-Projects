import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MySqlClassDAO implements GameDAO{

    static Connection conn = null;
    public static String password = "1111";
    public static String username = "root";
    public static ArrayList<Rating> games;
    public MySqlClassDAO(String username, String password, String url){
        //code below to connect to database
        boolean databaseConnecting = true;
        while (databaseConnecting) {
            // try connecting to database first
            try {
                url = "jdbc:mysql://localhost:3306/GAMES2_2023";
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Database connection established");
                conn.setAutoCommit(false);
                databaseConnecting = false;
            } catch (Exception e) {
                // create and seed database if it does not exist.
                System.err.println("Cannot connect to database server");
                System.err.println("Trying to create database");
                createDatabase();
                connect();
                createTable();
                seedTable();

            }
        }
    }

    private static void createTable() {
        Statement s;
        try {
            s = conn.createStatement();

            conn.setAutoCommit(false);
            s.executeUpdate("DROP TABLE IF EXISTS games");
            String createStatement = (
                    "CREATE TABLE games ("
                            + "gameName VARCHAR(50),"
                            + "releaseYear INT, "
                            + "gameCost DECIMAL, "
                            + "gameType VARCHAR(20), "
                            + "platform VARCHAR(150),"
                            + "rating CHAR(1)"
                            + ")"
            );
            s.executeUpdate(createStatement + " ENGINE = innoDB");
            conn.commit();
        } catch (SQLException e) {
            System.out.println("SQL error during DROP/CREATE");
            e.printStackTrace();
        }
    }

    private static void seedTable() {
        ParseJson parseJson = new ParseJson("games.json");
        games = parseJson.getGames();
        Statement s;
        try {
            s = conn.createStatement();
            for (Rating g : games) {
                String sql;
                sql = "INSERT INTO games (gameName, releaseYear, gameCost, gameType, platform, rating) VALUES ('" +
                        g.getGameName() + "', " +
                        g.getReleaseYear() + ", '" +
                        g.getGameCost() + "', '" +
                        g.getGameType() + "', '" +
                        g.getPlatform() + "', '" +
                        g.getRating() + "');";
                s.executeUpdate(sql);
            }
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("Error Seeding DB");
            ex.printStackTrace();
        }
    }

    private static void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection made.");
        } catch (Exception e) {
            //serr
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "Drop DATABASE IF EXISTS GAMES2_2023";
            stmt.executeUpdate(sql);
            sql = "CREATE DATABASE GAMES2_2023";
            stmt.executeUpdate(sql);
            System.out.println("Database made.");
        } catch (SQLException e) {
            System.err.println("Cannot create database.");
            System.err.println(e.getMessage());
        }
    }


    private static void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/GAMES2_2023";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void displayData() {
        Statement s;
        try {
            s = conn.createStatement();

            s.execute("SELECT * FROM games");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Rating theGame = new Rating();
                theGame.setGameName(rs.getString("gameName"));
                theGame.setReleaseYear(rs.getInt("releaseYear"));
                theGame.setGameCost(rs.getDouble("gameCost"));
                theGame.setGameType(rs.getString("gameType"));
                theGame.setPlatform(rs.getString("platform"));
                theGame.setRating(rs.getString("rating").charAt(0));
                System.out.println(theGame);
            }

        } catch (SQLException e) {
            System.out.println("SQL error during SELECT");
            System.out.println("If you deleted the Datebase please end the program.");
        }
    }

    @Override
    public ArrayList<Rating> getAll(){
        Statement s;
        ArrayList<Rating> gamesList = new ArrayList<>();
        try {
            s = conn.createStatement();

            s.execute("SELECT * FROM games");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Rating theGame = new Rating();
                theGame.setGameName(rs.getString("gameName"));
                theGame.setReleaseYear(rs.getInt("releaseYear"));
                theGame.setGameCost(rs.getDouble("gameCost"));
                theGame.setGameType(rs.getString("gameType"));
                theGame.setPlatform(rs.getString("platform"));
                theGame.setRating(rs.getString("rating").charAt(0));

                gamesList.add(theGame);

            }
        } catch (SQLException e) {
            System.out.println("SQL error during SELECT");
            e.printStackTrace();
        }
        return gamesList;
    }

    @Override
    public void addData(String gameName, String releaseYear, String gameCost, String gameType, String platform, String rating) {
        Statement s;
        try {
            s = conn.createStatement();

            String sql;
            sql = "INSERT INTO games (gameName, releaseYear, gameCost, gameType, platform, rating) VALUES ('" +
                    gameName + "', " +
                    releaseYear + ", '" +
                    gameCost + "', '" +
                    gameType + "', '" +
                    platform + "', '" +
                    rating + "');";
            s.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error adding Data");
            ex.printStackTrace();
        }
    }

    @Override
    public void saveData(){
        Statement s;
        try {
            s = conn.createStatement();
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateData(String gameName,String newGameName, String column) {
        Statement s;
        try {
            s = conn.createStatement();

            s.execute("SELECT * FROM games");
            ResultSet rs = s.getResultSet();
            boolean foundGame = false;
            while (rs.next()) {
                if (rs.getString("gameName").equals(gameName)){
                    System.out.println("Found Game, updating in process.");
                    foundGame = true;
                }else {
                    System.out.print(".");
                }
            }
            if (!foundGame){
                System.out.println("Cannot find game");
                return true;
            }else {
                s.executeUpdate("UPDATE games SET " + column + " = '" + newGameName + "' WHERE gameName = '" + gameName + "'");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("error updating from Database!");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void deleteData(String gameNameD) {

        Statement s;
        try {
            s = conn.createStatement();

            s.execute("SELECT * FROM games");
            ResultSet rs = s.getResultSet();
            boolean foundGame = false;
            while (rs.next()) {
                if (rs.getString("gameName").equals(gameNameD)){
                    System.out.println("Found Game, Deleting in process.");
                    foundGame = true;
                }else {
                    System.out.print(".");
                }
            }
            if (!foundGame){
                System.out.println("Cannot find game");
            }else {
                s.executeUpdate("DELETE  FROM games WHERE gameName='"+ gameNameD + "'");
            }

        } catch (SQLException e) {
            System.out.println("error deleting from Database!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDatabase(){
        Statement s;
        try {
            s = conn.createStatement();
            s.execute("DROP DATABASE games2_2023");
        } catch (SQLException e) {
            System.out.println("error deleting Database!");
            e.printStackTrace();
        }
    }
}
