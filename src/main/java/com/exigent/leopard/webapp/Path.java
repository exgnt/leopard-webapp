package com.exigent.leopard.webapp;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        public static final String INDEX = "/index/";
        public static final String DASHBOARD = "/dashboard/";
        public static final String PROJECT = "/project/";
		public static final String LOGIN = "/login/";
        public static final String LOGOUT = "/logout/";
        
		public static String getIndex() {
			return INDEX;
		}
		public static String getLogin() {
			return LOGIN;
		}
		public static String getLogout() {
			return LOGOUT;
		}
		public static String getDashboard() {
			return DASHBOARD;
		}
		public static String getProject() {
			return PROJECT;
		}

    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index2.vm";
        public final static String DASHBOARD = "/velocity/index/dashboard.vm";
        //public final static String LOGIN = "/velocity/login/login.vm";
        public final static String LOGIN = "/velocity/login/login-v3.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
		public static final String PROJECT = "/velocity/index/project.vm";
        
		public static String getProject() {
			return PROJECT;
		}
		public static String getIndex() {
			return INDEX;
		}
		public static String getDashboard() {
			return DASHBOARD;
		}
		public static String getLogin() {
			return LOGIN;
		}
		public static String getNotFound() {
			return NOT_FOUND;
		}
    }

}
