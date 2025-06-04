import java.sql.SQLException;
import java.util.ArrayList;

public interface GameDAO {
    ArrayList<Rating> getAll();
    void addData(String gameName, String releaseYear, String gameCost, String gameType, String platform, String rating);
    void saveData();
    boolean updateData(String gameName,String newGameName, String column);
    void deleteData(String gameNameD);
    void displayData();
    void deleteDatabase();


}
