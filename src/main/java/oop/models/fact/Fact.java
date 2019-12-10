package oop.models.fact;
 
import oop.models.entity.Entity;
 
public interface Fact<S extends Entity, O extends Entity> {
    public String getId();
    public void setId(String id);
    public S getSubject();
    public void setSubject(S subject);
    public O getObject();
    public void setObject(O object);
    public String getOriginId();
    public void setOriginId(String originId);
}