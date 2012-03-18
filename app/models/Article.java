package models;

import play.db.jpa.*;
import java.util.Date;

public class Article extends Model {
	public String title;
	public String text;
	public Date date;
	public String author;

	public Article(String title, String text, Date date, String author) {
		this.title = title;
		this.text  = text;
		this.date = date;
		this.author = author;
	}

}