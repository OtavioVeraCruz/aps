package controllers;

import play.mvc.*;
import play.*;
//import project.models.*;
import models.base.*;

public class TestController extends Controller {

    public Result test()
    {
        User user = new User();
        user.setCpf("10511111111");
        user.setName("asdf");
        return ok(index.render("user name" + user.getName()) );
    }
}
