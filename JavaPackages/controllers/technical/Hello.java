package controllers.technical;

import lib.App;

public class Hello {

    public void index() throws Exception {
        App.getView().render("technical/hello/index.jsp");
    }

}
