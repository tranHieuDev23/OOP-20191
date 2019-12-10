package oop;

import java.util.ArrayList;
import java.util.List;

import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> result = entityDao.get(new ArrayList<String>());
        System.out.print(result);
        Dao.closeConnection();
    }
}
