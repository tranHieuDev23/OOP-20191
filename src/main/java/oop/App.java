package oop;

import com.arangodb.ArangoDB;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ArangoDB arangoDB = new ArangoDB.Builder()
            .user("root")
            .password("admin")    
            .build();
        String dbName = "mydb";
        try {
            arangoDB.createDatabase(dbName);
            System.out.println("Database created: " + dbName);
        } catch (Exception e) {
            System.err.println("Failed to create database " + dbName + "; " + e.getMessage());
        }
    }
}
