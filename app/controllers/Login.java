package controllers;

import play.*;
import play.libs.Crypto;
import play.mvc.*;
import play.mvc.Http.Cookie;
import play.cache.*;
import java.util.*;

import models.*;

public class Login extends Controller {

    public static void login(String login, String password) {
        if ( login != null && login.equals("testuser")
        	&& password != null && password.equals("test123")) {
        	response.setCookie("userName", "Test User");
        	redirect("/");
        }
        else {
        	render();
        }
    }
    
    public static void logout() {
        response.removeCookie("userName");
        redirect("/");
    }
}