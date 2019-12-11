package oop.controllers.dao;

import java.util.List;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;

public abstract class Dao<T> {
    private static final String ARANGO_DB = "oop_db";

    private static ArangoDB arangoDB = null;
    private static ArangoDatabase arangoDatabase = null;

    public static void connect(String user, String password) {
        arangoDB = new ArangoDB.Builder().user(user).password(password).build();
        arangoDatabase = arangoDB.db(ARANGO_DB);
    }

    private static ArangoDatabase getDatabase() {
        if (!arangoDatabase.exists()) {
            try {
                arangoDB.createDatabase(ARANGO_DB);
                arangoDatabase = arangoDB.db(ARANGO_DB);
            } catch (Exception e) {
                throw new RuntimeException("Exception happened during database initialization!", e);
            }
        }
        return arangoDatabase;
    }

    public static void closeConnection() throws RuntimeException {
        if (arangoDB != null) {
            try {
                arangoDB.shutdown();
                arangoDB = null;
            } catch (Exception e) {
                new RuntimeException("Exception happened while closing connection!", e);
            }
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

    public abstract T get(String id) throws RuntimeException;

    public abstract List<T> get(List<String> id) throws RuntimeException;

    public abstract void insert(T value) throws RuntimeException;

    public abstract void insert(List<T> values) throws RuntimeException;

    public abstract void replace(String id, T value) throws RuntimeException;

    public abstract void replace(List<String> ids, List<T> values) throws RuntimeException;

    public abstract void delete(String id) throws RuntimeException;

    public abstract void delete(List<String> ids) throws RuntimeException;
}