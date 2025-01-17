package commandManager.commands.statuses;

import commandManager.CommandConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand extends CommandConfig {

    @Override
    public SendMessage command(Update update) {
        return messageHandler.massage(update, messageText.getERROR_MESSAGE(), keyboard.newKeyboard());
    }
}
