/*
 * Copyright 2014 niallquinn
 * ApplicationController.java created Nov 29, 2014
 * WebDevProject
 */
package webApp;

import java.util.ArrayList;

/**
 *
 * @author niallquinn
 */
public class ApplicationController
{
    //Singleton app controller
    private static ApplicationController sharedController;
    
    public static ApplicationController getShared() {
        if (sharedController == null) {
            sharedController = new ApplicationController();
        }
        return sharedController;
    }
    
    private ArrayList<User> users;
    private ArrayList<ClothingPackage> clothingPackages;
    
    public ApplicationController(){
        this.users = new ArrayList<User>();
        this.clothingPackages = new ArrayList<ClothingPackage>();
        
        User userOne = new User("Niall", "Quinn", "22/08/1988", Sex.MALE);
        users.add(userOne);
        System.out.println("User id is " + userOne.getIdentifier());
    }
    
    public ArrayList<User> getUserList() {
        return users;
    }
    
    public User getUserById(int id) {
        for (User u : users) {
            if (u.getIdentifier()==id) {
                return u;
            }
        }
        return null;
    }
    
    public ClothingPackage getPackageById(int id){
        return null;
    }
    
    
    
}
