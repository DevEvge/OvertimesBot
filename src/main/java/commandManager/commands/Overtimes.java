package commandManager.commands;

import bot.Bot;
import bot.BotConfig;
import commandManager.CommandConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Overtimes extends CommandConfig {
    @Override
    public SendMessage command(Update update) {
        Bot.setWaitingForDigit(true);
        return messageHandler.massage(update, messageText.getOVERTIMES_MESSAGE(), keyboard.newKeyboard());

    }
}
