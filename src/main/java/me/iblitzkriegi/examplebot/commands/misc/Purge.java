package me.iblitzkriegi.examplebot.commands.misc;

import me.iblitzkriegi.jdacommands.annotations.CommandInfo;
import me.iblitzkriegi.jdacommands.annotations.permissions.RequiredChannelPermissions;
import me.iblitzkriegi.jdacommands.utilities.Command;
import me.iblitzkriegi.jdacommands.utilities.wrappers.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.exceptions.PermissionException;

import java.util.List;
import java.util.stream.Collectors;

@CommandInfo(
        name = "purge",
        desc = "Purge a specified number of messages in a channel",
        usage = "purge <numberOfMessages>"
)
@RequiredChannelPermissions({Permission.MESSAGE_MANAGE})
public class Purge extends Command {
    @Override
    public void execute(CommandEvent commandEvent, String[] arguments) {
        if (arguments.length == 0) {
            commandEvent.reply("You must input a number of messages!");
            return;
        } else if (!isNumeric(arguments[0])) {
            commandEvent.reply("The input was not a valid integer!");
            return;
        }

        int numOfMessages = Integer.parseInt(arguments[0]);
        List<Message> messages = commandEvent.getChannel().getIterableHistory().stream()
                .limit(numOfMessages)
                .collect(Collectors.toList());

        try {
            for (int i = 0; i < messages.size(); i += 100) {
                List<Message> l = messages.subList(i, Math.min(messages.size(), i + 100));
                if (l.size() == 1) {
                    l.get(0).delete().queue();
                } else {
                    if (commandEvent.isFromGuild()) {
                        commandEvent.getTextChannel().deleteMessages(l).queue();
                    }
                }
            }
            commandEvent.reply("Successfully purged `" + numOfMessages + "` messages.");
        } catch (PermissionException x) {
            commandEvent.reply("The bot is missing the " + x.getPermission().getName() + " permission to purge messages.");
            return;
        }
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
