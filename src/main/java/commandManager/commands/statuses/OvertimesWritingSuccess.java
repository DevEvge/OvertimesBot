package commandManager.commands.statuses;

import bot.Bot;
import commandManager.CommandConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class OvertimesWritingSuccess extends CommandConfig {
    @Override
    public SendMessage command(Update update) {
        Bot.setWaitingForDigit(false);
        return messageHandler.massage(update, messageText.getOVERTIMES_WRITE_SUCCESS(), keyboard.newKeyboard());
    }
}
