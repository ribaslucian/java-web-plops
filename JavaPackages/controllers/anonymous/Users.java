package controllers.anonymous;

import java.util.HashMap;
import lib.App;
import lib.Session;

public class Users {

    public void login() throws Exception {
        App.getView().render("anonymous/users/login.jsp");
    }

    public void createsession() throws Exception {
        String userRequest = App.getRequest().getParameter("user");
        String passwordRequest = App.getRequest().getParameter("password");

        HashMap<String, String> userMap = App.getUser().get(userRequest);

        if (userMap == null) {
            App.getView().render("anonymous/users/errors/login.jsp");
            return;
        }

        if (!userMap.get("password").equals(passwordRequest)) {
            App.getView().render("anonymous/users/errors/login.jsp");
            return;
        }
        
        Session.set("user", userRequest);
        Session.set("authorized", new Boolean(true));
        Session.set("hierarchy", userMap.get("hierarchy"));
        
        App.getRoute().go("/" + userMap.get("hierarchy") + "/hello/index");
    }

}
