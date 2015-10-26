package lib;

import java.io.IOException;
import java.util.Arrays;

public class Route {

    private String current = "";

    private String pack;
    private String controller;
    private String action;

    public Route() {
        setCurrent();
        prepare();
    }

    public String getPack() {
        return pack;
    }

    public String getController() {
        return controller;
    }

    public String getAction() {
        return action;
    }

    public String getCurrent() {
        return current;
    }

    private void setCurrent() {
        current = "";
        String route[] = App.getRequest().getRequestURI().split("/");

        if (route.length < 3) {
            current = "/";
        } else {
            for (int i = 2;; i++) {
                if (route.length < i + 1) {
                    return;
                }

                current += "/" + route[i];
            }
        }
    }

    private void prepare() {
        String route = getCurrent().toLowerCase();
        String[] url = route.split("/");

        if (url.length >= 3) {
            pack = url[1];
            action = url[3];

            controller = (String) url[2];
            controller = Character.toString(controller.charAt(0)).toUpperCase() + controller.substring(1);
        }
    }

    public void go(String route) throws IOException {
        App.getResponse().sendRedirect(App.getUrl().getProject() + route);
    }

    public Boolean allowed() throws IOException {
        String hierarchy = Session.getHierarchy();
        
        if (!hierarchy.equals(pack)) {
            go("/" + hierarchy + "/hello/index");
            return false;
        }

        return true;
    }

    public void callController() {
        App.getReflexion().call("controllers." + pack + "." + controller, action);
    }

}
