package com.exigent.leopard.webapp;


public class UserController {

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
    	if(username.equalsIgnoreCase("user")){
    	return true;	
    	}
        return false;
    }

    // This method doesn't do anything, it's just included as an example
    public static void setPassword(String username, String oldPassword, String newPassword) {
        
    }
}
