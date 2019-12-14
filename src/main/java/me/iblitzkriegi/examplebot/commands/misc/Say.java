package me.iblitzkriegi.examplebot.commands.misc;

import me.iblitzkriegi.jdacommands.annotations.CommandInfo;
import me.iblitzkriegi.jdacommands.annotations.permissions.RequiredPermissions;
import me.iblitzkriegi.jdacommands.utilities.Command;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandEvent;
import net.dv8tion.jda.api.Permission;

@CommandInfo(
        name = "say",
        desc = "Make the bot respond with whatever you say",
        usage = "say <message>",
        aliases = "repeat"
)
@RequiredPermissions({Permission.ADMINISTRATOR})
public class Say extends Command {
    @Override
    public void execute(CommandEvent commandEvent, String[] strings) {

    }
}
