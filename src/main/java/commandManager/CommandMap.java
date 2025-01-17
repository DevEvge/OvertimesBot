package commandManager;

import commandManager.commands.Overtimes;
import commandManager.commands.Start;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public class CommandMap {
    Map<String, Commands> commands;

    public CommandMap() {
        this.commands = new HashMap<>();
        commands.put("/start", new Start());
        commands.put("Овертаймы ⏰", new Overtimes());
    }

    public Commands getCommandClass(Update update) {
        String text = update.getMessage().getText();
        return commands.get(text);
    }


}
