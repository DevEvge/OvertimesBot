    package commandManager.commands;

    import commandManager.CommandConfig;
    import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
    import org.telegram.telegrambots.meta.api.objects.Update;

    public class Start extends CommandConfig {

        @Override
        public SendMessage command(Update update) {
            return messageHandler.massage(update, messageText.getSTART_MESSAGE(), keyboard.newKeyboard());
        }


    }
