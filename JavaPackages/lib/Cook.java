package lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.Cookie;

public class Cook {
    
    public Cook() {
        setTimeExecution();
    }
    
    public void add(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60); // One hours
        App.getResponse().addCookie(cookie);
    }
    
    public String get(String name) {
        Cookie[] cookies = App.getRequest().getCookies();
        
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        
        return null;
    }
    
    public void remove(String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);        
        App.getResponse().addCookie(cookie);
    }
    
    public void show() {
        Cookie[] cookies = App.getRequest().getCookies();
        
        for (Cookie cookie : cookies) {
            App.getView().message(cookie.getName() + " >> " + cookie.getValue());
        }
    }
    
    public void setTimeExecution() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        add("time_execution_start", dateFormat.format(cal.getTime()));
    }
    
}
