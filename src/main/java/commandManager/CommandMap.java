package commandManager;

import bot.BotStatuses;
import commandManager.commands.getOvertimes;
import commandManager.commands.statuses.OvertimesWritingSuccess;
import commandManager.commands.statuses.UnknownCommand;
import commandManager.commands.writeOvertimes;
import commandManager.commands.Start;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandMap {
    Map<String, Commands> commands;
    List<Commands> listForCommand;

    public CommandMap() {
        this.commands = new HashMap<>();
        this.listForCommand = new ArrayList<>();

        commands.put("/start", new Start());
        commands.put("Новая запись⏰", new writeOvertimes());
        commands.put("Мои овертаймы", new getOvertimes());

        listForCommand.add(new OvertimesWritingSuccess());
    }

    public Commands getCommandClass(Update update) {
        String text = update.getMessage().getText();
        return commands.get(text);
    }

    public Commands getCommandFromList(BotStatuses botStatuses) {
        return listForCommand.stream()
                .filter(cmd -> cmd.getSupportedStatus() == botStatuses)
                .findFirst()
                .orElse(new UnknownCommand());
    }


}
