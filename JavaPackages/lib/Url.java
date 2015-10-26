package lib;

public class Url {

    private String project;

    public Url() {
        setProject();
    }

    public void setProject() {
        project = "http://" + App.getRequest().getServerName() + ":" + App.getRequest().getLocalPort() + App.getRequest().getContextPath() + "/";
        project = project.substring(0, project.length() - 1);
    }

    public String getProject() {
        return project;
    }

}
