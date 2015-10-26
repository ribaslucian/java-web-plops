package tags;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import lib.App;

public class Token extends SimpleTagSupport {

    protected Integer length = 100;

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print(hash());
    }
    
    public static String hash() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
