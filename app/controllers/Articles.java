package controllers;

import play.*;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.*;

import java.util.*;

import models.*;

public class Articles extends Controller {

    public static void newArticles() {
    	List<Article> articles = Article.newArticles();
        render(articles);
    }

    public static void themes() {
        List<Section> sections = Section.findAll();
    	render(sections);
    }
    
    public static void articlesForTheme (Long sectionId) {
        List<Article> articles = Article.find("bySection", Section.findById(sectionId)).fetch();
        render("@newArticles", articles);
    }
    
    public static void postArticle(@Valid Article article, @Required Long sectionId) {
        if ( validation.hasErrors() ) {
            List<Section> sections = Section.findAll();
            render("@form", article, sections);
        }
        article.date = new Date();
        article.author = request.cookies.get("userName").value;
        article.section = Section.findById(sectionId);
        article.save();
        newArticles();
    }
    
    public static void form() {
        Article article = new Article("", "", null, "", null);
        List<Section> sections = Section.findAll();
        render(article, sections);
    }
 
}