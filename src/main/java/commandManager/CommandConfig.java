package commandManager;

import keyboards.Keyboard;
import massageManager.MessageHandler;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class CommandConfig implements Commands {
    protected MessageHandler messageHandler;
    protected Keyboard keyboard;
    private final String message;


    public CommandConfig(String message) {
        this.message = message;
        this.keyboard = new Keyboard();
        this.messageHandler = new MessageHandler();
    }

    @Override
    public SendMessage command(Update update) {
        return messageHandler.massage(update, message, keyboard.newKeyboard());
    }


}
