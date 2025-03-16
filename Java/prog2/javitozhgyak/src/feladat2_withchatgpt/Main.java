package feladat2_withchatgpt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into a wrapper object
            EtelWrapper etelWrapper = objectMapper.readValue(new File("json_input.json"), EtelWrapper.class);

            // Extract the list of Etel objects
            List<Etel> etelList = etelWrapper.getAdatok();

            // Print the list of objects
            for (Etel etel : etelList) {
                System.out.println(etel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
