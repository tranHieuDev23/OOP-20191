package oop.controllers.dao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.MultiDocumentEntity;

import oop.models.article.Article;
import oop.models.entity.Entity;
import oop.models.fact.Fact;

public class ArticleDao extends Dao<Article> {
    private static final String COLLECTION_NAME = "ARTICLE";

    private FactDao factDao;

    private ArticleDao() {
        super(COLLECTION_NAME);
        this.factDao = FactDao.getInstance();
    }

    private static ArticleDao instance;

    public static ArticleDao getInstance() {
        if (instance == null) {
            instance = new ArticleDao();
        }
        return instance;
    }

    @Override
    public boolean exists(String id) {
        return this.collection.documentExists(id);
    }

    @Override
    public Article get(String id) throws RuntimeException {
        BaseDocument document;
        try {
            document = this.collection.getDocument(id, BaseDocument.class);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while reading from database!", e);
        }
        return fromBaseDocument(document);
    }

    @Override
    public List<Article> get(List<String> ids) throws RuntimeException {
        MultiDocumentEntity<BaseDocument> documents;
        try {
            documents = this.collection.getDocuments(ids, BaseDocument.class);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while reading from database!", e);
        }
        List<Article> results = new ArrayList<>(documents.getDocuments().size());
        for (BaseDocument document : documents.getDocuments()) {
            results.add(this.fromBaseDocument(document));
        }
        return results;
    }

    @Override
    public void insert(Article value) throws RuntimeException {
        try {
            this.collection.insertDocument(fromArticle(value));
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void insert(List<Article> values) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Article article : values) {
            documents.add(fromArticle(article));
        }
        try {
            this.collection.insertDocuments(documents);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void replace(String id, Article value) throws RuntimeException {
        try {
            this.collection.replaceDocument(id, fromArticle(value));
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void replace(List<String> ids, List<Article> values) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Article article : values) {
            documents.add(fromArticle(article));
        }
        try {
            this.collection.replaceDocuments(documents);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void delete(String id) throws RuntimeException {
        try {
            this.collection.deleteDocument(id);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while deleting from database", e);
        }
    }

    @Override
    public void delete(List<String> ids) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(ids.size());
        for (String id : ids) {
            BaseDocument document = new BaseDocument();
            document.setKey(id);
            documents.add(document);
        }
        try {
            this.collection.deleteDocuments(documents);    
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while deleting from database", e);
        }
    }

    private Article fromBaseDocument(BaseDocument baseDocument) {
        if (baseDocument == null)
            return null;
        Map<String, Object> propertiesMap = baseDocument.getProperties();
        Article result = new Article();
        result.setId(baseDocument.getKey());
        result.setPublishedDate(Instant.parse((String) propertiesMap.get("PublishedDate")));
        result.setUrl((String) propertiesMap.get("Url"));
        Object extractedFactIdsList = propertiesMap.get("ExtractedFactIds");
        if (extractedFactIdsList instanceof List<?>) {
            List<String> extractedFactIds = new ArrayList<>();
            for (Object id : (List<?>) extractedFactIdsList)
                extractedFactIds.add((String) id);
            result.setExtractedFacts(factDao.get(extractedFactIds));
        }
        return result;
    }

    private BaseDocument fromArticle(Article article) {
        if (article == null)
            return null;
        BaseDocument result = new BaseDocument();
        result.setKey(article.getId());
        result.getProperties().put("Id", article.getId());
        result.getProperties().put("PublishedDate", article.getPublishedDate().toString());
        result.getProperties().put("Url", article.getUrl());
        List<String> extractedFactIds = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : article.getExtractedFacts()) {
            extractedFactIds.add(fact.getId());
        }
        result.getProperties().put("ExtractedFactIds", extractedFactIds);
        return result;
    }
}