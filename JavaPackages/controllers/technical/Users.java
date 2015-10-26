package controllers.technical;

import controllers.studant.*;
import java.io.IOException;
import lib.*;

public class Users {

    public void logout() throws IOException {
        Session.set("user", null);
        Session.set("hierarchy", null);
        Session.set("authorized", new Boolean(false));
        
        App.getRoute().go("/technical/hello/index");
    }

}
