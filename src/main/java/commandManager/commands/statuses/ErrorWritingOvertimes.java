package commandManager.commands.statuses;

import bot.Bot;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ErrorWritingOvertimes extends CommandConfig {

    public ErrorWritingOvertimes() {
        super(MessageText.OVERTIMES_WRITE_ERROR);
    }

    public SendMessage command(Update update) {
        return super.command(update);
    }
}
