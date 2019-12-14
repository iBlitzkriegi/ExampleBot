package me.iblitzkriegi.examplebot;

import me.iblitzkriegi.jdacommands.utilities.CommandClientBuilder;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandClient;
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

        //Create a ClientBuilder to start building our bot
        CommandClientBuilder clientBuilder = new CommandClientBuilder();

        //Set the token for our bot
        clientBuilder.setToken(token);

        //Set the prefix the bot will use, this isn't mandatory
        clientBuilder.setPrefix(prefix);

        //Use the default game. It shows: Playing: use <prefix>help
        clientBuilder.useDefaultGame();

        //Use JDA-CommandBuilder's already created help command
        clientBuilder.useDefaultHelpCommand();

        //Define myself as an owner. Make sure you use the L at the end to make it a long.
        clientBuilder.setOwnerIds(98208218022428672L);

        /*
        Set the logging level for them bot. The options can be seen with CommandClientBuilder#LogLevel.
        I used INFO so I'll only see relevant information.
         */
        clientBuilder.setLoggingLevel(CommandClientBuilder.LogLevel.INFO);

        //Now build the CommandClientBuilder into a CommandClient
        CommandClient client = clientBuilder.build(ExampleBot.class);

    }

}
