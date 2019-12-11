package oop.controllers.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        BaseDocument document = this.collection.getDocument(id, BaseDocument.class);
        return fromBaseDocument(document);
    }

    @Override
    public List<Article> get(List<String> ids) throws RuntimeException {
        MultiDocumentEntity<BaseDocument> documents = this.collection.getDocuments(ids, BaseDocument.class);
        List<Article> results = new ArrayList<>(documents.getDocuments().size());
        for (BaseDocument document : documents.getDocuments()) {
            results.add(this.fromBaseDocument(document));
        }
        return results;
    }

    @Override
    public void insert(Article value) throws RuntimeException {
        this.collection.insertDocument(fromArticle(value));
    }

    @Override
    public void insert(List<Article> values) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Article article : values) {
            documents.add(fromArticle(article));
        }
        this.collection.insertDocuments(documents);
    }

    @Override
    public void replace(String id, Article value) throws RuntimeException {
        this.collection.replaceDocument(id, fromArticle(value));
    }

    @Override
    public void replace(List<String> ids, List<Article> values) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Article article : values) {
            documents.add(fromArticle(article));
        }
        this.collection.replaceDocuments(documents);
    }

    @Override
    public void delete(String id) throws RuntimeException {
        this.collection.deleteDocument(id);
    }

    @Override
    public void delete(List<String> ids) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(ids.size());
        for (String id : ids) {
            BaseDocument document = new BaseDocument();
            document.setKey(id);
            documents.add(document);
        }
        this.collection.deleteDocuments(documents);
    }

    private Article fromBaseDocument(BaseDocument baseDocument) {
        if (baseDocument == null)
            return null;
        Map<String, Object> propertiesMap = baseDocument.getProperties();
        DateFormat dateFormat = new SimpleDateFormat();
        Article result = new Article();
        result.setId(baseDocument.getKey());
        try {
            result.setPublishedDate(dateFormat.parse((String) propertiesMap.get("PublishedDate")));
        } catch (ParseException e) {
            result.setPublishedDate(null);
        }
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
        result.getProperties().put("PublishedDate", article.getPublishedDate());
        result.getProperties().put("Url", article.getUrl());
        List<String> extractedFactIds = new ArrayList<>();
        for (Fact<? extends Entity, ? extends Entity> fact : article.getExtractedFacts()) {
            extractedFactIds.add(fact.getId());
        }
        result.getProperties().put("ExtractedFactIds", extractedFactIds);
        return result;
    }
}