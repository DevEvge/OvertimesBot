package commandManager;

import keyboards.Keyboard;
import massageManager.MessageHandler;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class CommandConfig implements Commands {
    protected MessageHandler messageHandler = new MessageHandler();
    protected MessageText messageText = new MessageText();
    protected Keyboard keyboard = new Keyboard();




}
