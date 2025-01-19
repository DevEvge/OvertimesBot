package commandManager;

import keyboards.DefaultKeyboard;
import massageManager.MessageHandler;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public abstract class CommandConfig implements Commands {
    protected MessageHandler messageHandler;
    protected DefaultKeyboard defaultKeyboard;
    private final String message;


    public CommandConfig(String message) {
        this.message = message;
        this.defaultKeyboard = new DefaultKeyboard();
        this.messageHandler = new MessageHandler();
    }

    @Override
    public SendMessage command(Update update) {
        return messageHandler.massage(update, message, defaultKeyboard.newKeyboard());
    }

    public SendMessage command(Update update, ReplyKeyboardMarkup keyboardMarkup) {
        return messageHandler.massage(update, message, keyboardMarkup);
    }

    public SendMessage command(Update update, String message) {
        return messageHandler.massage(update, message, defaultKeyboard.newKeyboard());
    }
}
