package commandManager.commands.statuses;

import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand extends CommandConfig {


    public UnknownCommand() {
        super(MessageText.ERROR_MESSAGE);
    }

    public SendMessage command(Update update) {
        return super.command(update);
    }


}
