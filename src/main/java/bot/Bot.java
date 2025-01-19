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
    private final CommandMap mapOfCommands;
    private final OvertimesWriter overtimesWriter;
    private  SendMessage sendMessage;
    private  Commands commandClass;
    public static BotStatuses botStatus = BotStatuses.WAITING_DEFAULT;

    public Bot(String botToken) {
        this.mapOfCommands = new CommandMap();
        this.telegramClient = new OkHttpTelegramClient(botToken);
        this.overtimesWriter = new OvertimesWriter();
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (botStatus == BotStatuses.WAITING_DEFAULT) {  // Проверка ждем ли бот ввод цифр
                commandClass = mapOfCommands.getCommandClass(update); //Проверет существует ли введенная команда
                if (commandClass == null) { //Если нет то выводит что команды нет
                    commandClass = new UnknownCommand();
                }
                sendMessage = commandClass.command(update); //Возвращает метод команды
            } else { // Если бот ждет цифр
                commandClass = mapOfCommands.getCommandFromList(botStatus);
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