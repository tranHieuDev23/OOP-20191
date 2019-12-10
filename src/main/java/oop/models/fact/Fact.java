package oop.models.fact;
 
import oop.models.entity.Entity;
 
public interface Fact<S extends Entity, O extends Entity> {
    public S getSubject();
    public void setSubject(S subject);
    public O getObject();
    public void setObject(O object);
    public int getOriginId();
    public void setOriginId(int origin);
}