package oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.entity.Entity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.MeetingFact;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EntityDao entityDao = EntityDao.getInstance();
        FactDao factDao = FactDao.getInstance();
        List<Entity> entities = new ArrayList<>();

        PersonEntity son = new PersonEntity();
        son.setId("1");
        son.setLabel("Son");
        son.setContent("Information about the son");
        son.setBirthday(new Date());
        son.setDateOfDeath(new Date());
        son.setOccupation("A job");

        PersonEntity father = new PersonEntity();
        father.setId("2");
        father.setLabel("Father");
        father.setContent("Information about the father");
        father.setBirthday(new Date());
        father.setDateOfDeath(new Date());
        father.setOccupation("A bigger job");

        MeetingFact fact = new MeetingFact();
        fact.setId("1");
        fact.setSubject(son);
        fact.setObject(father);
        fact.setOriginId("1");

        entities.add(son);
        entities.add(father);
        entityDao.insert(entities);
        factDao.insert(fact);

        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        List<Entity> results = entityDao.get(ids);
        System.out.print(results);

        List<String> factIds = new ArrayList<>();
        factIds.add("1");
        List<Fact<? extends Entity, ? extends Entity>> factResults = factDao.get(factIds);
        System.out.print(factResults);
        
        Dao.closeConnection();
    }
}
