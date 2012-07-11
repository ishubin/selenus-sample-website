package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Comment extends Model {

    @Required
    public String message;
    public String name;
    
    @ManyToOne
    public Article article;
    
    
    public Comment(String message, String name, Article article) {
        this.message = message;
        this.name = name;
        this.article = article;
    }
}
