package oop.controllers.dao;

import java.util.List;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;

public abstract class Dao<T> {
    private static final String ARANGO_USERNAME = "root";
    private static final String ARANGO_PASSWORD = "admin";
    private static final String ARANGO_DB = "oop_db";

    private static ArangoDB arangoDB = null;
    private static ArangoDatabase arangoDatabase = null;

    private static ArangoDB getArangoDB() {
        if (arangoDB == null) {
            arangoDB = new ArangoDB.Builder().user(ARANGO_USERNAME).password(ARANGO_PASSWORD).build();
        }
        return arangoDB;
    }

    private static ArangoDatabase getDatabase() {
        if (arangoDatabase == null) {
            arangoDatabase = getArangoDB().db(ARANGO_DB);
            if (!arangoDatabase.exists()) {
                try {
                    getArangoDB().createDatabase(ARANGO_DB);
                    arangoDatabase = getArangoDB().db(ARANGO_DB);
                } catch (Exception e) {
                    throw new RuntimeException("Exception happened during database initialization!", e);
                }
            }
        }
        return arangoDatabase;
    }

    public static void closeConnection() {
        if (arangoDB != null) {
            arangoDB.shutdown();
            arangoDB = null;
        }
    }

    protected ArangoCollection collection;

    protected Dao(String collectionName) {
        this.collection = getDatabase().collection(collectionName);
        if (!this.collection.exists()) {
            try {
                getDatabase().createCollection(collectionName);
                this.collection = getDatabase().collection(collectionName);
            } catch (Exception e) {
                throw new RuntimeException("Exception happened during DAO initialization!", e);
            }
        }
    }

    public abstract boolean exists(String id);

    public abstract T get(String id);

    public abstract List<T> get(List<String> id);

    public abstract void insert(T value);

    public abstract void insert(List<T> values);

    public abstract void replace(String id, T value);

    public abstract void replace(List<String> ids, List<T> values);

    public abstract void delete(String id);

    public abstract void delete(List<String> ids);
}