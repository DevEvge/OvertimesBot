package DataBaseController;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class DataBaseConnection {
    private String connectionString = System.getenv("DB_TOKEN");

    ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();

    private MongoClient mongoClient = MongoClients.create(settings);

    public MongoCollection<Document> connectDatabase() {
        try {
            try {
                MongoDatabase database = mongoClient.getDatabase("OverTimeBot");
                return database.getCollection("OverTimes");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        } catch (MongoException e){
            e.printStackTrace();
        }
        return null;
    }
}
