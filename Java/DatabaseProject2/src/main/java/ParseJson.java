import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public ArrayList<Rating> games;

    public  ArrayList<Rating> getGames(){ return games;}

    public ParseJson(String fileName){
        games = new ArrayList<>();
        //create a Gson object
        Gson gson = new Gson();

        //Define the type of list we want to parse
        java.lang.reflect.Type listType = new TypeToken<List<Rating>>() {}.getType();
        FileReader file = null;
        try {
            file = new FileReader("games.json");
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        games = gson.fromJson(file, listType);
    }
}
