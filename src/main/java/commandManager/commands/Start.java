    package commandManager.commands;

    import commandManager.CommandConfig;
    import massageManager.MessageText;
    import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
    import org.telegram.telegrambots.meta.api.objects.Update;

    public class Start extends CommandConfig {

        public Start() {
            super(MessageText.START_MESSAGE);
        }

        public SendMessage command(Update update) {
            return super.command(update);
        }

    }
