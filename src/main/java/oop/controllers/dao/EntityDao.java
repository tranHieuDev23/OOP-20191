package oop.controllers.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.MultiDocumentEntity;

import oop.models.entity.Entity;
import oop.models.entity.impl.AgreementEntity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.LocationEntity;
import oop.models.entity.impl.OrganizationEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.entity.impl.TimeEntity;

public class EntityDao extends Dao<Entity> {
    private static final String ENTITY_COLLECTION_NAME = "ENTITIES";
    private static final String AGREEMENT_CLASS_NAME = AgreementEntity.class.getName();
    private static final String COUNTRY_CLASS_NAME = CountryEntity.class.getName();
    private static final String EVENT_CLASS_NAME = EventEntity.class.getName();
    private static final String LOCATION_CLASS_NAME = LocationEntity.class.getName();
    private static final String ORGANIZATION_CLASS_NAME = OrganizationEntity.class.getName();
    private static final String PERSON_CLASS_NAME = PersonEntity.class.getName();
    private static final String TIME_CLASS_NAME = TimeEntity.class.getName();

    private EntityDao() {
        super(ENTITY_COLLECTION_NAME);
    }

    private static EntityDao instance = null;

    public static EntityDao getInstance() {
        if (instance == null) {
            instance = new EntityDao();
        }
        return instance;
    }

    @Override
    public boolean exists(String id) {
        return this.collection.documentExists(id);
    }

    @Override
    public Entity get(String id) {
        BaseDocument document = this.collection.getDocument(id, BaseDocument.class);
        return fromBaseDocument(document);
    }

    @Override
    public List<Entity> get(List<String> ids) {
        MultiDocumentEntity<BaseDocument> documents = this.collection.getDocuments(ids, BaseDocument.class);
        List<Entity> results = new ArrayList<>(documents.getDocuments().size());
        for (BaseDocument document : documents.getDocuments()) {
            results.add(this.fromBaseDocument(document));
        }
        return results;
    }

    @Override
    public void insert(Entity value) {
        this.collection.insertDocument(fromEntity(value));
    }

    @Override
    public void insert(List<Entity> values) {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Entity entity : values) {
            documents.add(fromEntity(entity));
        }
        this.collection.insertDocuments(documents);
    }

    @Override
    public void replace(String id, Entity value) {
        this.collection.replaceDocument(id, fromEntity(value));
    }

    @Override
    public void replace(List<String> ids, List<Entity> values) {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Entity entity : values) {
            documents.add(fromEntity(entity));
        }
        this.collection.replaceDocuments(documents);
    }

    @Override
    public void delete(String id) {
        this.collection.deleteDocument(id);
    }

    @Override
    public void delete(List<String> ids) {
        List<BaseDocument> documents = new ArrayList<>(ids.size());
        for (String id : ids) {
            BaseDocument document = new BaseDocument();
            document.setKey(id);
            documents.add(document);
        }
        this.collection.deleteDocuments(documents);
    }

    private Entity fromBaseDocument(BaseDocument baseDocument) {
        if (baseDocument == null)
            return null;
        Map<String, Object> propertiesMap = baseDocument.getProperties();
        String className = (String) propertiesMap.get("ClassName");
        if (AGREEMENT_CLASS_NAME.equals(className)) {
            AgreementEntity result = new AgreementEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            return result;
        }
        if (COUNTRY_CLASS_NAME.equals(className)) {
            CountryEntity result = new CountryEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            result.setContinent(CountryEntity.Continent.fromId((int) propertiesMap.get("Continent")));
            return result;
        }
        if (EVENT_CLASS_NAME.equals(className)) {
            EventEntity result = new EventEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            return result;
        }
        if (LOCATION_CLASS_NAME.equals(className)) {
            LocationEntity result = new LocationEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            result.setLatitude((double) propertiesMap.get("Latitude"));
            result.setLongitude((double) propertiesMap.get("Longitude"));
            return result;
        }
        if (ORGANIZATION_CLASS_NAME.equals(className)) {
            OrganizationEntity result = new OrganizationEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            result.setField((String) propertiesMap.get("Field"));
            result.setBaseOfOperation((String) propertiesMap.get("BaseOfOperation"));
            return result;
        }
        DateFormat dateFormat = new SimpleDateFormat();
        if (PERSON_CLASS_NAME.equals(className)) {
            PersonEntity result = new PersonEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            result.setOccupation((String) propertiesMap.get("Occupation"));
            try {
                result.setBirthday(dateFormat.parse((String) propertiesMap.get("Birthday")));
            } catch (Exception e) {
                result.setBirthday(null);
            }
            try {
                result.setDateOfDeath(dateFormat.parse((String) propertiesMap.get("DateOfDeath")));
            } catch (Exception e) {
                result.setDateOfDeath(null);
            }
            return result;
        }
        if (TIME_CLASS_NAME.equals(className)) {
            TimeEntity result = new TimeEntity();
            result.setId((String) propertiesMap.get("Id"));
            result.setContent((String) propertiesMap.get("Content"));
            result.setLabel((String) propertiesMap.get("Label"));
            try {
                result.setTime(dateFormat.parse((String) propertiesMap.get("Time")));
            } catch (Exception e) {
                result.setTime(null);
            }
            return result;
        }
        return null;
    }

    private BaseDocument fromEntity(Entity entity) {
        if (entity == null)
            return null;
        Map<String, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("ClassName", entity.getClass().getName());
        for (Method method : entity.getClass().getMethods()) {
            String methodName = method.getName();
            if (!methodName.startsWith("get") || "getClass".equals(methodName))
                continue;
            String property = methodName.substring(3);
            try {
                propertiesMap.put(property, method.invoke(entity));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        BaseDocument result = new BaseDocument();
        result.setKey(entity.getId());
        result.setProperties(propertiesMap);
        return result;
    }
}