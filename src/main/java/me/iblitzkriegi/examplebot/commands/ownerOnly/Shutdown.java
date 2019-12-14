package me.iblitzkriegi.examplebot.commands.ownerOnly;

import me.iblitzkriegi.jdacommands.annotations.CommandInfo;
import me.iblitzkriegi.jdacommands.annotations.executionRules.OwnerOnly;
import me.iblitzkriegi.jdacommands.utilities.Command;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandEvent;

@CommandInfo(
        name = "shutdown",
        desc = "Stop the bot. This is owner only.",
        usage = "shutdown",
        aliases = {"stop", "end"}
)
@OwnerOnly
public class Shutdown extends Command {

    @Override
    public void execute(CommandEvent commandEvent, String[] strings) {
        commandEvent.reply("Oh no.. Alright. I'll be heading out now then.. Bye! :wave:");
        commandEvent.getJDA().shutdownNow();
    }
}
