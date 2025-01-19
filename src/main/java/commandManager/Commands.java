package commandManager;

import bot.BotStatuses;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Commands {
    SendMessage command(Update update);
    BotStatuses getSupportedStatus();

}
