package me.iblitzkriegi.examplebot.commands.misc;

import me.iblitzkriegi.jdacommands.annotations.CommandInfo;
import me.iblitzkriegi.jdacommands.annotations.permissions.RequiredChannelPermissions;
import me.iblitzkriegi.jdacommands.utilities.Command;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandEvent;
import net.dv8tion.jda.api.Permission;

@CommandInfo(
        name = "purge",
        desc = "Purge a specified number of messages in a channel",
        usage = "purge <numberOfMessages>"
)
@RequiredChannelPermissions({Permission.MESSAGE_MANAGE})
public class Purge extends Command {
    @Override
    public void execute(CommandEvent commandEvent, String[] strings) {
        
    }

    boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (Exception x) {
            return false;
        }
        return true;
    }

}
