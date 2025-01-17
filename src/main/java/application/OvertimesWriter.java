package application;

import DataBaseController.DataBaseConnection;
import com.mongodb.client.MongoCollection;
import commandManager.Commands;
import commandManager.commands.statuses.ErrorWritingOvertimes;
import commandManager.commands.statuses.OvertimesWritingSuccess;
import massageManager.MessageHandler;
import org.bson.Document;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OvertimesWriter {
    DataBaseConnection database = new DataBaseConnection();

    public Commands saveOvertimeToDB(Update update) {
        String textFromMessage = update.getMessage().getText();
        String normalizer = textFromMessage.replace(",", ".");
        try {
            double time = Double.parseDouble(normalizer);
            if (time < 0) {
                return new ErrorWritingOvertimes();
            }

            int hours = (int) time;
            double fractional = time - hours;
            double minutes = fractional * 100;

            if (minutes >= 60 && hours >= 24) {
                return new ErrorWritingOvertimes();
            }

            long chatID = update.getMessage().getChatId();
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = date.format(formatter);

            MongoCollection<Document> collection = database.connectDatabase();
            Document doc = new Document("ChatID", chatID)
                    .append("Date", formattedDate)
                    .append("hours", normalizer);

            collection.insertOne(doc);


        } catch (NumberFormatException e) {
            return new ErrorWritingOvertimes();
        }
        return new OvertimesWritingSuccess();
    }


    /*
    ChatID 6758518429
    Date "17.01.2025"
    hours 2
     */
}
