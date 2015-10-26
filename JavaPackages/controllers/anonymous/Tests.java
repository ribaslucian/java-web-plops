package controllers.anonymous;

import java.util.HashMap;
import lib.App;
import lib.Session;

public class Tests {

    public void jstl() throws Exception {
        App.getView().render("anonymous/tests/jstl.jsp");
    }

}
