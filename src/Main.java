import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File input = new File("./data.json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            // Extracting the basic fields
            String address = fileObject.get("address").getAsString();
            Double houseCost = fileObject.get("cost").getAsDouble();

            System.out.println("Address " + address);
            System.out.println("houseCost " + houseCost);

            // process all pets:
            JsonArray jsonArrayOfPets = fileObject.get("pets").getAsJsonArray();
            List<Pet> pets = new ArrayList<>();
            for (JsonElement petElement : jsonArrayOfPets) {
                JsonObject petJsonObject = petElement.getAsJsonObject();
                String name = petJsonObject.get("name").getAsString();
                String color = null;
                if(petJsonObject.has("color")){
                     color = petJsonObject.get("color").getAsString();
                }


                Pet pet = new Pet(name, color);
                pets.add(pet);
            }

            // Print pets:
            System.out.println("All my pets are: " + pets);


        } catch (FileNotFoundException e) {
            System.err.println("Error file not found ");
            e.printStackTrace();
        }
        catch (Exception e){
            System.err.println("Error processing input file!");
            e.printStackTrace();
        }

    }
}
