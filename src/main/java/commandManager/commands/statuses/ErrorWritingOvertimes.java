package commandManager.commands.statuses;

import commandManager.CommandConfig;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ErrorWritingOvertimes extends CommandConfig {
    @Override
    public SendMessage command(Update update) {
        return messageHandler.massage(update, messageText.getOVERTIMES_WRITE_ERROR(), keyboard.newKeyboard());
    }
}
