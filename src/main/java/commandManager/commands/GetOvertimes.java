package commandManager.commands;

import bot.BotStatuses;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class GetOvertimes extends CommandConfig {

    public GetOvertimes() {
        super(MessageText.GET_OVERTIMES_PERIOD);
    }

    public SendMessage command(Update update, ReplyKeyboardMarkup keyboardMarkup) {
        return super.command(update, keyboardMarkup);
    }

    @Override
    public BotStatuses getSupportedStatus() {
        return BotStatuses.WAITING_DEFAULT;
    }
}
