package application;

import DataBaseController.DataBaseConnection;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class OvertimesReader {
    DataBaseConnection database = new DataBaseConnection();


    public Double overtimesForThisMonth(long chatID) {
        MongoCollection<Document> collection = database.connectDatabase();

        LocalDate date = LocalDate.now();
        LocalDate startOfMouth = date.withDayOfMonth(1);
        LocalDate endOfMouth = startOfMouth.plusMonths(1);

        String startDataStr = startOfMouth.toString();
        String endDataStr = endOfMouth.toString();

        List<Document> pipeline = Arrays.asList(
                new Document("$match", new Document("ChatID", chatID)
                        .append("Date", new Document("$gte", startDataStr)
                                .append("$lt", endDataStr))),
                new Document("$group", new Document("_id", "$ChatID")
                        .append("totalHours", new Document("$sum", new Document("$toDouble", "$hours"))))
        );

        AggregateIterable<Document> result = collection.aggregate(pipeline);
        Document aggregatedResult = result.first();

        if (aggregatedResult != null && aggregatedResult.get("totalHours") != null) {
            return aggregatedResult.getDouble("totalHours");
        }
        return 0.0;
    }
}
