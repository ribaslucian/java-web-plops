package lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class User {

    Properties prop = new Properties();

    public User() throws IOException {
        prop.load(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("/config/users.properties")
        );
    }

    public HashMap<String, String> get(String userName) {
        String user = prop.getProperty(userName);

        if (user == null) {
            return null;
        }

        String[] userParams = user.split("\\|");
        HashMap<String, String> users = new HashMap<>();
        users.put("name", userName);
        users.put("password", userParams[0]);
        users.put("hierarchy", userParams[1]);

        return users;
    }

}
