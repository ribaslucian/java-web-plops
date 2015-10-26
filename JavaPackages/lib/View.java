package lib;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import controllers.*;
import javax.servlet.ServletException;

public class View {

    private PrintWriter writer;

    public View() throws IOException {
        writer = BeforeFilter.getResponse().getWriter();
    }

    public void message(String message) {
//        writer.write(message);
        writer.print(message);
    }
    
    public void jspMessage() {
        
    }

    public void render(String view) throws Exception {
        try {
            App.getRequest().getRequestDispatcher("/views/" + view).include(BeforeFilter.getRequest(), BeforeFilter.getResponse());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
