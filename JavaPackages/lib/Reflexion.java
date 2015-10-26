package lib;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.RuntimeErrorException;

public class Reflexion {

    public void call(String className, String method) {
        try {
            Class cl = Class.forName(className);
            Object o = cl.newInstance();
            cl.getMethod(method, null).invoke(o, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

}
