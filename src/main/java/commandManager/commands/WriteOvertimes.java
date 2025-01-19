package commandManager.commands;

import bot.Bot;
import bot.BotStatuses;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class WriteOvertimes extends CommandConfig {


    public WriteOvertimes() {
        super(MessageText.OVERTIMES_MESSAGE);
    }

    public SendMessage command(Update update) {
        Bot.botStatus = BotStatuses.WAITING_FOR_WRITE_OVERTIMES;
        return super.command(update);
    }

    @Override
    public BotStatuses getSupportedStatus() {
        return BotStatuses.WAITING_DEFAULT;
    }
}
