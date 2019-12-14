package me.iblitzkriegi.examplebot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ExampleBot {

    public static void main(String[] arg) {
        // Load keys and values from config file in the resources folder
        Object object;
        try {
            // Parse the Config and turn it into a JsonObject
            object = new JSONParser().parse(new FileReader("resources/Config.json"));
        } catch (Exception x) {
            System.out.println("Could not load config file");
            return;
        }
        //Cast the loaded json to simple json's JSONObject
        JSONObject jsonObject = (JSONObject) object;
        // Get the token and prefix from the config file
        String token = (String) jsonObject.get("TOKEN");
        String prefix = (String) jsonObject.get("PREFIX");

    }

}
