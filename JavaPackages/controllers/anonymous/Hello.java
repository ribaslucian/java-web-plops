package controllers.anonymous;

import controllers.studant.*;
import java.io.IOException;
import lib.App;

public class Hello {

    public void index() throws IOException {
        App.getRoute().go("/anonymous/users/login");
    }

}
