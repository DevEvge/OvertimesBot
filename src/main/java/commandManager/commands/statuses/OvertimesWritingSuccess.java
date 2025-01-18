package commandManager.commands.statuses;

import bot.Bot;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class OvertimesWritingSuccess extends CommandConfig {


    public OvertimesWritingSuccess() {
        super(MessageText.OVERTIMES_WRITE_SUCCESS);
    }

    public SendMessage command(Update update) {
        Bot.setWaitingForDigit(false);
        return super.command(update);
    }
}
