package commandManager.commands.statuses;

import application.OvertimesReader;
import bot.Bot;
import bot.BotStatuses;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class OvertimesReaderStatus extends CommandConfig {
    OvertimesReader overtimesReader = new OvertimesReader();


    @Override
    public BotStatuses getSupportedStatus() {
        return BotStatuses.WAITING_FOR_DATE;
    }

    @Override
    public SendMessage command(Update update) {
        Long chatId = update.getMessage().getChatId();
        Double totalOvertimesForMonth = overtimesReader.overtimesForThisMonth(chatId);
        Bot.botStatus = BotStatuses.WAITING_DEFAULT;
        return super.command(update, MessageText.totalHoursForMonth(totalOvertimesForMonth));
    }
}
