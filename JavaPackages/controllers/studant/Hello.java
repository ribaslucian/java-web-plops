package controllers.studant;

import lib.App;

public class Hello {

    public void index() throws Exception {
        App.getView().render("studant/hello/index.jsp");
    }

}
