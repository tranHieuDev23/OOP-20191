package oop;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import oop.controllers.dao.ArticleDao;
import oop.controllers.dao.Dao;
import oop.controllers.dao.EntityDao;
import oop.controllers.dao.FactDao;
import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.MeetingFact;

/**
 * Hello world!
 *
 */
public class App {
    private static final String ARANGO_USERNAME = "root";
    private static final String ARANGO_PASSWORD = "admin";

    public static void main(String[] args) {
        Dao.connect(ARANGO_USERNAME, ARANGO_PASSWORD);
        EntityDao entityDao = EntityDao.getInstance();
        FactDao factDao = FactDao.getInstance();
        ArticleDao articleDao = ArticleDao.getInstance();

        PersonEntity son = new PersonEntity();
        son.setId("1");
        son.setLabel("Son");
        son.setContent("Information about the son");
        son.setBirthday(Instant.now());
        son.setDateOfDeath(Instant.now());
        son.setOccupation("A job");

        PersonEntity father = new PersonEntity();
        father.setId("2");
        father.setLabel("Father");
        father.setContent("Information about the father");
        father.setBirthday(Instant.now());
        father.setDateOfDeath(Instant.now());
        father.setOccupation("A bigger job");

        MeetingFact fact = new MeetingFact();
        fact.setId("1");
        fact.setSubject(son);
        fact.setObject(father);
        fact.setOriginId("1");

        List<Fact<? extends Entity, ? extends Entity>> facts = new ArrayList<>();
        facts.add(fact);

        Article article = new Article();
        article.setId("1");
        article.setPublishedDate(Instant.now());
        article.setUrl("https://facebook.com");
        article.setExtractedFacts(facts);

        try {
            entityDao.insert(son);
            entityDao.insert(father);
            factDao.insert(facts);
            articleDao.insert(article);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        List<Entity> results = entityDao.get(ids);
        System.out.println(results);

        Fact<? extends Entity, ? extends Entity> resultFact = factDao.get(fact.getId());
        System.out.println(resultFact.getId());
        System.out.println(resultFact.getOriginId());
        System.out.println(resultFact.getObject());
        System.out.println(resultFact.getSubject());

        Article resultArticle = articleDao.get("1");
        System.out.println(resultArticle.getId());
        System.out.println(resultArticle.getUrl());
        System.out.println(resultArticle.getPublishedDate());
        System.out.println(resultArticle.getExtractedFacts());

        Dao.closeConnection();
    }
}
