package massageManager;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class MessageHandler implements Message{

    @Override
    public SendMessage massage(Update update, String message, ReplyKeyboardMarkup keyboard) {
        Long chatID = update.getMessage().getChatId();
        SendMessage sendMessage = SendMessage.builder()
                .chatId(chatID)
                .text(message)
                .replyMarkup(keyboard)
                .build();
        return sendMessage;
    }
}
