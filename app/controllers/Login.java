package controllers;

import play.*;
import play.mvc.*;
import play.cache.*;
import java.util.*;

import models.*;

public class Login extends Controller {

    public static void login(String login, String password) {
        if ( login != null && login.equals("testuser")
        	&& password != null && password.equals("test123")) {
        	Cache.set("user", "testuser");

	        redirect("/");
        }
        else {
        	render();
        }
    }
}