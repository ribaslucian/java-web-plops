package lib;

import controllers.BeforeFilter;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.filters.RequestFilter;

public class Session {

    private static HttpSession session;

    public static void start() {
        HttpServletRequest request = (HttpServletRequest) BeforeFilter.getRequest();
        Session.session = request.getSession(true);

        // Create application instance
        try {
            App app = new App();
            Session.set("app", app);
            app.init(request, (HttpServletResponse) BeforeFilter.getResponse());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void set(String name, Object value) {
        Session.session.setAttribute(name, value);
    }

    public static Object get(String name) {
        return Session.session.getAttribute(name);
    }

    public static void disallow() {
        Session.set("authorized", false);
    }

    public static void authorize() {
        Session.set("authorized", true);
    }

    public static Boolean authorized() {
        Object authorized = (Boolean) Session.get("authorized");

        if (authorized == null) {
            return false;
        }

        return (Boolean) authorized;
    }

    public static String getHierarchy() {
        if (get("hierarchy") == null) {
            return "anonymous";
        }
        
        return (String) get("hierarchy");
    }

    public static String getUser() {
        return (String) get("user");
    }

}
