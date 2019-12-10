package oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.PersonEntity;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EntityDao entityDao = EntityDao.getInstance();
        List<Entity> entities = new ArrayList<>();

        PersonEntity person = new PersonEntity();
        person.setId("1");
        person.setLabel("person");
        person.setContent("a person");
        person.setBirthday(new Date());
        person.setDateOfDeath(new Date());
        person.setOccupation("A job");

        entities.add(person);
        entityDao.insert(entities);

        List<String> ids = new ArrayList<>();
        ids.add("1");
        List<Entity> result = entityDao.get(ids);
        // Entity result = entityDao.get("1");
        System.out.print(result);
        
        Dao.closeConnection();
    }
}
