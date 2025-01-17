import bot.Bot;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static void main(String[] args) {
        String botToken = System.getenv("BOT_TOKEN");

        try (TelegramBotsLongPollingApplication telegramBot = new TelegramBotsLongPollingApplication()){
            telegramBot.registerBot(botToken, new Bot(botToken));
            Thread.currentThread()
                    .join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
