package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Singleton;

@Singleton
public class Teste extends Controller {

    public Result birl()
    {
        return ok("Ta saindo da jaula o monstro");
    }
}
