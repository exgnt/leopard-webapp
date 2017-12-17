package com.exigent.leopard.webapp;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

import org.eclipse.jetty.server.Request;




public class Main {
    public static void main(String[] args) {
    	
    	// Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();
        
     // Set up before-filters (called before each get/post)
        //before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        
        
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.DASHBOARD,      DashController.serveDashboard);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        //get(Path.Web.PROJECT,       ProjectController.serveProject);
        get("/project/:code",       ProjectController.serveProject);
        get("*",                     DashController.serveDashboard);
      
        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);
    }
}