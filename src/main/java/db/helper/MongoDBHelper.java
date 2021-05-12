package db.helper;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDBHelper {

    private static volatile MongoClient mongoClient;

    private static void initializeMongoClient() {
        try {
            String monooDBHost = "localhost"; // set up the host

            // Some checking

            mongoClient = new MongoClient(monooDBHost, 27017 /*Or specified host port*/);
        } catch (Exception e) {
            //Do something
        }
    }

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            synchronized (MongoClient.class) {
                if (mongoClient == null) {
                    initializeMongoClient();
                }
            }
        }

        return mongoClient;
    }

    public static MongoDatabase getMongoDatabase(MongoClient client) {
        MongoDatabase database = null;

        try {
            String db = "Web"; // Your database name
            database = client.getDatabase(db);
        } catch (Exception e) {
            //Do something
        }

        return database;
    }

    public static MongoCollection<Document> loadMonoCollection(MongoClient client, String collectionName) {
        MongoCollection<Document> collection = null;

        MongoDatabase database = getMongoDatabase(client);

        collection = database.getCollection(collectionName);

        return collection;
    }
}
