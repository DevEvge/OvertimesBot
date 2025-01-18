package commandManager.commands;

import bot.Bot;
import bot.BotConfig;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Overtimes extends CommandConfig {


    public Overtimes() {
        super(MessageText.OVERTIMES_MESSAGE);
    }

    public SendMessage command(Update update) {
        Bot.setWaitingForDigit(true);
        return super.command(update);
    }
}
