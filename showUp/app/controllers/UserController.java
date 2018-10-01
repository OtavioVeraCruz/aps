package controllers;

import play.mvc.*;

public class UserController extends Controller{
    public Result index(){

        return ok(views.html.home.render());
    }
}