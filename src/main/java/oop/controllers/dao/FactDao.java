package oop.controllers.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.MultiDocumentEntity;

import oop.models.entity.Entity;
import oop.models.entity.impl.CountryEntity;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.object.HostingObjectEntity;
import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.object.SupportObjectEntity;
import oop.models.entity.subject.AttendingSubjectEntity;
import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;
import oop.models.fact.Fact;
import oop.models.fact.impl.AgreementFact;
import oop.models.fact.impl.AnnouncingFact;
import oop.models.fact.impl.AttendingFact;
import oop.models.fact.impl.CancellationFact;
import oop.models.fact.impl.DealingFact;
import oop.models.fact.impl.HostingFact;
import oop.models.fact.impl.MeetingFact;
import oop.models.fact.impl.ObjectionFact;
import oop.models.fact.impl.OrganizingFact;
import oop.models.fact.impl.SupportFact;
import oop.models.fact.impl.TensionFact;

public class FactDao extends Dao<Fact<? extends Entity, ? extends Entity>> {
    private static final String ENTITY_COLLECTION_NAME = "FACTS";
    private static final String AGREEMENT_CLASS_NAME = AgreementFact.class.getTypeName();
    private static final String ANNOUNCING_CLASS_NAME = AnnouncingFact.class.getTypeName();
    private static final String ATTENDING_CLASS_NAME = AttendingFact.class.getTypeName();
    private static final String CANCELLATION_CLASS_NAME = CancellationFact.class.getTypeName();
    private static final String DEALING_CLASS_NAME = DealingFact.class.getTypeName();
    private static final String HOSTING_CLASS_NAME = HostingFact.class.getTypeName();
    private static final String MEETING_CLASS_NAME = MeetingFact.class.getTypeName();
    private static final String OBJECTION_CLASS_NAME = ObjectionFact.class.getTypeName();
    private static final String ORGANIZING_CLASS_NAME = OrganizingFact.class.getTypeName();
    private static final String SUPPORT_CLASS_NAME = SupportFact.class.getTypeName();
    private static final String TENSION_CLASS_NAME = TensionFact.class.getTypeName();

    private EntityDao entityDao;

    private FactDao() {
        super(ENTITY_COLLECTION_NAME);
        this.entityDao = EntityDao.getInstance();
    }

    private static FactDao instance = null;

    public static FactDao getInstance() {
        if (instance == null) {
            instance = new FactDao();
        }
        return instance;
    }

    @Override
    public boolean exists(String id) {
        return this.collection.documentExists(id);
    }

    @Override
    public Fact<? extends Entity, ? extends Entity> get(String id) throws RuntimeException {
        try {
            BaseDocument document = this.collection.getDocument(id, BaseDocument.class);
            return fromBaseDocument(document);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while reading from database!", e);
        }
    }

    @Override
    public List<Fact<? extends Entity, ? extends Entity>> get(List<String> ids) throws RuntimeException {
        MultiDocumentEntity<BaseDocument> documents;
        try {
            documents = this.collection.getDocuments(ids, BaseDocument.class);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while reading from database!", e);
        }
        List<Fact<? extends Entity, ? extends Entity>> results = new ArrayList<>(documents.getDocuments().size());
        for (BaseDocument document : documents.getDocuments()) {
            results.add(this.fromBaseDocument(document));
        }
        return results;
    }

    @Override
    public void insert(Fact<? extends Entity, ? extends Entity> value) throws RuntimeException {
        try {
            this.collection.insertDocument(fromFact(value));
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void insert(List<Fact<? extends Entity, ? extends Entity>> values) throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Fact<? extends Entity, ? extends Entity> facts : values) {
            documents.add(fromFact(facts));
        }
        try {
            this.collection.insertDocuments(documents);
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void replace(String id, Fact<? extends Entity, ? extends Entity> value) throws RuntimeException {
        try {
            this.collection.replaceDocument(id, fromFact(value));
        } catch (Exception e) {
            throw new RuntimeException("Exception happened while writing to database!", e);
        }
    }

    @Override
    public void replace(List<String> ids, List<Fact<? extends Entity, ? extends Entity>> values)
            throws RuntimeException {
        List<BaseDocument> documents = new ArrayList<>(values.size());
        for (Fact<? extends Entity, ? extends Entity> fact : values) {
            documents.add(fromFact(fact));
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
            throw new RuntimeException("Exception happened while deleting from database!", e);
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
            throw new RuntimeException("Exception happened while deleting from database!", e);
        }
    }

    private Fact<? extends Entity, ? extends Entity> fromBaseDocument(BaseDocument baseDocument) {
        if (baseDocument == null)
            return null;

        Map<String, Object> propertiesMap = baseDocument.getProperties();
        String className = (String) propertiesMap.get("ClassName");
        String id = baseDocument.getKey();
        Entity subject = entityDao.get((String) propertiesMap.get("SubjectId"));
        Entity object = entityDao.get((String) propertiesMap.get("ObjectId"));
        String originId = (String) propertiesMap.get("OriginId");

        if (AGREEMENT_CLASS_NAME.equals(className)) {
            AgreementFact result = new AgreementFact();
            result.setId(id);
            result.setSubject((CountryEntity) subject);
            result.setObject((CountryEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (ANNOUNCING_CLASS_NAME.equals(className)) {
            AnnouncingFact result = new AnnouncingFact();
            result.setId(id);
            result.setSubject((PersonEntity) subject);
            result.setObject((EventEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (ATTENDING_CLASS_NAME.equals(className)) {
            AttendingFact result = new AttendingFact();
            result.setId(id);
            result.setSubject((AttendingSubjectEntity) subject);
            result.setObject((AttendingObjectEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (CANCELLATION_CLASS_NAME.equals(className)) {
            CancellationFact result = new CancellationFact();
            result.setId(id);
            result.setSubject((CancellationSubjectEntity) subject);
            result.setObject((CancellationObjectEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (DEALING_CLASS_NAME.equals(className)) {
            DealingFact result = new DealingFact();
            result.setId(id);
            result.setSubject((CountryEntity) subject);
            result.setObject((CountryEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (HOSTING_CLASS_NAME.equals(className)) {
            HostingFact result = new HostingFact();
            result.setId(id);
            result.setSubject((EventEntity) subject);
            result.setObject((HostingObjectEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (MEETING_CLASS_NAME.equals(className)) {
            MeetingFact result = new MeetingFact();
            result.setId(id);
            result.setSubject((PersonEntity) subject);
            result.setObject((PersonEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (OBJECTION_CLASS_NAME.equals(className)) {
            ObjectionFact result = new ObjectionFact();
            result.setId(id);
            result.setSubject((ObjectionSubjectEntity) subject);
            result.setObject((ObjectionObjectEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (ORGANIZING_CLASS_NAME.equals(className)) {
            OrganizingFact result = new OrganizingFact();
            result.setId(id);
            result.setSubject((OrganizingSubjectEntity) subject);
            result.setObject((EventEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (SUPPORT_CLASS_NAME.equals(className)) {
            SupportFact result = new SupportFact();
            result.setId(id);
            result.setSubject((SupportSubjectEntity) subject);
            result.setObject((SupportObjectEntity) object);
            result.setOriginId(originId);
            return result;
        }
        if (TENSION_CLASS_NAME.equals(className)) {
            TensionFact result = new TensionFact();
            result.setId(id);
            result.setSubject((CountryEntity) subject);
            result.setObject((CountryEntity) object);
            result.setOriginId(originId);
            return result;
        }
        return null;
    }

    private BaseDocument fromFact(Fact<? extends Entity, ? extends Entity> fact) {
        if (fact == null)
            return null;
        Map<String, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("ClassName", fact.getClass().getName());
        for (Method method : fact.getClass().getMethods()) {
            String methodName = method.getName();
            if (!methodName.startsWith("get") || "getClass".equals(methodName))
                continue;
            String property = methodName.substring(3);
            try {
                if ("getSubject".equals(methodName)) {
                    propertiesMap.put("SubjectId", ((Entity) method.invoke(fact)).getId());
                } else if ("getObject".equals(methodName)) {
                    propertiesMap.put("ObjectId", ((Entity) method.invoke(fact)).getId());
                } else
                    propertiesMap.put(property, method.invoke(fact).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        BaseDocument result = new BaseDocument();
        result.setKey(fact.getId());
        result.setProperties(propertiesMap);
        return result;
    }
}