package bot;

import application.OvertimesWriter;
import commandManager.CommandMap;
import commandManager.Commands;
import commandManager.commands.statuses.UnknownCommand;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class Bot extends BotConfig implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    CommandMap mapOfCommands;
    OvertimesWriter overtimesWriter;
    SendMessage sendMessage;
    Commands commandClass;

    public Bot(String botToken) {
        this.mapOfCommands = new CommandMap();
        this.telegramClient = new OkHttpTelegramClient(botToken);
        this.overtimesWriter = new OvertimesWriter();
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (!isWaitingForDigit()) {
                commandClass = mapOfCommands.getCommandClass(update);
                if (commandClass == null) {
                    commandClass = new UnknownCommand();
                }

                sendMessage = commandClass.command(update);
            } else {
                commandClass = overtimesWriter.saveOvertimeToDB(update);
                sendMessage = commandClass.command(update);
            }

            try {
                telegramClient.execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}