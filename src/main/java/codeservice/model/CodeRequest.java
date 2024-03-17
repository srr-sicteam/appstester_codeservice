package codeservice.model;

import javax.security.auth.login.Configuration;

public class CodeRequest {
    private String solution;
    private String template;
    private Configuration.Parameters parameters;

    public CodeRequest() {
    }

    public CodeRequest(String solution, String template, Configuration.Parameters parameters) {
        this.solution = solution;
        this.template = template;
        this.parameters = parameters;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Configuration.Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Configuration.Parameters parameters) {
        this.parameters = parameters;
    }

}
