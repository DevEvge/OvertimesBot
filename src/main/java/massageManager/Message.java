package massageManager;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface Message {
    SendMessage massage(Update update, String message, ReplyKeyboardMarkup keyboard);
    SendMessage massage(Update update, String message);
}
