package oop.models.fact;
 
import oop.models.entity.Entity;
import oop.models.article.Article;
 
public interface Fact<S extends Entity, O extends Entity> {
    public S getSubject();
    public void setSubject(S subject);
    public O getObject();
    public void setObject(O object);
    public String getType();
    public Article getOrigin();
    public void setOrigin(Article origin);
}