package controllers;

import play.*;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.*;
import play.mvc.Http.Cookie;

import java.util.*;

import models.*;

public class Articles extends Controller {

    public static void newArticles() {
    	List<Article> articles = Article.newArticles();
        render(articles);
    }
    
    public static void article(Long articleId) {
        Article article = Article.find("byId", articleId).first();
        if ( article == null ) {
            throw new IllegalArgumentException("Article with id = " + articleId + " does not exist");
        }
        
        List<Comment> comments = Comment.find("byArticle", article).fetch();
        render(article, comments);
    }

    public static void themes() {
        List<Section> sections = Section.findAll();
    	render(sections);
    }
    
    public static void postComment(Long articleId, String text) {
        Cookie userCookie = request.cookies.get("userName");
        if ( userCookie != null ) {
            Article article = Article.find("byId", articleId).first();
            
            if ( article != null ) {
                new Comment(text, userCookie.value, article).save();
                article(articleId);
            }
            else newArticles();
        }
        else newArticles();
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