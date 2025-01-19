package commandManager.commands.statuses;

import application.OvertimesWriter;
import bot.Bot;
import bot.BotConfig;
import bot.BotStatuses;
import commandManager.CommandConfig;
import massageManager.MessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class OvertimesWritingSuccess extends CommandConfig {
    OvertimesWriter overtimesWriter = new OvertimesWriter();

    public OvertimesWritingSuccess() {
        super(MessageText.OVERTIMES_WRITE_SUCCESS);
    }

    public SendMessage command(Update update) {
        boolean isOvertimeWritedToDB = overtimesWriter.saveOvertimeToDB(update);
        Bot.setWaitingForUserWrite(false);
        Bot.setWaitingForWriteOvertimes(false);
        Bot.botStatus = BotStatuses.WAITING_DEFAULT;

        if (isOvertimeWritedToDB == true) {
            return super.command(update, MessageText.OVERTIMES_WRITE_SUCCESS);
        } else {
            return super.command(update, MessageText.OVERTIMES_WRITE_ERROR);
        }
    }

    @Override
    public BotStatuses getSupportedStatus() {
        return BotStatuses.WAITING_FOR_WRITE_OVERTIMES;
    }
}
