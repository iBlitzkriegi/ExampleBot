package me.iblitzkriegi.examplebot.commands.misc;

import me.iblitzkriegi.jdacommands.annotations.CommandInfo;
import me.iblitzkriegi.jdacommands.utilities.Command;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandEvent;

@CommandInfo(
        name = "say",
        desc = "Make the bot respond with whatever you say",
        usage = "say <message>",
        aliases = "repeat"
)
public class Say extends Command {
    @Override
    public void execute(CommandEvent commandEvent, String[] strings) {
        
    }
}
