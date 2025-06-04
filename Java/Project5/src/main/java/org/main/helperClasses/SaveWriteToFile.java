package org.main.helperClasses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.main.objects.Trip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveWriteToFile {
    public static ArrayList<Trip> readFile(ArrayList<Trip> trips){
        try {
            File file = new File("trips.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return trips = objectMapper.readValue(file, new TypeReference<>(){});
        }catch (IOException e ){
            System.out.println("read in file Exception: "+ e);
        }
        return trips;
    }

    public static void saveFile(ArrayList<Trip> trips){
        try {
            FileOutputStream fileOutputStreams = new FileOutputStream("trips.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(fileOutputStreams, trips);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException eo){
            System.out.println("IO exception: " + eo);
        }
    }
}
