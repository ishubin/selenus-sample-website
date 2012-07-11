package models;

import play.data.validation.Required;
import play.db.jpa.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Article extends Model {
    
    @Required(message="Title should not be empty")
	public String title;
    
    @Required(message="There is no text for article")
	public String text;
	public Date date;
	public String author;
	
	@ManyToOne
	public Section section;

	public Article(String title, String text, Date date, String author, Section section) {
		this.title = title;
		this.text  = text;
		this.date = date;
		this.author = author;
		this.section = section;
	}
	
	public static List<Article> newArticles() {
	    return Article.find("order by date desc").fetch();
	}

	
}