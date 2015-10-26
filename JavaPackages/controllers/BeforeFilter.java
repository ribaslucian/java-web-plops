package controllers;

import controllers.anonymous.Users;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lib.*;
import tags.Token;

@WebFilter(filterName = "BeforeFilter", urlPatterns = {"/*"})

public class BeforeFilter implements Filter {

    private static ServletRequest request;
    private static ServletResponse response;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException  {

        // Create a new instance of the Application and save on Session scope
        BeforeFilter.response(request, response);

        // Check if user is access your area
        if (!App.getRoute().allowed()) {
            return;
        }

        App.getRoute().callController();
    }

    public static void response(ServletRequest request, ServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        BeforeFilter.request = request;
        BeforeFilter.response = response;

        Session.start();
    }

    public static ServletRequest getRequest() {
        return request;
    }

    public static ServletResponse getResponse() {
        return response;
    }

    public void init(FilterConfig filterConfig) {

    }

    public void destroy() {

    }

}
