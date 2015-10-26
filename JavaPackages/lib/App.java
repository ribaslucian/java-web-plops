package lib;

import controllers.BeforeFilter;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class App {
    
    public HttpServletRequest request;
    public HttpServletResponse response;
    
    public View view;
    public Url url;
    public Route route;
    public Cook cook;
    public User user;
    public Reflexion reflexion;
    public Html html;
    
    public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;

        // Initializing app elements
        view = new View();
        url = new Url();
        route = new Route();
        cook = new Cook();
        user = new User();
        reflexion = new Reflexion();
        html = new Html();
    }
    
    public static App get() {
        return (App) Session.get("app");
    }
    
    public static HttpServletRequest getRequest() {
        return App.get().request;
    }
    
    public static HttpServletResponse getResponse() {
        return App.get().response;
    }
    
    public static View getView() {
        return App.get().view;
    }
    
    public static Route getRoute() {
        return App.get().route;
    }
    
    public static Url getUrl() {
        return App.get().url;
    }
    
    public static Cook getCook() {
        return App.get().cook;
    }
    
    public static User getUser() {
        return App.get().user;
    }
    
    public static Reflexion getReflexion() {
        return App.get().reflexion;
    }
    
    public static void callController(String controller, String action) {
        App.getReflexion().call("controllers." + controller, action);
    }

    public static Html getHtml() {
        return App.get().html;
    }
    
}
