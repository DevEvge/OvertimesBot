package commandManager.commands;

import bot.Bot;
import bot.BotStatuses;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class GetOvertimes extends CommandConfig {


    public GetOvertimes() {
        super(MessageText.GET_OVERTIMES_PERIOD);
    }

    public SendMessage command(Update update) {
        Bot.botStatus = BotStatuses.WAITING_FOR_DATE;
        return super.command(update, defaultKeyboard.dateChoiseKeyboard());
    }

    @Override
    public BotStatuses getSupportedStatus() {
        return BotStatuses.WAITING_DEFAULT;
    }
}
