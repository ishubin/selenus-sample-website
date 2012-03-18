package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Articles extends Controller {

    public static void newArticles() {
    	List<Article> articles = new LinkedList<Article>();

    	articles.add( new Article("Title 1", "Text 1", new Date(), "Author 1"));
    	articles.add( new Article("Title 2", "Text 2", new Date(), "Author 2"));
    	articles.add( new Article("Title 3", "Text 3", new Date(), "Author 3"));
        render(articles);
    }

    public static void themes() {
    	List<String> themes = new LinkedList<String>();
    	themes.add("Java");
    	themes.add("PHP");
    	themes.add("C++");
    	themes.add("HTML");
    	themes.add("JavaScript");
    	render(themes);
    }
}